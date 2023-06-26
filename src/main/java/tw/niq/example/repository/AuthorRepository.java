package tw.niq.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.niq.example.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
