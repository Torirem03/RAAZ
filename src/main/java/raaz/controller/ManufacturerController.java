package raaz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import raaz.beans.Manufacturer;
/**
 * @author Zoie Firkins -zmfirkins
 * CIS175 - Fall 2023
 * Nov 16, 2023
 */
@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @GetMapping({"/", "viewAll"})
    public String viewAllMans(Model model) {
        return "viewAllManufacturers";
    }

    @GetMapping("/inputProduct")
    public String addNewMan(Model model) {
        return "addManufacturer";
    }

    @PostMapping("/inputProduct")
    public String addNewMan(@ModelAttribute Manufacturer m, Model model) {
   
        return "redirect:/manufacturer/viewAll";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateMan(@PathVariable("id") long id, Model model) {
  
        return "editManufacturer";
    }

    @PostMapping("/update/{id}")
    public String reviseMan(@ModelAttribute Manufacturer m, Model model) {
     
        return "redirect:/manufacturer/viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteMan(@PathVariable("id") long id, Model model) {
     
        return "redirect:/manufacturer/viewAll";
    }
}