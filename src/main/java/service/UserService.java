package service;

import java.util.List;

import domain.User;

public interface UserService {

	void saveTheUser(User  user);
	
	void UpdateTheUser(User user);
	
	void deleteTheUser(Long id);
	
	User ListTheUser(Long id);
	
	public List<User> FindAllTheUsers();
	
	public List<User> ListUser(User user); 
	
}
