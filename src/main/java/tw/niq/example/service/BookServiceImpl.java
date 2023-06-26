package tw.niq.example.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import tw.niq.example.domain.Book;
import tw.niq.example.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Collection<Book> findAll() {
		return bookRepository.findAll();
	}

}
