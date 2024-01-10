package guru.springframework.webapp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@Column
	private String isbn;
	
	@ManyToMany
	@JoinTable(name = "authors_books",
				joinColumns = { @JoinColumn(name = "book_id")},
				inverseJoinColumns = { @JoinColumn(name = "author_id")})
	private Set<Author> authors = new HashSet<>();
}
