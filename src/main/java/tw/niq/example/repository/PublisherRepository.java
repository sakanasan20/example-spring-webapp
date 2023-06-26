package tw.niq.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.niq.example.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
