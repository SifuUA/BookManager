package com.okres.bookmanager.dao;

import com.okres.bookmanager.model.Book;

import java.util.List;

/**
 * Created by Alex on 18.07.2017.
 */
public interface BookDao {

    public void add(Book book);

    public void update(Book book);

    public void remove(Long id);

    public Book getBookById(Long id);

    public List<Book> listBooks();
}
