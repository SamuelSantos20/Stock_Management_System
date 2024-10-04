package domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Table(name = "user")
public class User extends AbstractEntity<Long>{

	@Column(name = "username" , length = 200 , nullable = false , unique = true , updatable = true )
	private String  username;
	
	@Column(name = "password" , length = 200 , nullable = false , unique = true , updatable = true )
	private String password;
	
	@Column(name = "type" , length = 200 , nullable = false , unique = true , updatable = true )
	private List<String> type;
	
}
