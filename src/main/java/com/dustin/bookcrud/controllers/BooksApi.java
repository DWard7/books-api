package com.dustin.bookcrud.controllers;

import com.dustin.bookcrud.models.Book;
import com.dustin.bookcrud.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksApi {

  @Autowired
  BookService bookService;

  // private final BookService bookService;
  // public BooksApi(BookService bookService){
  //   this.bookService = bookService;
  // }

  @RequestMapping("/api/books")
  public List<Book> booksApi() {
    List<Book> books = bookService.allBooks();
    return books;
  }
}
