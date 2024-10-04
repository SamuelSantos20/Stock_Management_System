package dataImpl;


import java.util.List;

import org.springframework.stereotype.Repository;

import data.ProductData;
import domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ProductDataImpl extends AbstractDao<Product, Long> implements ProductData  {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Product> productUnic(String product){
		
		
		try {
			
			String sql = "select p from Product p where p.name =:name";
			
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("name", product);
		
		System.out.println(query.getResultList());
		
		return  query.getResultList();
			
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
			
			
			
		}
		
		
		
		
	}
	
	
	
}
