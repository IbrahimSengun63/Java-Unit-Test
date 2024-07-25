package com.ibrahim.java.unit.test.business.abstracts;

import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.ResponseAddBook;
import com.ibrahim.java.unit.test.dtos.book.responses.ResponseGetAllBook;
import com.ibrahim.java.unit.test.dtos.book.responses.ResponseGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.responses.ResponseUpdateBook;
import com.ibrahim.java.unit.test.entities.Book;

import java.util.List;

public interface BookService {
    ResponseAddBook addBook(RequestAddBook requestAddBook);
    ResponseGetBookByName getBookByName(RequestGetBookByName requestGetBookByName);
    RequestGetBookById getBookById(RequestGetBookById requestGetBookById);
    ResponseUpdateBook updateBook(RequestUpdateBook requestUpdateBook);
    List<ResponseGetAllBook> getAllBooks();

}
