package backend2023.Bookstore;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend2023.Bookstore.domain.Book;
import backend2023.Bookstore.domain.BookRepository;
import backend2023.Bookstore.domain.Category;
import backend2023.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository category) {
		
		return (args) -> {
			Book book1 = new Book("Title1", "Author1", 1997, "12345", 15.50);
			Book book2 = new Book("Title2", "Author2", 1998, "23456", 16.50);
			bookRepository.save(book1);
			bookRepository.save(book2);
			List<Book> books = (List<Book>)bookRepository.findAll();
			
			Category category1 = new Category("Scifi");
			Category category2 = new Category("Comic");
			category.save(category1);
			category.save(category2);
			List<Category> categories = (List<Category>)category.findAll();
			
			log.info("fetch all books");
			for (Book book : books) {
				log.info(book.toString());
			};

	        log.info("fetch all categories");
	        for (Category cat : categories) {
	            log.info(cat.toString());
	        }

		};
		
	}
}
