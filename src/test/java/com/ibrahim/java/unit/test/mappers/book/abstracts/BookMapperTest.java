package com.ibrahim.java.unit.test.mappers.book.abstracts;

import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;
import com.ibrahim.java.unit.test.entities.Book;
import com.ibrahim.java.unit.test.mappers.book.concretes.BookMapperImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    private BookMapper mapper;
    private Book book;
    private RequestAddBook requestAddBook;
    private RequestGetBookById requestGetBookById;
    private RequestGetBookByName requestGetBookByName;
    private RequestUpdateBook requestUpdateBook;
    private ResponseAddBook responseAddBook;
    private ResponseGetBookById responseGetBookById;
    private ResponseGetBookByName responseGetBookByName;
    private ResponseUpdateBook responseUpdateBook;
    private ResponseGetAllBook responseGetAllBook;

    @BeforeEach
    void setUp() {
        mapper = new BookMapperImpl();
        book = new Book();
        requestAddBook = new RequestAddBook();
        requestGetBookById = new RequestGetBookById();
        requestGetBookByName = new RequestGetBookByName();
        requestUpdateBook = new RequestUpdateBook();
        responseAddBook = new ResponseAddBook();
        responseGetBookById = new ResponseGetBookById();
        responseGetBookByName = new ResponseGetBookByName();
        responseUpdateBook = new ResponseUpdateBook();
        responseGetAllBook = new ResponseGetAllBook();
    }

    @AfterEach
    void tearDown() {
        mapper = null;
        book = null;
        requestAddBook = null;
        requestGetBookById = null;
        requestGetBookByName = null;
        requestUpdateBook = null;
        responseAddBook = null;
        responseGetBookById = null;
        responseGetBookByName = null;
        responseUpdateBook = null;
        responseGetAllBook = null;
    }

    @Test
    void shouldRequestAddBookMapToBook() {
        requestAddBook.setName("a");
        requestAddBook.setAvailable(false);
        book = mapper.requestAddBookToBook(requestAddBook);
        assertEquals(requestAddBook.getName(), book.getName());
        assertFalse(book.isAvailable());
    }

    @Test
    void shouldRequestGetBookByNameMapToBook() {
        requestGetBookByName.setName("a");
        book = mapper.requestGetBookByNameToBook(requestGetBookByName);
        assertEquals(requestGetBookByName.getName(),book.getName());
    }

    @Test
    void shouldRequestGetBookByIdMapToBook() {
        requestGetBookById.setId(1);
        book = mapper.requestGetBookByIdToBook(requestGetBookById);
        assertEquals(requestGetBookById.getId(),book.getId());
    }

    @Test
    void shouldRequestUpdateBookMapToBook() {
        requestUpdateBook.setId(1);
        requestUpdateBook.setName("sdadasd");
        requestUpdateBook.setAvailable(true);
        book = mapper.requestUpdateBookToBook(requestUpdateBook);
        assertEquals(requestUpdateBook.getId(),book.getId());
        assertEquals(requestUpdateBook.getName(),book.getName());
        assertEquals(requestUpdateBook.isAvailable(),book.isAvailable());
    }

    @Test
    void shouldBookMapToResponseAddBook() {
        book.setName("a");
        book.setAvailable(true);
        responseAddBook = mapper.bookToResponseAddBook(book);
        assertEquals(book.getName(),responseAddBook.getName());
        assertEquals(book.isAvailable(),responseAddBook.isAvailable());
    }

    @Test
    void shouldBookMapToResponseGetBookById() {
        book.setName("asdasda");
        book.setAvailable(false);
        responseGetBookById = mapper.bookToResponseGetBookById(book);
        assertEquals(book.getName(),responseGetBookById.getName());
        assertEquals(book.isAvailable(),responseGetBookById.isAvailable());
    }

    @Test
    void shouldBookMapToResponseGetBookByName() {
        book.setName("qweqweq");
        book.setAvailable(false);
        responseGetBookByName = mapper.bookToResponseGetBookByName(book);
        assertEquals(book.getName(),responseGetBookByName.getName());
        assertEquals(book.isAvailable(),responseGetBookByName.isAvailable());
    }

    @Test
    void shouldBookMapToResponseUpdateBook() {
        book.setId(2);
        book.setName("Nothing else matter");
        book.setAvailable(false);
        responseUpdateBook = mapper.bookToResponseUpdateBook(book);
        assertEquals(book.getId(),responseUpdateBook.getId());
        assertEquals(book.getName(),responseUpdateBook.getName());
        assertEquals(book.isAvailable(),responseUpdateBook.isAvailable());

    }

    @Test
    void booksToResponseGetAllBook() {
        List<Book> books = new ArrayList<>();

        book.setId(3);
        book.setName("and everything else is... ");
        book.setAvailable(true);
        books.add(book);

        Book book1 = new Book();
        book1.setId(4);
        book1.setName("maybe, hope so");
        book1.setAvailable(false);
        books.add(book1);

        List<ResponseGetAllBook> responseGetAllBooks = mapper.booksToResponseGetAllBook(books);
        assertEquals(book.getId(),responseGetAllBooks.getFirst().getId());
        assertEquals(book.getName(),responseGetAllBooks.getFirst().getName());
        assertEquals(book.isAvailable(),responseGetAllBooks.getFirst().isAvailable());

        assertEquals(book1.getId(),responseGetAllBooks.getLast().getId());
        assertEquals(book1.getName(),responseGetAllBooks.getLast().getName());
        assertEquals(book1.isAvailable(),responseGetAllBooks.getLast().isAvailable());
    }
}