package com.Deusley.bookservice.controller;

import com.Deusley.bookservice.model.Book;
import com.Deusley.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(

            @PathVariable ("id") Long id,
            @PathVariable ("currency") String currency
    ){

        var book = repository.getReferenceById(id);

        if(book == null) throw new RuntimeException("Book not Found, please retry");

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);

        return book;
    }
}
