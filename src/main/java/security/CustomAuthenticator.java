package security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import dto.identification;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CustomAuthenticator implements Authentication  {

	private  identification identification; 
	
	
	@Override
	public String getName() {
		
		return identification.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return identification.getType().stream().map(ident -> new SimpleGrantedAuthority("ADM")).collect(Collectors.toList());
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return  this.identification;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
	
		throw new IllegalArgumentException("not is necessery");
		
		
	}

}
