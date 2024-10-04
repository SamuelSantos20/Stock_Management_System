package service;

import java.util.List;

import domain.Moviment;

public interface MovimentService {

	void saveTheMoviment(Moviment moviment);
	
	void UpdateTheMoviment(Moviment moviment);
	
	void deleteTheMoviment(Long id);
	
	Moviment ListIdMoviment(Long id);
	
	List<Moviment> ListTheMonimets();
	
	
	
	
}
