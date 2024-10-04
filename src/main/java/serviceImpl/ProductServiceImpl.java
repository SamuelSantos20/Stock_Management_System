package serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dataImpl.ProductDataImpl;
import domain.Product;
import dto.ProductDto;
import lombok.RequiredArgsConstructor;
import service.ProductService;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductDataImpl productDataImpl;

	@Override
	public void saveTheProduct(Product product) {
		productDataImpl.save(product);
		
	}

	@Override
	public void UpdateTheProduct(Product product) {
		productDataImpl.update(product);
		
	}

	@Override
	public void deleteTheProduct(Long id) {
		productDataImpl.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Product ListId(Long id) {
		
		return productDataImpl.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> ListProduct() {
		
		return productDataImpl.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> ProductByName(String name){
		
		return productDataImpl.productUnic(name);
		
	}
	
	
	public List<ProductDto> ListDtoProduct(){
		
		List<Product> products = productDataImpl.findAll();
		
		return products.stream().map(prod -> new ProductDto(  prod.getMoviments(), prod.getId(), prod.getName(),prod.getAmount() , prod.getCategory(), prod.getPrice())).collect(Collectors.toList());
		
		
	}
	
	public List<ProductDto> ListDtoProductID(Long id){
		
		Product product = productDataImpl.findById(id);
		List<Product> products = new ArrayList<>();
		products.add(product);
		
		
		
		return products.stream().map(prod -> new ProductDto(  prod.getMoviments(), prod.getId(), prod.getName(),prod.getAmount() , prod.getCategory(), prod.getPrice())).collect(Collectors.toList());
		
		
	}
	
	
	@Transactional(readOnly = true)
	public List<Product> ListDtoProductId(Long id){
		
		Product products = productDataImpl.findById(id);
		
		List<Product> List = new ArrayList<>();
		
		List.add(products);
		
		return List.stream().map(prod -> new Product(  prod.getMoviments(),prod.getName(),prod.getAmount() , prod.getCategory(), prod.getPrice())).collect(Collectors.toList());
		
		
	}
	
}
