package raaz.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import raaz.beans.Manufacturer;
import raaz.repository.ManRepository;
import raaz.repository.RAAZRepository;
import java.util.Optional;

//Zoie Was Here
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
        model.addAttribute("manufacturer", new Manufacturer());
        return "inputMan";
    }

    @PostMapping("/inputMan")
    public String addNewMan(@ModelAttribute Manufacturer manufacturer, Model model) {
        manRepository.save(manufacturer);
        return "redirect:/manufacturer/viewAll";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateMan(@PathVariable("id") long id, Model model) {
        Optional<Manufacturer> manufacturer = manRepository.findById(id);
        model.addAttribute("manufacturer", manufacturer.orElse(null));
        return "editManufacturer";
    }

    @PostMapping("/update/{id}")
    public String reviseMan(@ModelAttribute Manufacturer updatedManufacturer, @PathVariable("id") long id, Model model) {
        Optional<Manufacturer> existingManufacturer = manRepository.findById(id);
        if (existingManufacturer.isPresent()) {
            Manufacturer manufacturer = existingManufacturer.get();
            manufacturer.setManName(updatedManufacturer.getManName());
            manufacturer.setStreet(updatedManufacturer.getStreet());
            manufacturer.setCity(updatedManufacturer.getCity());
            manufacturer.setState(updatedManufacturer.getState());
            manufacturer.setZip(updatedManufacturer.getZip());
            manufacturer.setEmail(updatedManufacturer.getEmail());
            manufacturer.setPhone(updatedManufacturer.getPhone());
            manRepository.save(manufacturer);
        }
        return "redirect:/manufacturer/viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteMan(@PathVariable("id") long id, Model model) {
        manRepository.deleteById(id);
        return "redirect:/manufacturer/viewAll";
    }
}