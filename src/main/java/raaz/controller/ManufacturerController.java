package raaz.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import raaz.beans.Manufacturer;
import raaz.repository.RAAZRepository;
import java.util.Optional;

//Zoie Was Here
@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private RAAZRepository raazRepository;

    @GetMapping("/viewAll")
    public String viewAllMans(Model model) {
        if (raazRepository.findAll().isEmpty()) {
            return addNewMan(model);
        }
        model.addAttribute("manufacturers", raazRepository.findAll());
        return "viewManufacturer";
    }

    @GetMapping("/inputProduct")
    public String addNewMan(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addManufacturer";
    }

    @PostMapping("/inputProduct")
    public String addNewMan(@ModelAttribute Manufacturer manufacturer, Model model) {
        raazRepository.save(manufacturer);
        return "redirect:/manufacturer/viewAll";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateMan(@PathVariable("id") long id, Model model) {
        Optional<Manufacturer> manufacturer = raazRepository.findById(id);
        model.addAttribute("manufacturer", manufacturer.orElse(null));
        return "editManufacturer";
    }

    @PostMapping("/update/{id}")
    public String reviseMan(@ModelAttribute Manufacturer updatedManufacturer, @PathVariable("id") long id, Model model) {
        Optional<Manufacturer> existingManufacturer = raazRepository.findById(id);
        if (existingManufacturer.isPresent()) {
            Manufacturer manufacturer = existingManufacturer.get();
            manufacturer.setManName(updatedManufacturer.getManName());
            manufacturer.setStreet(updatedManufacturer.getStreet());
            manufacturer.setCity(updatedManufacturer.getCity());
            manufacturer.setState(updatedManufacturer.getState());
            manufacturer.setZip(updatedManufacturer.getZip());
            manufacturer.setEmail(updatedManufacturer.getEmail());
            manufacturer.setPhone(updatedManufacturer.getPhone());
            raazRepository.save(manufacturer);
        }
        return "redirect:/manufacturer/viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteMan(@PathVariable("id") long id, Model model) {
        raazRepository.deleteById(id);
        return "redirect:/manufacturer/viewAll";
    }
}