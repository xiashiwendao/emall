package lorrywork.emall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodeditController {
	@RequestMapping(value = "/home")
	public String showHomePage() {
		return "home";
	}
	
	private void test(){
		
	}
	
}
