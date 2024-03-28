package com.nhom1.bookstore.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nhom1.bookstore.converter.ConverterJSON;
import com.nhom1.bookstore.entity.Book;
import com.nhom1.bookstore.services.BookService;
import com.nhom1.bookstore.services.IDGenerator;

@RestController
@RequestMapping("/api/books")
public class ManageAddBookAPIController {
    private final BookService bookService;

    public ManageAddBookAPIController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestParam("image") MultipartFile file, @RequestParam("book") String bookJSON) {
        Book newBook = ConverterJSON.jsonToBookEntity(bookJSON);
        
        String id = IDGenerator.IDBook();
        while (true) {
            if(bookService.search(id).size() == 0) {
                break;
            } else{
                id = IDGenerator.IDBook();
            }
        }
        newBook.setId(id);

        String filePath = bookService.fileToFilePathConverter(file);
        newBook.setHinhAnh(filePath);

        bookService.addBook(newBook);

        BookResponse response = new BookResponse(newBook.getId(), "Book added successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}