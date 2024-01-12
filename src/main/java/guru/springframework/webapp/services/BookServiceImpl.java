package guru.springframework.webapp.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	@Override
	@Transactional(readOnly = true)
	public Iterable<Book> findAllBooks(){
		return bookRepository.findAll();
		
	}

}
