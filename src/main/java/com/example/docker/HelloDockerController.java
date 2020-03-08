package com.example.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class HelloDockerController {

	
	@RequestMapping(path = "/hello")
	public String helloGradle() {
		return "Hello Docker!";
	}

}
