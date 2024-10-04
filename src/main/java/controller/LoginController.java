package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.identification;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {

	
	@GetMapping("/loginRequest")
	public ModelAndView preLogin() {
	
		ModelAndView mv  = new ModelAndView();
		
		
		try {
			
			mv.addObject("User", new identification());
			mv.setViewName("login.html");
			return mv;
			
		} catch (Exception e) {
			
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;
			
		}
		
		
	}
	
	
	@PostMapping("/login")
	public void Login(identification identification) {
		
		System.out.println(identification);
	}
	
	
	
	
}
