package backend2023.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend2023.Bookstore.domain.Book;
import backend2023.Bookstore.domain.BookRepository;
import backend2023.Bookstore.domain.CategoryRepository;





@Controller

public class BookController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository category;

	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String showBooks(Model model) {
		
		List<Book> books = (List<Book>)bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 model.addAttribute("categories", category.findAll());
	 return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 bookRepository.save(book);
	 return "redirect:booklist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
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

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) bookRepository.findAll();
    } 
    
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return bookRepository.findById(bookId);
    }     
    
    // RESTful service to save new student
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
    	return bookRepository.save(book);
    }
}
