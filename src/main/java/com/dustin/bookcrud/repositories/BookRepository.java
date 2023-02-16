package com.dustin.bookcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dustin.bookcrud.models.Book;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
  List<Book> findAll();
  

}
