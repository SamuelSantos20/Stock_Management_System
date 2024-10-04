package data;

import java.util.List;

import domain.User;

public interface UserData {

	// Método para persistir uma entidade T no banco de dados
	public void save(User user);

	// Método para atualizar uma entidade T no banco de dados
	public void update(User user);

	// Método para excluir uma entidade T do banco de dados por sua chave primária
	// (PK)
	public void delete(Long id);

	// Método para encontrar uma entidade T pelo seu ID (PK)
	public User findById(Long id);

	public List<User> findAll();

}
