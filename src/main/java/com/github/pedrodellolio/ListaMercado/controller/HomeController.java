package com.github.pedrodellolio.ListaMercado.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.pedrodellolio.ListaMercado.model.Product;
import com.github.pedrodellolio.ListaMercado.repository.ProductRepository;

@Controller
public class HomeController {
	
	private ProductRepository productRepository;
	
	HomeController(ProductRepository productRepository) {
	       this.productRepository = productRepository;
	}
	
	@GetMapping("/")
	public String redirectHome() {
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "home";
	}
	
		
	@ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
    	return "redirect:/home";
    }

}
