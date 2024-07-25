package com.ibrahim.java.unit.test.webApi;

import com.ibrahim.java.unit.test.business.abstracts.BookService;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;
import com.ibrahim.java.unit.test.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseAddBook> addBook(@RequestBody RequestAddBook requestAddBook) {
        ResponseAddBook responseAddBook = this.bookService.addBook(requestAddBook);
        return ResponseEntity.ok().body(responseAddBook);
    }

    @GetMapping("/getBookByName")
    public  ResponseEntity<ResponseGetBookByName> getBookByName(@RequestParam String name) {
        RequestGetBookByName requestGetBookByName = new RequestGetBookByName();
        requestGetBookByName.setName(name);
        ResponseGetBookByName responseGetBookByName = this.bookService.getBookByName(requestGetBookByName);
        return ResponseEntity.ok().body(responseGetBookByName);
    }

    @GetMapping("/getBookById")
    public  ResponseEntity<ResponseGetBookById> getBookById(@RequestParam int id) {
        RequestGetBookById requestGetBookById = new RequestGetBookById();
        requestGetBookById.setId(id);
        ResponseGetBookById responseGetBookById = this.bookService.getBookById(requestGetBookById);
        return ResponseEntity.ok().body(responseGetBookById);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseUpdateBook> updateBook(@RequestBody RequestUpdateBook requestUpdateBook) {
        ResponseUpdateBook responseUpdateBook = this.bookService.updateBook(requestUpdateBook);
        return ResponseEntity.ok().body(responseUpdateBook);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseGetAllBook>> getAllBook() {
        List<ResponseGetAllBook> responseGetAllBooks = this.bookService.getAllBooks();
        return ResponseEntity.ok().body(responseGetAllBooks);
    }
}
