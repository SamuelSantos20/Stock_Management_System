package data;

import java.util.List;

import domain.Moviment;

public interface MovimenrtData {

	
	// Método para persistir uma entidade T no banco de dados
	public void save(Moviment moviment);

	// Método para atualizar uma entidade T no banco de dados
	public void update(Moviment moviment);

	// Método para excluir uma entidade T do banco de dados por sua chave primária
	// (PK)
	public void delete(Long id);

	// Método para encontrar uma entidade T pelo seu ID (PK)
	public Moviment findById(Long id);

	public List<Moviment> findAll();
	
	
}
