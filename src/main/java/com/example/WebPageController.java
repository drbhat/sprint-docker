package com.example.docker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WebPageController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model){
		model.put("name", "Brownie");
        return "welcome";
    }

}
