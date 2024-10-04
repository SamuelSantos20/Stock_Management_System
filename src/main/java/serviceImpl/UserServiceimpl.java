package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import dataImpl.UserDataImpl;
import domain.User;
import lombok.RequiredArgsConstructor;
import service.UserService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UserServiceimpl implements UserService {

	private final UserDataImpl userDataImpl;

	private final PasswordEncoder passwordEncoder;

	@Override
	public void saveTheUser(User user) {

		if (user == null) {

			throw new UsernameNotFoundException("Username not present");
		}
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		userDataImpl.save(user);

	}

	@Override
	public void UpdateTheUser(User user) {
		userDataImpl.update(user);
	}

	@Override
	public void deleteTheUser(Long id) {

		userDataImpl.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public User ListTheUser(Long id) {
		return userDataImpl.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> FindAllTheUsers() {
		return userDataImpl.findAll();
	}

	@Override
	public List<User> ListUser(User user) {
		
		List<User> users = new ArrayList<>();
		
		users.add(user);
		
		
		
		return users ;
	}

	
	
	
	
	
	
}
