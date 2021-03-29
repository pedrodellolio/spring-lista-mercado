package com.github.pedrodellolio.ListaMercado.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pedrodellolio.ListaMercado.dto.NewProduct;
import com.github.pedrodellolio.ListaMercado.model.Product;
import com.github.pedrodellolio.ListaMercado.repository.ProductRepository;

@Controller
@RequestMapping("product")
public class FormController {

	private ProductRepository productRepository;

	FormController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/new")
	public String form(NewProduct req) {
		return "form-register";
	}

	@PostMapping("/new")
	public String submitForm(@ModelAttribute("newProduct") @Valid NewProduct req, BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			return "form-register";
		}
		
		Product product = req.toProduct();		
		productRepository.save(product); // salva no banco de dados
		
		return "form-success";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		productRepository.deleteById(id);
		return "redirect:/home";

	}
}
