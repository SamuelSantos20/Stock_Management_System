package service;

import java.util.List;

import domain.Product;

public interface ProductService {

	void saveTheProduct(Product product);
	
	void UpdateTheProduct(Product product);
	
	void deleteTheProduct(Long id);
	
	Product ListId(Long id);
	
	List<Product> ListProduct();
	
	public List<Product> ProductByName(String name);
	
	
}
