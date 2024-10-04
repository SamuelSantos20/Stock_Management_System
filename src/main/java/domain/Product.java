package domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "produto")
public class Product extends AbstractEntity<Long> {

	@ToString.Exclude
	@ManyToMany(mappedBy = "product")
	private List<Moviment> moviments = new ArrayList<>();
	
	@Column(name = "name" ,length =  200,  nullable = false , unique = true , updatable = true )
	private String name;
	
	@Column(name = "amount" ,length =  200,  nullable = true , unique = false , updatable = true )
	private Integer amount;
	
	@Column(name = "category" ,length =  200,  nullable = false , unique = false , updatable = true )
	private String category;
	
	
	@Column(name = "price" ,length =  200,  nullable = false , unique = false , updatable = true )
	private Double price;
	
	
	
}
