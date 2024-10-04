package dto;

import java.util.List;

import domain.Moviment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	
	private List<Moviment> moviments;
	
	private Long id;
	
	private String name;
	
	private Integer amount;
	
	private String category;
	
	private Double price;
}
