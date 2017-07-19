package com.okres.bookmanager.dao;

import com.okres.bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 18.07.2017.
 */

@Repository
public class BookDaoImpl implements BookDao{

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully added. Book details " + book);
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully update. Book details " + book);
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Long(id));

        if (book != null){
            session.delete(book);
            logger.info("Book successfully deleted. Book details " + book);
        }
    }

    @Override
    public Book getBookById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Long (id));
        logger.info("Book successfully loaded. Book details " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        for (Book book : bookList){
            logger.info("Book list " + book);
        }
        return bookList;
    }
}
