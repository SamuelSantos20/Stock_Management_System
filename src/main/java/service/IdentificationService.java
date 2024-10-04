package service;

import domain.User;

public interface IdentificationService {

	User findByLoginSecurity(String username);
	
	
}
