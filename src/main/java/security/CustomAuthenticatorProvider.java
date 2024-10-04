package security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import domain.User;
import dto.identification;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import serviceImpl.IdentificationServiceImpl;

@RequiredArgsConstructor
@Component
public class CustomAuthenticatorProvider implements AuthenticationProvider{

	private final PasswordEncoder passwordEncoder;
	
	
	private final  IdentificationServiceImpl identificationServiceImpl;
	
	private final HttpServletRequest httpServletRequest;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		String username = authentication.getName();
		
		String password = (String) authentication.getCredentials();
		
		User user = identificationServiceImpl.findByLoginSecurity(username);
		
		HttpSession httpSession = httpServletRequest.getSession();
		
		
		
		Boolean isValid = passwordEncoder.matches(password , user.getPassword());
		
		
		if(isValid) {
		
			httpSession.setAttribute("username", user.getUsername());
			
			identification identification = new identification(user.getUsername(), user.getPassword(), user.getType());
			
			return new CustomAuthenticator(identification);
			
		}
		
		return null;
		
		}
		
		
	
	

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}



}
