package com.example.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class HelloDockerController {

	
	@RequestMapping(path = "/hello", method = RequestMethod.GET) 
	public String helloGradle() {
		return "Hello Docker!";
	}

}
