package backend2023.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend2023.Bookstore.domain.Book;
import backend2023.Bookstore.domain.BookRepository;



@Controller

public class BookController {
	@Autowired
	BookRepository bookRepository;

	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String showBooks(Model model) {
		
		List<Book> books = (List<Book>)bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 bookRepository.save(book);
	 return "redirect:booklist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model){ 
		bookRepository.deleteById(bookId);
	 return "redirect:../booklist";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long bookId, Model model){
		Optional<Book> book = bookRepository.findById(bookId);
	 model.addAttribute("book", book);
	 return "editbook";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveEdit(Book book){
		 bookRepository.save(book);
		 return "redirect:/booklist";
		}

}
