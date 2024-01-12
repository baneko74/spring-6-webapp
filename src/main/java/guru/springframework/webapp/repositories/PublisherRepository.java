package guru.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.webapp.domain.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
