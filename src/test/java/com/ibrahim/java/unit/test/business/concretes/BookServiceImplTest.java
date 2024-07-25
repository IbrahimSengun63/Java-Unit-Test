package com.ibrahim.java.unit.test.business.concretes;

import com.ibrahim.java.unit.test.dataAccess.BookRepository;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestAddBook;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookById;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestGetBookByName;
import com.ibrahim.java.unit.test.dtos.book.requests.RequestUpdateBook;
import com.ibrahim.java.unit.test.dtos.book.responses.*;
import com.ibrahim.java.unit.test.entities.Book;
import com.ibrahim.java.unit.test.mappers.book.abstracts.BookMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookRepository bookRepository;
    @Mock
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
        MockitoAnnotations.openMocks(this);
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
    void shouldAddBook() {
        // Mock the request add book --Map-- Book call
        requestAddBook.setName("asdad");
        requestAddBook.setAvailable(false);
        book.setName(requestAddBook.getName());
        book.setAvailable(requestAddBook.isAvailable());
        when(mapper.requestAddBookToBook(requestAddBook)).thenReturn(book);

        // Mock the Book save to the repository
        Book savedBook = new Book();
        savedBook.setId(1);
        savedBook.setName(book.getName());
        savedBook.setAvailable(book.isAvailable());
        when(bookRepository.save(book)).thenReturn(savedBook);

        // Mock the saved book to the response book
        responseAddBook.setName(savedBook.getName());
        responseAddBook.setAvailable(savedBook.isAvailable());
        when(mapper.bookToResponseAddBook(savedBook)).thenReturn(responseAddBook);

        // Test service function
        ResponseAddBook actualResponse = bookService.addBook(requestAddBook);
        assertNotNull(actualResponse);
        assertEquals(requestAddBook.getName(), actualResponse.getName());
        assertEquals(requestAddBook.isAvailable(), actualResponse.isAvailable());

        // Make sure there isn't any duplicate calls
        Mockito.verify(mapper, Mockito.times(1)).requestAddBookToBook(requestAddBook);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
        Mockito.verify(mapper, Mockito.times(1)).bookToResponseAddBook(savedBook);


    }

    @Test
    void shouldGetBookByName() {
        // Mock to get book from request get book by name
        requestGetBookByName.setName("asdasd");
        book.setName(requestGetBookByName.getName());
        when(mapper.requestGetBookByNameToBook(requestGetBookByName)).thenReturn(book);

        // Mock to get book from repository
        Book getBook = new Book();
        getBook.setId(1);
        getBook.setName(book.getName());
        getBook.setAvailable(false);
        when(bookRepository.findByName(book.getName())).thenReturn(getBook);

        // Mock the get book to the responseGetBookByName
        responseGetBookByName.setName(getBook.getName());
        when(mapper.bookToResponseGetBookByName(getBook)).thenReturn(responseGetBookByName);

        // Test service function
        ResponseGetBookByName response = bookService.getBookByName(requestGetBookByName);
        assertNotNull(response);
        assertEquals(getBook.getName(),response.getName());

    }

    @Test
    void shouldGetBookById() {
        //mock get book from request get book by id
        requestGetBookById.setId(1);
        book.setId(requestGetBookById.getId());
        when(mapper.requestGetBookByIdToBook(requestGetBookById)).thenReturn(book);

        //mock get book from repository
        Book getBook = new Book();
        getBook.setId(book.getId());
        getBook.setName("adasda");
        getBook.setAvailable(false);
        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(getBook));

        // mock get response from get book
        responseGetBookById.setName(getBook.getName());
        responseGetBookById.setAvailable(getBook.isAvailable());
        when(mapper.bookToResponseGetBookById(getBook)).thenReturn(responseGetBookById);

        // test service function
        ResponseGetBookById response = bookService.getBookById(requestGetBookById);
        assertNotNull(response);
        assertEquals(getBook.getName(),response.getName());
    }

    @Test
    void shouldUpdateBook() {
        requestUpdateBook.setId(1);
        requestUpdateBook.setName("adasd");
        requestUpdateBook.setAvailable(false);
        book.setId(requestUpdateBook.getId());
        book.setName(requestUpdateBook.getName());
        book.setAvailable(requestUpdateBook.isAvailable());
        when(mapper.requestUpdateBookToBook(requestUpdateBook)).thenReturn(book);

        Book updatedBook = new Book();
        updatedBook.setId(book.getId());
        updatedBook.setName(book.getName());
        updatedBook.setAvailable(book.isAvailable());
        when(bookRepository.save(book)).thenReturn(updatedBook);

        responseUpdateBook.setId(updatedBook.getId());
        responseUpdateBook.setName(updatedBook.getName());
        responseUpdateBook.setAvailable(updatedBook.isAvailable());
        when(mapper.bookToResponseUpdateBook(updatedBook)).thenReturn(responseUpdateBook);

        ResponseUpdateBook response = bookService.updateBook(requestUpdateBook);
        assertNotNull(response);
        assertEquals(requestUpdateBook.getId(),response.getId());
        assertEquals(requestUpdateBook.getName(),response.getName());
        assertEquals(requestUpdateBook.isAvailable(),response.isAvailable());

    }

    @Test
    void shouldGetAllBooks() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("asdasd");
        book1.setAvailable(true);

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("asdasdad");
        book2.setAvailable(false);

        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);


        List<ResponseGetAllBook> responseBooks = new ArrayList<>();

        ResponseGetAllBook responseBook1 = new ResponseGetAllBook();
        responseBook1.setId(book1.getId());
        responseBook1.setName(book1.getName());
        responseBook1.setAvailable(book1.isAvailable());

        ResponseGetAllBook responseBook2 = new ResponseGetAllBook();
        responseBook2.setId(book2.getId());
        responseBook2.setName(book2.getName());
        responseBook2.setAvailable(book2.isAvailable());

        responseBooks.add(responseBook1);
        responseBooks.add(responseBook2);

        when(mapper.booksToResponseGetAllBook(books)).thenReturn(responseBooks);

        // Test the service function
        List<ResponseGetAllBook> response = bookService.getAllBooks();
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(book1.getName(), response.getFirst().getName());
        assertEquals(book2.getName(), response.getLast().getName());

    }
}