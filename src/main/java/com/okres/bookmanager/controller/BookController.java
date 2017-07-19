package com.okres.bookmanager.controller;

import com.okres.bookmanager.model.Book;
import com.okres.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alex on 18.07.2017.
 */
@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if (book.getId() == 0){
            this.bookService.add(book);
        }else {
            this.bookService.update(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id){
        this.bookService.remove(id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }

}
