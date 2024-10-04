package serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dataImpl.MovimentDataImpl;
import domain.Moviment;
import domain.Product;
import dto.MovimentDto;
import lombok.RequiredArgsConstructor;
import service.MovimentService;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class MovimentServiceImpl implements MovimentService {

	private final MovimentDataImpl movimentDataImpl;

	@Override
	public void saveTheMoviment(Moviment moviment) {

		movimentDataImpl.save(moviment);
	}

	@Override
	public void UpdateTheMoviment(Moviment moviment) {
		movimentDataImpl.update(moviment);
		
	}

	@Override
	public void deleteTheMoviment(Long id) {
		movimentDataImpl.delete(id);
		
	}

	@Override
	public Moviment ListIdMoviment(Long id) {
		
		return movimentDataImpl.findById(id);
	}

	@Override
	public List<Moviment> ListTheMonimets() {
	
		return movimentDataImpl.findAll();
	} 
	
	public List<MovimentDto> ListMovimentsDto(){
		
		
		for(Moviment m : movimentDataImpl.findAll()) {
			
			System.out.println(m);
			
		}
		
		List<Moviment> moviments = movimentDataImpl.findAll();
		
		return moviments.stream().map( m -> new MovimentDto(m.getId(), m.getProduct().stream().map(Product :: getName).collect(Collectors.toSet()), m.getAmount(),
				m.getDate(), m.getUser().getUsername(), m.getType())).collect(Collectors.toList());
		
	}
	
	
	/*
	public MovimentDto ListMovimentsDtoID(Long id) throws Exception{
		
		if(id == null) {
			
		 throw new Exception("not is value");
			
			
		}
		
		List<Moviment> moviments = new ArrayList<>();
		
		Moviment moviment = movimentDataImpl.findById(id);
		
		moviments.add(moviment);
		
		for(Moviment m : moviments) {
			
			System.out.println(m);
			
		}
		
		 List<MovimentDto> movimentDtos =  moviments.stream().map( m -> new MovimentDto(m.getId(), m.getProduct().stream().map(Product :: getName).collect(Collectors.toSet()), m.getAmount(),
				m.getDate(), m.getUser().getUsername(), m.getType())).collect(Collectors.toList());
	
				MovimentDto movimentDto = new MovimentDto();
				
				for(MovimentDto m : movimentDtos) {
					
					movimentDto = m;
					
				}
		 
		 return movimentDto;
		 
	}*/

	
	
}
