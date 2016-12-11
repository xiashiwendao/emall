package lorrywork.emall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lorrywork.emall.dao.ProductMapper;
import lorrywork.emall.entity.Product;

@Controller
public class GoodeditController {
	@Autowired
	private ProductMapper mapper ;
	
	@RequestMapping(value = "/home")
	public String showHomePage() {
		List<Product> lst = mapper.getProducts();
		Product p = lst.get(0);
		return "home";
	}
	
	private void test(){
		
	}
	
}
