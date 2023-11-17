/**
* Rachel Schulz - rsschulz
* CIS175 - Fall 2023
* Nov 14, 2023
*/
package raaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import raaz.beans.Product;
import raaz.repository.RAAZRepository;

/**
 * @author Rachel Schulz - rsschulz
 * CIS175 - Fall 2023
 * Nov 14, 2023
 */
@Controller
public class ProductController {
	@Autowired
	RAAZRepository repo;
	
	@GetMapping("/allProducts")
	public String viewAllProducts(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewProduct(model);
		}
		model.addAttribute("products", repo.findAll());
		return "results";
	}

	@GetMapping("/inputProduct")
	private String addNewProduct(Model model) {
		Product p = new Product();
		model.addAttribute("newProduct", p);
		return "input";
	}
	
	@PostMapping("/inputProduct")
	public String addNewProduct(@ModelAttribute Product p, Model model) {
		repo.save(p);
		return viewAllProducts(model);
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") long productId, Model model) {
		Product p = repo.findById(productId).orElse(null);
		repo.delete(p);
		return viewAllProducts(model);
	}
	
	@GetMapping("/updateProduct/{productId}")
	public String showProductToUpdate(@PathVariable("productId") long productId, Model model) {
		Product p = repo.findById(productId).orElse(null);
		model.addAttribute("newProduct", p);
		return "input";
	}
	
	@PostMapping("/updateProduct/{productId}")
	public String updateProduct(Product p, Model model) {
		repo.save(p);
		return viewAllProducts(model);
	}
	

	
}
