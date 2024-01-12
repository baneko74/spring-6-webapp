package guru.springframework.webapp.services;

import guru.springframework.webapp.domain.Book;

public interface BookService {

	Iterable<Book> findAllBooks();
}
