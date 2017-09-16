package application.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.model.Product;
import application.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createProduct(@RequestBody Map<String, Object> productMap){
		Product product = new Product(productMap.get("id").toString(), 
				productMap.get("name").toString(),
				productMap.get("imageUrl").toString(),
				productMap.get("price").toString());
	    
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Product created successfully");
	    response.put("book", productRepository.save(product));
	    return response;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	  public Map<String, Object> getAllProducts(){
		System.out.println("Application is invoked!");
	    List<Product> products = productRepository.findAll();
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("totalProducts", products.size());
	    response.put("products", products);
	    return response;
	  }
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{productId}")
	  public Map<String, String> deleteBook(@PathVariable("productId") String productId){
		productRepository.delete(productId);
	    Map<String, String> response = new HashMap<String, String>();
	    response.put("message", "Product deleted successfully");
	    return response;
	  }
}
