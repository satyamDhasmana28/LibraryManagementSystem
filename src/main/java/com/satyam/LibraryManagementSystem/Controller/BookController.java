package com.satyam.LibraryManagementSystem.Controller;

import com.satyam.LibraryManagementSystem.Dto.ResponseDto;
import com.satyam.LibraryManagementSystem.Dto.UpdatePage;
import com.satyam.LibraryManagementSystem.Exception.IdDoesNotExistException;
import com.satyam.LibraryManagementSystem.Model.Book;
import com.satyam.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody() Book book) throws IdDoesNotExistException {
            String response = bookService.addBook(book);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id")int id) throws IdDoesNotExistException {
            Book book = bookService.getBookById(id);
            return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    @PutMapping("/update-pages")
    public ResponseEntity<String> updatePage(@RequestBody()UpdatePage updatePage) throws IdDoesNotExistException {
           String response = bookService.updatePage(updatePage);
           return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-movie-list")
    public ResponseEntity<List<ResponseDto>> getMovieList(){
        List<ResponseDto> movielist = bookService.getMovieList();
        return new ResponseEntity<>(movielist,HttpStatus.FOUND);
    }
}
