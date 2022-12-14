package com.gad.java.rares.assignments.oop_principles_1.app;

import com.gad.java.rares.assignments.oop_principles_1.models.Album;
import com.gad.java.rares.assignments.oop_principles_1.models.Book;
import com.gad.java.rares.assignments.oop_principles_1.models.Novel;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static final String ABORT = "abort";
    public static final String BOOK_INSERTION_ABORTED = "Book insertion aborted!";
    public static final String BOOK_DELETION_ABORTED = "Book deletion aborted!";
    public static final String BOOK_ALREADY_EXISTS = "Book already exists!";
    static Map<BookType, Set<Book>> libraryContent = new HashMap<>();
    private enum BookType {
        ALBUM,
        NOVEL
    }
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Rares's Library!" );
        boolean isStarted = false;
        libraryContent.put(BookType.ALBUM,new HashSet());
        libraryContent.put(BookType.NOVEL,new HashSet<>());

        while(true){
            if(!isStarted){
                System.out.println("What do you want to do?:");
                isStarted = true;
            }


            System.out.println("1:Add a new book");
            System.out.println("2:See all the books");
            System.out.println("3:Delete a book");
            System.out.println("4:Exit Library");
            System.out.print("Action:");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine().trim();
            if(option.equals("1")){
                addBook();
                isStarted = false;
            }else if(option.equals("2")){
                displayBooks();
                isStarted = false;
            }else if(option.equals("3")){
                deleteBook();
            }else if(option.equals("4")){
                break;
            }else{
                System.out.println("Invalid Command...");
            }
        }

        System.out.println("Exiting Library app...");
        System.out.println("Goodbye!");
    }

    private static void addBook() {
        Scanner scanner;
        String option;
        while(true){
            System.out.println("\nWhat type of book do you want to add?");
            System.out.println("1:Album");
            System.out.println("2:Novel");
            System.out.print("Enter option 1/2 or exit:");
            scanner = new Scanner(System.in);
            option = scanner.nextLine().trim();
            if(option.equals("exit"))
                break;
            if(option.equals("1")){
                boolean isAdded = addBook(BookType.ALBUM);
                if(isAdded){
                    System.out.println("Added an album succesfully!\n");
                }
                break;
            }else if (option.equals("2")){
                boolean isAdded = addBook(BookType.NOVEL);
                if(isAdded){
                    System.out.println("Added a novel succesfully!\n");
                }
                break;
            } else {
                System.out.println("Invalid Command...");
            }
        }
    }

    private static boolean addBook(BookType bookType) {
        String name = getBookName();
        if(name.equals(ABORT)){
            System.out.println(BOOK_INSERTION_ABORTED);
            return false;
        }
        boolean bookExists = isBookPresent(name);

        if(bookExists)
            return false;

        int numberOfPages = getNumberOfPages();

        if(numberOfPages == -1)
            return false;

        if(bookType.equals(BookType.ALBUM)){
           return addAlbum(name, numberOfPages);
        }else {
           return addNovel(name, numberOfPages);
        }

    }

    private static boolean isBookPresent(String name) {
       for(Map.Entry<BookType,Set<Book>>entry: libraryContent.entrySet()){
           Set<Book> bookSet = entry.getValue();
           Iterator<Book> iterator = bookSet.iterator();
           while (iterator.hasNext()){
               Book book = iterator.next();
               if(book.getName().toUpperCase(Locale.ROOT).equals(name.toUpperCase(Locale.ROOT))){
                   System.out.println(BOOK_ALREADY_EXISTS);
                   return true;
               }
           }
       }
       return false;
    }

    private static String getBookName() {
        while(true){
            System.out.println("\nInsert a book name (or exit via abort):");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine().trim();
            if(name.isEmpty() || name.isBlank()){
                continue;
            }
            return name;
        }
    }

    private static int getNumberOfPages() {
        while(true){
            System.out.print("\nInsert number of pages (or exit via abort):");
            Scanner scanner = new Scanner(System.in);
            try {
                String inValue = scanner.nextLine().trim();
                if(inValue.equals(ABORT)){
                    System.out.println(BOOK_INSERTION_ABORTED);
                    return -1;
                }
                int numberOfPages = Integer.valueOf(inValue);
                if(numberOfPages<=0){
                    System.out.println("Number of pages must be greater than 0!");
                    continue;
                }
                return numberOfPages;
            }catch (Exception ex){
                //  ex.printStackTrace();  -- Because this is a simple example we only print to the console that the user must input a valid integer
                System.out.println("You must provide a number!");
            }
        }
    }

    private static boolean addAlbum(String name, int numberOfPages) {
        Set<Book> albumSet = libraryContent.get(BookType.ALBUM);
        if(!albumSet.isEmpty()){
            for(Book book: albumSet){
                if(book.getName().toUpperCase(Locale.ROOT).equals(name.toUpperCase(Locale.ROOT))){
                    System.out.println("Book already exists in the library");
                    return false;
                }
            }
        }
        int index = 0;
        Album.Quality[] qualities = Album.Quality.values();
        for(Album.Quality quality:qualities){
            System.out.printf("%d:%s\n",index++,quality);
        }
        while(true){
            System.out.print("Choose a paper quality (by the numbers) (or exit via abort):");
            Scanner  scanner = new Scanner(System.in);
            try {
                String inValue = scanner.nextLine().trim();
                if(inValue.equals(ABORT)){
                    System.out.println(BOOK_INSERTION_ABORTED);
                    return false;
                }
                int paperQualityIndex = Integer.parseInt(inValue);
                if(paperQualityIndex>qualities.length){
                    continue;
                }
                Book newBook = new Album(name, numberOfPages, qualities[paperQualityIndex]);
                libraryContent.get(BookType.ALBUM).add(newBook);
                return true;
            }catch (Exception ex){
                //  ex.printStackTrace();  -- Because this is a simple example we only print to the console that the user must input a valid integer
                System.out.println("You must provide a number from the list above!");
            }
        }
    }

    private static boolean addNovel(String name, int numberOfPages) {
        Set<Book> novelSet = libraryContent.get(BookType.NOVEL);
        if(!novelSet.isEmpty()){
            for(Book book: novelSet){
                if(book.getName().toUpperCase(Locale.ROOT).equals(name.toUpperCase(Locale.ROOT))){
                    System.out.println("Book already exists in the library");
                    return false;
                }
            }
        }
        int index = 0;
        Novel.Type[] types = Novel.Type.values();
        for(Novel.Type type:types){
            System.out.printf("%d:%s\n",index++,type);
        }
        while(true){
            System.out.print("\nChoose one of the above (by numbers) (or exit via abort):");
           Scanner scanner = new Scanner(System.in);
            try{
                String inValue = scanner.nextLine().trim();
                if(inValue.equals(ABORT)){
                    System.out.println(BOOK_INSERTION_ABORTED);
                    return false;
                }
                int novelTypeIndex = Integer.parseInt(inValue);
                if(novelTypeIndex>types.length){
                    continue;
                }
                Book newBook = new Novel(name, numberOfPages, types[novelTypeIndex]);
                libraryContent.get(BookType.NOVEL).add(newBook);
                return true;
            }catch (Exception ex){
                //  ex.printStackTrace();  -- Because this is a simple example we only print to the console that the user must input a valid integer
                System.out.println("You must provide a number from the list above!");
            }

        }
    }

    private static void displayBooks() {
        boolean isLibraryEmpty = isLibraryEmpty();
        if(isLibraryEmpty){
            return;
        }
        for(Map.Entry<BookType,Set<Book>> libraryEntry: libraryContent.entrySet()){
            System.out.printf("\nDisplaying %sS:%n", libraryEntry.getKey());
            libraryEntry.getValue().forEach(Book::explain);
        }
        System.out.println();
    }

    private static void deleteBook() {

        if (isLibraryEmpty())
            return;

        System.out.println("Deleting a book.");
        String name = getBookName();
        if(name.equals(ABORT)){
            System.out.println(BOOK_DELETION_ABORTED);
            return;
        }

        for(Map.Entry<BookType,Set<Book>>entries : libraryContent.entrySet()){
            Set<Book> bookSet = entries.getValue();
            Iterator<Book> bookIterator = bookSet.iterator();
            while (bookIterator.hasNext()){
                Book book = bookIterator.next();
                if(book.getName().toUpperCase(Locale.ROOT).equals(name.toUpperCase(Locale.ROOT))){
                    bookSet.remove(book);
                    System.out.println("Book removed!\n");
                    return;
                }
            }
        }
        System.out.printf("Book %s was not found!\n\n",name);
    }

    private static boolean isLibraryEmpty() {
        if(libraryContent.get(BookType.NOVEL).isEmpty()&&libraryContent.get(BookType.ALBUM).isEmpty()) {
            System.out.println("Library is empty\n");
            return true;
        }
        return false;
    }

}
