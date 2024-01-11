package guru.springframework.webapp.bootstrap;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.repositories.AuthorRepository;
import guru.springframework.webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	
	public BootstrapData(AuthorRepository authorRepo, BookRepository bookRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");
		
		Book book = new Book();
		book.setTitle("Domain Driven Design");
		book.setIsbn("123456");
		
		Author ericSaved = authorRepo.save(eric);
		Book bookSaved = bookRepo.save(book);
		
		Author rod = new Author();
		eric.setFirstName("Rod");
		eric.setLastName("Johnson");
		
		Book book1 = new Book();
		book.setTitle("J2EE Development without EJB");
		book.setIsbn("5475785");
		
		Author rodSaved = authorRepo.save(rod);
		Book book1Saved = bookRepo.save(book1);
		
		ericSaved.getBooks().add(book);
		//book.getAuthors().add(eric);
		rodSaved.getBooks().add(book1);
		//book1.getAuthors().add(rodSaved);
		
		authorRepo.save(ericSaved);
		authorRepo.save(rodSaved);
		
		System.out.println("In Bootstrap");
		System.out.println("Author count: " + authorRepo.count());
		System.out.println("Book count: " + bookRepo.count());
	}

	
}
