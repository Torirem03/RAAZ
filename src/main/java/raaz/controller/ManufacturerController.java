package raaz.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import raaz.beans.Manufacturer;
import raaz.repository.ManRepository;
import raaz.repository.RAAZRepository;
import java.util.Optional;

//Zoie Was Here hehehehe eudhowhcogrd
@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManRepository manRepository;

    @GetMapping("/viewAllMans")
    public String viewAllMans(Model model) {
        if (manRepository.findAll().isEmpty()) {
            return addNewMan(model);
        }
        model.addAttribute("manufacturers", manRepository.findAll());
        return "allMans";
    }

    @GetMapping("/inputMan")
    public String addNewMan(Model model) {
    	Manufacturer m = new Manufacturer();
        model.addAttribute("newMan", m);
        return "inputMan";
    }

    @PostMapping("/inputMan")
    public String addNewMan(@ModelAttribute Manufacturer m, Model model) {
        manRepository.save(m);
        return "redirect:/manufacturer/viewAllMans";
    }

    @GetMapping("/edit/{manId}")
    public String showMantoUpdate(@PathVariable("manId") long manId, Model model) {
        Manufacturer m = manRepository.findById(manId).orElse(null);
        model.addAttribute("newMan", m);
        return "inputMan";
    }

    @PostMapping("/update/{manId}")
    public String updateMan(Manufacturer m , Model model) {
    	manRepository.save(m);
    	return "redirect:/manufacturer/viewAllMans";
    }

    @GetMapping("/delete/{manId}")
    public String deleteMan(@PathVariable("manId") long manId, Model model) {
       Manufacturer m = manRepository.findById(manId).orElse(null);
       manRepository.delete(m);
       return "redirect:/manufacturer/viewAllMans";
    }
}