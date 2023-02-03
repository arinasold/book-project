package backend2023.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class BookController {
	@GetMapping("/books")
	public String showBooks(Model model) {
		
		
		return "bookweb";
	}

}
