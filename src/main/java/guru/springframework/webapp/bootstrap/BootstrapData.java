package guru.springframework.webapp.bootstrap;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.domain.Publisher;
import guru.springframework.webapp.repositories.AuthorRepository;
import guru.springframework.webapp.repositories.BookRepository;
import guru.springframework.webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;
	
	public BootstrapData(AuthorRepository authorRepo, 
						BookRepository bookRepo, 
						PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
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
		rod.setFirstName("Rod");
		rod.setLastName("Johnson");
		
		Book book1 = new Book();
		book1.setTitle("J2EE Development without EJB");
		book1.setIsbn("5475785");
		
		Author rodSaved = authorRepo.save(rod);
		Book book1Saved = bookRepo.save(book1);
		
		ericSaved.addBook(bookSaved);
		rodSaved.addBook(book1Saved);
		
		Publisher publisher = new Publisher();
		publisher.setPublisherName("NOLIT");
		publisher.setAddress("123 Main");
		Publisher savedPublisher = publisherRepo.save(publisher);
		
		bookSaved.setPublisher(savedPublisher);
		book1Saved.setPublisher(savedPublisher);
	
		authorRepo.save(ericSaved);
		authorRepo.save(rodSaved);
		bookRepo.save(bookSaved);
		bookRepo.save(book1Saved);
		
		System.out.println("In Bootstrap");
		System.out.println("Author count: " + authorRepo.count());
		System.out.println("Book count: " + bookRepo.count());
		
		System.out.println("Publisher count: " + publisherRepo.count());
		
	}

	
}
