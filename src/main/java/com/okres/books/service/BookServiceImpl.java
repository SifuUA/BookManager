package com.okres.books.service;

import com.okres.books.dao.BookDao;
import com.okres.books.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transactional

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional

    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Override
    @Transactional

    public Book getBookByID(int id) {
        return bookDao.getBookByID(id);
    }

    @Override
    @Transactional

    public void removeBook(int id) {
        bookDao.removeBook(id);
    }
}
