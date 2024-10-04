package dto;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentDto {

	



	private Long id;
	
	@JsonIgnore
	private Set<String> product;
	
	
	private Integer amount;
	
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private  Date date; 
	

	private String user;
	
	

	private String type;
	
	
	
}
