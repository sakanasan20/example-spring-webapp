package tw.niq.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.niq.example.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
