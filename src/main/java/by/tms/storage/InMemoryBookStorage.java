package by.tms.storage;

import by.tms.model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage {
    private static List<Book> books = new ArrayList<>();

    private static InMemoryBookStorage inMemoryBookStorage;

    private InMemoryBookStorage() {

    }

    public static InMemoryBookStorage getInstance() {
       if (inMemoryBookStorage == null) {
           InMemoryBookStorage inMemoryBookStorage = new InMemoryBookStorage();
           return inMemoryBookStorage;
       } else {
           return inMemoryBookStorage;
       }
    }

    static {
        books.add(new Book(1, "Brave New World", "Now more than ever: Aldous Huxley's enduring masterwork must be read and understood by anyone concerned with preserving the human spirit", 22));
        books.add(new Book(2, "Fahrenheit 451", "Sixty years after its originally publication, Ray Bradbury’s internationally acclaimed novel Fahrenheit 451 stands as a classic of world literature set in a bleak, dystopian future. Today its message has grown more relevant than ever before", 23));
        books.add(new Book(3, "1984", "Written more than 70 years ago, 1984 was George Orwell’s chilling prophecy about the future. And while 1984 has come and gone, his dystopian vision of a government that will do anything to control the narrative is timelier than ever...", 24));
        books.add(new Book(4, "The Old Man and The Sea", "The Old Man and the Sea is one of Hemingway's most enduring works. Told in language of great simplicity and power, it is the story of an old Cuban fisherman, down on his luck, and his supreme ordeal -- a relentless, agonizing battle with a giant marlin far out in the Gulf Stream", 25));
        books.add(new Book(5, "The Great Gatsby", "Regarded as Fitzgerald's masterpiece and one of the greatest novels of American literature, The Great Gatsby is a vivid chronicle of the excesses and decadence of the “Jazz Age”, as well as a timeless cautionary critique of the American dream", 26));
        books.add(new Book(6, "Clean Code", "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way", 27));
    }

    public List<Book> getAll() {
        return new ArrayList<>(books);
    }

    public Book getById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
