package guru.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.webapp.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
