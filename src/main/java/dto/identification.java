package dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class identification {

	private String username;
	
	private String password;
	
	private List<String> type;
	
	
	
}
