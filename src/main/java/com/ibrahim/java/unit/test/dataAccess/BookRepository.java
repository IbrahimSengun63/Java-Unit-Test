package com.ibrahim.java.unit.test.dataAccess;

import com.ibrahim.java.unit.test.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
