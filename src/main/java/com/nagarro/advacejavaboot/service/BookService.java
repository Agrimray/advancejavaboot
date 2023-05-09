package com.nagarro.advacejavaboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.advacejavaboot.dto.BookDto;
import com.nagarro.advacejavaboot.entity.Book;

@Service
public interface BookService {
	
	public List<BookDto> getAllData();
	public void delete(int id) throws Exception;
	public void update(Book book,int id) throws Exception;
	public void insertBook(Book book);
}