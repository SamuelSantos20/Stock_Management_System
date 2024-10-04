package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import dto.identification;
import enums.UserType;
import lombok.RequiredArgsConstructor;
import serviceImpl.UserServiceimpl;

@Controller
@RequiredArgsConstructor
public class UserController {

	
	private final UserServiceimpl  userServiceimpl;
	
	@GetMapping("/pre/register/user")
	public ModelAndView preRegister() {

		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("User", new identification());
			mv.addObject("Type", typesUsers());
			mv.setViewName("registrar-se.html");

			return mv;

		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	@PostMapping("/register/user")
	public ModelAndView RegisterUser (identification identification , @RequestParam("type") String category) {
		
		ModelAndView mv = new ModelAndView();
		try {
			SaveUser(identification , category);
			mv.setViewName("redirect:/pre/register/user");
			return mv;
			
		} catch (Exception e) {

		
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;
		
		}	
		
	}

	private void SaveUser(identification identification, String category) throws Exception {

		
		try {
			
		
			
		
		String username = identification.getUsername();

		String password = identification.getPassword();

		List<String> list = new ArrayList<>();

		list.add(category);

		identification.setType(list);

		List<String> userType = identification.getType();

		if(userType == null || username == null || password == null) {
			
			
			throw new UsernameNotFoundException("Username not present");
			
		}	
		
		
		User user = new User();

		user.setPassword(password);
		user.setType(userType);
		user.setUsername(username);
		
		userServiceimpl.saveTheUser(user);
		
		
		} catch (Exception e) {
		
			throw new Exception("unknown error");
			
		}
	}

	private UserType[] typesUsers() {

		return UserType.values();
	}

}
