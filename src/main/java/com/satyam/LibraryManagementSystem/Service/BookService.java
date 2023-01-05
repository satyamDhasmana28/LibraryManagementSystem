package com.satyam.LibraryManagementSystem.Service;

import com.satyam.LibraryManagementSystem.Dto.ResponseDto;
import com.satyam.LibraryManagementSystem.Dto.UpdatePage;
import com.satyam.LibraryManagementSystem.Model.Book;
import com.satyam.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public  String updatePage(UpdatePage updatePage) throws Exception {
        if(!bookRepository.findById(updatePage.getId()).isPresent()){
            throw new Exception("Id doesn't exists :(");
        }
        int id = updatePage.getId();
//      I have to convert DTO to ENTITY
//      meanse book already exists s0 get the book,update and save
            Book book = bookRepository.findById(id).get();
            book.setPages(updatePage.getPages());
            bookRepository.save(book);
            return "Updated";
    }

    public String addBook(Book book) throws Exception {
        if(bookRepository.findById(book.getId()).isPresent()){
            String message = "book with id "+book.getId()+" is already exists :(";
            throw new Exception(message);
        }
        bookRepository.save(book);
        return "successfully saved :)";
    }

    public Book getBookById(int id) throws Exception {
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }
        throw new Exception("Book doesn't Exists :(");
    }

    public List<ResponseDto> getMovieList() {
        List<ResponseDto> responseDtoList =new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for(Book book : bookList){
            ResponseDto obj = new ResponseDto();
            obj.setName(book.getBookName());
            obj.setAuthor(book.getAuthor());
            responseDtoList.add(obj);
        }
        return responseDtoList;
    }
}
