package backend2023.Bookstore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend2023.Bookstore.domain.Book;
import backend2023.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository) {
		
		return (args) -> {
			Book book1 = new Book("Title1", "Author1", 1997, "12345", 15.50);
			Book book2 = new Book("Title2", "Author2", 1998, "23456", 16.50);
			bookRepository.save(book1);
			bookRepository.save(book2);
		};
		
	}
}
