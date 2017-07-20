package service;

import model.Book;

import java.util.List;

/**
 * Created by Alex on 20.07.2017.
 */
public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookByID(int id);
    public void removeBook(int id);
}
