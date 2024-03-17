package com.nhom1.bookstore.apis;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.bookstore.entity.Book;
import com.nhom1.bookstore.services.BookService;

@RestController
@RequestMapping("/api/topselling")
public class GetTopSellingController {
    private final BookService bookService;

    public GetTopSellingController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getTopSelling() {
        List<Book> bookList = bookService.getTopSelling();
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
