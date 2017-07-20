package service;

import dao.BookDao;
import model.Book;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Alex on 20.07.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transient
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transient
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transient
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Override
    @Transient
    public Book getBookByID(int id) {
        return bookDao.getBookByID(id);
    }

    @Override
    @Transient
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }
}
