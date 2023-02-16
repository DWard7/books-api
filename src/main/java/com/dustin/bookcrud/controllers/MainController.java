package com.dustin.bookcrud.controllers;

import com.dustin.bookcrud.models.Book;
import com.dustin.bookcrud.services.BookService;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  // ArrayList<Book> books = new ArrayList<>();
  @Autowired
  BookService bookService;

  //! CREATE
  @RequestMapping("books/new")
  public String newBook(@ModelAttribute("book") Book book) {
    return "new.jsp";
  }

  @PostMapping("/books")
  public String createBook(
    @ModelAttribute("book") Book book
    // @RequestParam("title") String title,
    // @RequestParam("author") String author,
    // @RequestParam("pages") Integer pages,
    // HttpSession session

  ) {
    bookService.createBook(book);
    return "redirect:/";
  }

  //! READ ALL
  @RequestMapping("/")
  public String index(Model model) {
    List<Book> books = bookService.allBooks();
    System.out.println(books);
    model.addAttribute("books", books);
    return "index.jsp";
  }

  //! READ ONE

  @GetMapping("/books/{id}")
  public String show(@PathVariable("id") Long id, Model model) {
    Book book = bookService.oneBook(id);
    model.addAttribute("book", book);
    return "show.jsp";
  }

  //! UPDATE
  @GetMapping("/books/edit/{id}")
  public String edit(@PathVariable("id") Long id, Model model) {
    Book book = bookService.oneBook(id);
    model.addAttribute("book", book);
    return "edit.jsp";
  }

  @PutMapping("/books/{id}")
  public String update(@ModelAttribute("book") Book book) {
    bookService.updateBook(book);
    return "redirect:/";
  }

  //! DELETE
  @DeleteMapping("/books/{id}")
  public String delete(@PathVariable("id") Long id) {
    Book book = bookService.oneBook(id);
    bookService.deleteBook(book);
    return "redirect:/";
  }
}
