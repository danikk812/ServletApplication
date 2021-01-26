package by.tms.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Book> list = new ArrayList<>();

    public void addBook(Book book) {
        list.add(book);
    }

    public List<Book> getAll() {
        return new ArrayList<>(list);
    }

    public void deleteBook(Book book) {
        list.remove(book);
    }

    public Book getById(int id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
