package data;

import java.util.List;

import domain.Product;

public interface ProductData {


	// Método para persistir uma entidade T no banco de dados
	public void save(Product product);

	// Método para atualizar uma entidade T no banco de dados
	public void update(Product product);

	// Método para excluir uma entidade T do banco de dados por sua chave primária
	// (PK)
	public void delete(Long id);

	// Método para encontrar uma entidade T pelo seu ID (PK)
	public Product findById(Long id);

	public List<Product> findAll();
	
	
}
