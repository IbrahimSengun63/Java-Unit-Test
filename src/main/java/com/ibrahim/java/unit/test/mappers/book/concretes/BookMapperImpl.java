package com.ibrahim.java.unit.test.mappers.book.concretes;

import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;
import com.ibrahim.java.unit.test.entities.Book;
import com.ibrahim.java.unit.test.mappers.book.abstracts.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapperImpl implements BookMapper {
    @Override
    public Book requestAddBookToBook(RequestAddBook requestAddBook) {
        Book book = new Book();
        book.setName(requestAddBook.getName());
        book.setAvailable(requestAddBook.isAvailable());
        return book;
    }

    @Override
    public Book requestGetBookByNameToBook(RequestGetBookByName requestGetBookByName) {
        Book book = new Book();
        book.setName(requestGetBookByName.getName());
        return book;
    }

    @Override
    public Book requestGetBookByIdToBook(RequestGetBookById requestGetBookById) {
        Book book = new Book();
        book.setId(requestGetBookById.getId());
        return book;
    }

    @Override
    public Book requestUpdateBookToBook(RequestUpdateBook requestUpdateBook) {
        Book book = new Book();
        book.setId(requestUpdateBook.getId());
        book.setAvailable(requestUpdateBook.isAvailable());
        book.setName(requestUpdateBook.getName());
        return book;
    }

    @Override
    public ResponseAddBook bookToResponseAddBook(Book book) {
        ResponseAddBook responseAddBook = new ResponseAddBook();
        responseAddBook.setName(book.getName());
        responseAddBook.setAvailable(book.isAvailable());
        return responseAddBook;
    }

    @Override
    public com.ibrahim.java.unit.test.dtos.book.responses.ResponseGetBookById bookToResponseGetBookById(Book book) {
        com.ibrahim.java.unit.test.dtos.book.responses.ResponseGetBookById responseGetBookById = new com.ibrahim.java.unit.test.dtos.book.responses.ResponseGetBookById();
        responseGetBookById.setName(book.getName());
        responseGetBookById.setAvailable(book.isAvailable());
        return responseGetBookById;
    }

    @Override
    public ResponseGetBookByName bookToResponseGetBookByName(Book book) {
        ResponseGetBookByName responseGetBookByName = new ResponseGetBookByName();
        responseGetBookByName.setName(book.getName());
        responseGetBookByName.setAvailable(book.isAvailable());
        return responseGetBookByName;
    }

    @Override
    public ResponseUpdateBook bookToResponseUpdateBook(Book book) {
        ResponseUpdateBook responseUpdateBook = new ResponseUpdateBook();
        responseUpdateBook.setId(book.getId());
        responseUpdateBook.setName(book.getName());
        responseUpdateBook.setAvailable(book.isAvailable());
        return responseUpdateBook;

    }

    @Override
    public List<ResponseGetAllBook> booksToResponseGetAllBook(List<Book> books) {
        /*
        List<ResponseGetAllBook> responseGetAllBooks = new ArrayList<>();

        for (Book book : books) {
            ResponseGetAllBook responseGetAllBook = new ResponseGetAllBook();
            responseGetAllBook.setId(book.getId());
            responseGetAllBook.setName(book.getName());
            responseGetAllBook.setAvailable(book.isAvailable());
            responseGetAllBooks.add(responseGetAllBook);
        }
        //return responseGetAllBooks;
        */

        return books.stream().map(book -> new ResponseGetAllBook(
                book.getId(),
                book.getName(),
                book.isAvailable()
        )).collect(Collectors.toList());

    }
}
