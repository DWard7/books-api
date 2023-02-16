package com.dustin.bookcrud.services;

import com.dustin.bookcrud.models.Book;
import com.dustin.bookcrud.repositories.BookRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;
  
  //! CREATE

  public void createBook(Book book){
    bookRepository.save(book);
  }

  //! READ ALL
  public List<Book> allBooks() {
    return bookRepository.findAll();
  }

  //! READ ONE
  public Book oneBook(Long id){
    Optional<Book> optionalBook = bookRepository.findById(id);
    return optionalBook.orElse(null);
  }
  
  //! UPDATE
  public void updateBook(Book book){
    bookRepository.save(book);
  }

  public void deleteBook(Book book) {
    bookRepository.delete(book);
  }
}
