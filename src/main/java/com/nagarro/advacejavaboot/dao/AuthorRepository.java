package com.nagarro.advacejavaboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.advacejavaboot.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String>{

}
