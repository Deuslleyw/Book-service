package com.Deusley.bookservice.repository;

import com.Deusley.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> { }
