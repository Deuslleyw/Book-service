package com.Deusley.bookservice.controller;

import com.Deusley.bookservice.model.Book;
import com.Deusley.bookservice.proxy.CambioProxy;
import com.Deusley.bookservice.repository.BookRepository;
import com.Deusley.bookservice.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(

            @PathVariable ("id") Long id,
            @PathVariable ("currency") String currency
    ){

        var book = repository.getReferenceById(id);
        if(book == null) throw new RuntimeException("Book not Found, please retry");

        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port +  "FEIGN");
        book.setPrice(cambio.getConvertedValue());

        return book;

    }
}
