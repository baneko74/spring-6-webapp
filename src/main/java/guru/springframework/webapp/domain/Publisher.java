package guru.springframework.webapp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "publisher_name")
	private String publisherName;
	
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	@OneToMany(mappedBy = "publisher", orphanRemoval = true)
	private Set<Book> books = new HashSet<>();
	
	public void addBook(Book book) {
		this.books.add(book);
		book.setPublisher(this);
	}
}