package com.nagarro.advacejavaboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.advacejavaboot.dao.AuthorRepository;
import com.nagarro.advacejavaboot.entity.Author;

@Component
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	AuthorRepository authorRepository;
	public List<Author> getAuthor(){
		return (List<Author>)authorRepository.findAll();
	}

	
}
