package guru.springframework.webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	@Override
	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

}
