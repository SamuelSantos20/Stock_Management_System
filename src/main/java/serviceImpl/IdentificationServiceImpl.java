package serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import config.identificationRepository;
import domain.User;
import lombok.RequiredArgsConstructor;
import service.IdentificationService;

@Transactional(readOnly = false)
@RequiredArgsConstructor
@Service
public class IdentificationServiceImpl implements IdentificationService{

	private final identificationRepository identificationRepository;

	@Override
	@Transactional(readOnly = true)
	public User findByLoginSecurity(String username) {
	
		return identificationRepository.findByUsername(username);
	}
	
	
}
