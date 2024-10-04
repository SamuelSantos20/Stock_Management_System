
package config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.User;
@Repository
public interface identificationRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	
	
	
}
