package com.nagarro.advacejavaboot.dao;
import org.springframework.data.repository.CrudRepository;
import com.nagarro.advacejavaboot.entity.Book;


public interface BookRepository extends CrudRepository<Book, Integer>
{

}


