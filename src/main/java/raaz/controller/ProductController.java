/**
* Rachel Schulz - rsschulz
* CIS175 - Fall 2023
* Nov 14, 2023
*/
package raaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import raaz.beans.Product;
import raaz.repository.ManRepository;
import raaz.repository.RAAZRepository;
import raaz.service.InventoryService;

/**
 * @author Rachel Schulz - rsschulz
 * CIS175 - Fall 2023
 * Nov 14, 2023
 */


@Controller
public class ProductController {
	@Autowired
	RAAZRepository repo;
	
	@Autowired
	ManRepository manRepository;
	
	@Autowired
	private InventoryService inventoryService;
	

	
	@GetMapping("/allProducts")
	public String viewAllProducts(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewProduct(model);
		}
		model.addAttribute("products", repo.findAll());
		return "allProducts";
	}

	@GetMapping("/inputProduct")
	private String addNewProduct(Model model) {
		Product p = new Product();
		model.addAttribute("newProduct", p);
		model.addAttribute("manufacturers", manRepository.findAll());
		return "inputProduct";
	}
	
	@PostMapping("/inputProduct")
	public String addNewProduct(@ModelAttribute Product p, Model model) {
		repo.save(p);
		return "redirect:/allProducts";
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
		model.addAttribute("manufacturers", manRepository.findAll());
		return "inputProduct";
	}
	
	@PostMapping("/updateProduct/{productId}")
	public String updateProduct(Product p, Model model) {
		repo.save(p);
		return "redirect:/allProducts";
	}
	

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Nov 27, 2023
 */
	
	@GetMapping("/allInventory")
	public String viewAllInventory(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewProduct(model);
		}
		model.addAttribute("products", repo.findAll(Sort.by(Direction.ASC, "productName")));
		return "inventory";
	}
	
    @GetMapping("/manage/{productId}")
    public String manageInventory(@PathVariable("productId") long productId, Model model) {    	
		Product p = repo.findById(productId).orElse(null);
		model.addAttribute("newProduct", p); 		
    	return "manage";
    }
	
    @PostMapping("/restock/{productId}")
    public String restockProduct(
            @PathVariable("productId") long productId,
            @RequestParam("restockAmount") int restockAmount,
            Model model) {
        inventoryService.restockProduct(productId, restockAmount);
        return viewAllInventory(model);
    }

    @PostMapping("/manage/pick/{productId}")
    public String pickProduct(
            @PathVariable("productId") long productId,
            @RequestParam("pickAmount") int pickAmount,
            Model model) {
        boolean success = inventoryService.pickProduct(productId, pickAmount);

        if (!success) {
            // Displays an error message if stock is insufficient to handle the request
            return "redirect:/manage/{productId}?error=insufficientStock";
        }

        return viewAllInventory(model);
    }
	
}
