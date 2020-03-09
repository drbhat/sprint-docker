package com.example.docker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WebPageController {

	
	@GetMapping(value="/welcome")
    public String showWelcomePage(ModelMap model){
		model.put("name", "Brownie");
        return "welcome";
    }

}
