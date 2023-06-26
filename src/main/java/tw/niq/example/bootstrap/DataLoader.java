package tw.niq.example.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tw.niq.example.domain.Author;
import tw.niq.example.domain.Book;
import tw.niq.example.domain.Publisher;
import tw.niq.example.repository.AuthorRepository;
import tw.niq.example.repository.BookRepository;
import tw.niq.example.repository.PublisherRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");

		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbn("123456");

		Author ericSaved = authorRepository.save(eric);
		Book dddSaved = bookRepository.save(ddd);

		Author rod = new Author();
		rod.setFirstName("Rod");
		rod.setLastName("Johnson");

		Book noEJB = new Book();
		noEJB.setTitle("J2EE Development without EJB");
		noEJB.setIsbn("654321");
		
		Publisher publisher = new Publisher();
		publisher.setPublisherName("My Publisher");
		publisher.setAddress("123 Main");

		Author rodSaved = authorRepository.save(rod);
		Book noEJBSaved = bookRepository.save(noEJB);
		Publisher savedPublisher = publisherRepository.save(publisher);

		ericSaved.getBooks().add(dddSaved);
		rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);
		dddSaved.setPublisher(savedPublisher);
		noEJBSaved.setPublisher(savedPublisher);

		authorRepository.save(ericSaved);
		authorRepository.save(rodSaved);
		bookRepository.save(dddSaved);
		bookRepository.save(noEJBSaved);

		System.out.println("Data Loaded");
		System.out.println("Author count: " + authorRepository.count());
		System.out.println("Book count: " + bookRepository.count());
		System.out.println("Publisher count: " + publisherRepository.count());
	}

}
