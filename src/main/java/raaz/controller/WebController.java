package raaz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author torirem - aaustin5
 * CIS175 - Fall 2023
 * Nov 7, 2023
 */
/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Nov 24, 2023
 */
@Controller
public class WebController {
	//mapping for navigation (navbar in header.html in fragments folder)
	@GetMapping("/")
	public String openIndex() {
		return "index";
	}	
	
    @GetMapping("/about")
    public String openAbout(){
    	return "about";
    }
	
    @GetMapping("/samplePage")
    public String openSamplePage() {
        return "samplePage"; 
    }
    
    @GetMapping("/sampleTable")
    public String openSampleTable() {
    	return "sampleTable";
    }
}
