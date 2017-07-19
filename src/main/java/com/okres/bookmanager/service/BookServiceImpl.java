package com.okres.bookmanager.service;

import com.okres.bookmanager.dao.BookDao;
import com.okres.bookmanager.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alex on 18.07.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void add(Book book) {
        this.bookDao.add(book);
    }

    @Override
    @Transactional

    public void update(Book book) {
        this.bookDao.update(book);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        this.bookDao.remove(id);
    }

    @Override
    @Transactional
    public Book getBookById(Long id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }
}
