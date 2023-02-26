package backend2023.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import backend2023.Bookstore.domain.Category;
import backend2023.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository category;
	
	@GetMapping("/categorylist")
	public String showCategories(Model model) {
		
		List<Category> categories = (List<Category>)category.findAll();
		model.addAttribute("categories", categories);
		return "categorylist";
	}
	@GetMapping("/addnew")
	public String addCategory(Model model){
	 model.addAttribute("category", new Category());
	 return "addcategory";
	}
	@PostMapping("/savecategory")
	public String save(Category savecategory){
	category.save(savecategory);
	 return "redirect:categorylist";
	}

}
