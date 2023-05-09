package com.nagarro.advacejavaboot.service;

import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.advacejavaboot.dao.BookRepository;
import com.nagarro.advacejavaboot.dto.BookDto;
import com.nagarro.advacejavaboot.entity.Book;

@Component
public class BookServiceImpl implements BookService {
	

	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorService authorService;
	
	public void insertBook(Book book) {
		bookRepository.save(book);
	}
	
	public void delete(int id) throws Exception {

		Optional<Book> book = bookRepository.findById(id);

		if (!book.isPresent()) { 
			throw new Exception("Error ! Book not found with id " + id);
		}

		bookRepository.deleteById(id);
	}
	
	public void update(Book book, int id) throws Exception  {
		Optional<Book> temp = bookRepository.findById(id);

		if ( !temp.isPresent()) {
			throw new Exception("Error ! Book not found with id" + id);
		}

		//book.setBookId(id);
		//bookRepository.save(book);
		 Book existingBook = temp.get(); // Get the existing book from Optional
	        existingBook.setBookName(book.getBookName()); // Update bookName
	        existingBook.setAuthorName(book.getAuthorName()); // Update authorName
	        bookRepository.save(existingBook);
	}
	
	public List<BookDto> getAllData(){
		List<Book> bookfound=(List<Book>)bookRepository.findAll();
		List<BookDto> booksDataList = new ArrayList<BookDto>();
		for (Book bookEntity : bookfound) {
			BookDto bookDto = new BookDto();
			bookDto.setAuthorName(bookEntity.getAuthorName());
			bookDto.setBookCode(bookEntity.getBookId());
			bookDto.setBookName(bookEntity.getBookName());
			bookDto.setDate(bookEntity.getCurrentDate());
			booksDataList.add(bookDto);
		}
		return booksDataList;
	}

}
