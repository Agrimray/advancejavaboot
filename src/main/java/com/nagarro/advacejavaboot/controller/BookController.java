package com.nagarro.advacejavaboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.advacejavaboot.dto.AuthorDto;
import com.nagarro.advacejavaboot.dto.BookDto;
import com.nagarro.advacejavaboot.entity.Author;
import com.nagarro.advacejavaboot.entity.Book;
import com.nagarro.advacejavaboot.service.AuthorService;
import com.nagarro.advacejavaboot.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getBooks() { 
		List<BookDto> allData = bookService.getAllData();
		
		if (allData != null && allData.size() > 0) {
			return new ResponseEntity<>(allData,HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<HttpStatus> postHome(@RequestBody Book book) {
		System.out.println("Author name "+book.getAuthorName());
		System.out.println("get books");
		System.out.println(book.toString());
		bookService.insertBook(book);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		try {
			bookService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<HttpStatus> update(@RequestBody BookDto bookData,@PathVariable("id") int id){
		try {
			Book book=new Book();
			book.setBookId(bookData.getBookCode());
			book.setBookName(bookData.getBookName());
			book.setCurrentDate(bookData.getDate());
			book.setAuthorName(bookData.getAuthorName());
			System.out.println("inside put controller");
			System.out.println(book.toString());
			bookService.update(book, id);
			return new ResponseEntity<>(HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAuthor() {
		List<Author> allData=authorService.getAuthor();
		if (allData != null && allData.size() > 0) {
			return new ResponseEntity<>(allData,HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
