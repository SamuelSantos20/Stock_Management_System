package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

	
	@GetMapping("/index")
	public ModelAndView Index() {
ModelAndView mv = new ModelAndView();
		try {
			
			mv.setViewName("dashboard.html");
			return mv;
			
		} catch (Exception e) {
			
			
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;
			
		}
		
	}
	
	
	
}
