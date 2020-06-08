package pl.edu.pwsztar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.domain.dto.book.BookDto;
import pl.edu.pwsztar.domain.dto.book.CreateBookDto;
import pl.edu.pwsztar.service.BookService;

import java.util.List;

@Controller
@RequestMapping(value = "/api/books")
public class BookApiController {
    private final BookService bookService;

    @Autowired
    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @CrossOrigin
    @GetMapping(value = "/all-books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> result = null;

        result = bookService.getBooks();

        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{bookId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BookDto> getOneBook(@PathVariable Long bookId){
        BookDto result = null;

        result = bookService.getBook(bookId);

        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BookDto> createNewBook(@RequestBody CreateBookDto createBookDto){

        bookService.createBook(createBookDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{bookId}/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BookDto> createNewBook(@PathVariable Long bookId){

        bookService.deleteBook(bookId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
