package guru.springframework.webapp.services;

import guru.springframework.webapp.domain.Author;

public interface AuthorService {

	Iterable<Author> findAllAuthors();
}
