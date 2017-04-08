package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WelcomeController {

	// inject via application.properties
    //@Value("${welcome.message:test}")
	//private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		model.put("name", name);
		return "welcome";
	}

}