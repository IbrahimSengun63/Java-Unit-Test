package com.ibrahim.java.unit.test.mappers.book;

import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;
import com.ibrahim.java.unit.test.entities.Book;

import java.util.List;

public interface BookMapper {
    Book requestAddBookToBook(RequestAddBook requestAddBook);
    Book requestGetBookByNameToBook(RequestGetBookByName requestGetBookByName);
    Book requestGetBookById(RequestGetBookById requestGetBookById);
    Book requestUpdateBookToBook(RequestUpdateBook requestUpdateBook);


    ResponseAddBook bookToResponseAddBook(Book book);
    RequestGetBookById bookToResponseGetBookById(Book book);
    ResponseGetBookByName bookToResponseGetBookByName(Book book);
    ResponseUpdateBook bookToResponseUpdateBook(Book book);

    List<ResponseGetAllBook> booksToResponseGetAllBook(List<Book> books);
}
