package com.restservice.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World Restful with Spring Boot";
	}
	
	@RequestMapping("/hello2")
	public String hello1(@RequestParam(name = "name", defaultValue = "World") String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/hello1")
	public String hello2() {
		return "This will return GET request";
	}
	
	@PostMapping("/hello3")
	public String add() {
		return "you have sent POST request";
	}
	
	@PutMapping("/hello4")
	public String update() {
		return "you have sent PUT request";
	}
	
	@DeleteMapping("/hello5")
	public String delete() {
		return "you have sent DELETE reuest";
	}
	
	@GetMapping("/getproduct")
	public Product getProduct() {
		return new Product(1, "iPhone", 999.99f);
	}
	
	@GetMapping("/getproducts")
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(1, "Samsung", 1599.99f));
		products.add(new Product(2, "Macbook", 1299.99f));
		products.add(new Product(3, "Amazon basics", 599.99f));
		products.add(new Product(4, "Tesla", 20999.99f));
		
		return products;
	}
	
	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
	}
	
	@GetMapping(value = "/getproduct1", 
			produces = {MediaType.TEXT_HTML_VALUE}
	        )
	public String getProduct1() {
		return "<html><title>REST</title><body>REST Spring Boot End Point</body></html>";
	}
	
	@GetMapping(value = "/getproduct2",
			produces = {MediaType.TEXT_XML_VALUE}
	        )
	public String getProduct2() {
		return "<product>This is example for XML media type</product>";
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct3(@PathVariable int id) {
		if(id == 3) {
			Product product = new Product(3, "Toyota Prius", 12999.99f);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
	}

}
