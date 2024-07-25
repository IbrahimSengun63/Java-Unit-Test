package com.ibrahim.java.unit.test.business.concretes;

import com.ibrahim.java.unit.test.business.abstracts.BookService;
import com.ibrahim.java.unit.test.dataAccess.BookRepository;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;
import com.ibrahim.java.unit.test.entities.Book;
import com.ibrahim.java.unit.test.mappers.book.abstracts.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public ResponseAddBook addBook(RequestAddBook requestAddBook) {
        Book book = this.bookMapper.requestAddBookToBook(requestAddBook);
        Book savedBook = this.bookRepository.save(book);
        return this.bookMapper.bookToResponseAddBook(savedBook);
    }

    @Override
    public ResponseGetBookByName getBookByName(RequestGetBookByName requestGetBookByName) {
        Book book = this.bookMapper.requestGetBookByNameToBook(requestGetBookByName);
        Book getBook = this.bookRepository.findByName(book.getName());
        return this.bookMapper.bookToResponseGetBookByName(getBook);
    }

    @Override
    public ResponseGetBookById getBookById(RequestGetBookById requestGetBookById) {
        Book book = this.bookMapper.requestGetBookByIdToBook(requestGetBookById);
        Book getBook = this.bookRepository.findById(book.getId()).orElseThrow();
        return this.bookMapper.bookToResponseGetBookById(getBook);
    }

    @Override
    public ResponseUpdateBook updateBook(RequestUpdateBook requestUpdateBook) {
        Book book = this.bookMapper.requestUpdateBookToBook(requestUpdateBook);
        Book updatedBook = this.bookRepository.save(book);
        return this.bookMapper.bookToResponseUpdateBook(updatedBook);
    }

    @Override
    public List<ResponseGetAllBook> getAllBooks() {
        List<Book> books = this.bookRepository.findAll();
        return this.bookMapper.booksToResponseGetAllBook(books);
    }
}
