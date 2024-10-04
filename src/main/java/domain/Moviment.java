package domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimentacao")
@SuppressWarnings("serial")
public class Moviment extends AbstractEntity<Long> {
	
	@ManyToMany
	@JoinTable(name = "product_moviment"  ,  joinColumns = @JoinColumn(name ="moviment_id" , nullable = true), inverseJoinColumns = @JoinColumn(name = "produto_id" , nullable = true))
	private List<Product> product = new ArrayList<>();
	
	@Column(name = "amount" , length = 200 , nullable = false , unique = false , updatable = true )
	private Integer amount;
	
	
	@Column(name = "date" , length = 200 , nullable = false , unique = false , updatable = true )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date date;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Column(name = "type" , length = 200 , nullable = false , unique = false , updatable = true )
	private String type;
	
	
	
	
	
	
}
