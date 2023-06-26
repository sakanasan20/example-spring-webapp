package tw.niq.example.service;

import java.util.Collection;

import tw.niq.example.domain.Book;

public interface BookService {

	Collection<Book> findAll();
	
}
