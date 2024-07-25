package com.ibrahim.java.unit.test.business.abstracts;

import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;

import java.util.List;

public interface BookService {
    ResponseAddBook addBook(RequestAddBook requestAddBook);
    ResponseGetBookByName getBookByName(RequestGetBookByName requestGetBookByName);
    ResponseGetBookById getBookById(RequestGetBookById requestGetBookById);
    ResponseUpdateBook updateBook(RequestUpdateBook requestUpdateBook);
    List<ResponseGetAllBook> getAllBooks();

}
