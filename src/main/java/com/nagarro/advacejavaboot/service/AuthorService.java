package com.nagarro.advacejavaboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.advacejavaboot.entity.Author;

@Service
public interface AuthorService {
	
	public List<Author> getAuthor();
}
