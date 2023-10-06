package unam.diplomado.pixupih.discoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixupih.discoservice.domain.Disquera;
import unam.diplomado.pixupih.discoservice.repository.DisqueraRepository;

@Service
public class DisqueraServiceImpl implements DisqueraService{
	
	@Autowired
	private DisqueraRepository disqueraManager;

	@Override
	public Disquera actualizarDisquera(String id, Disquera nuevo) {
		
		// Primero buscamos el registro que se quiere actualizar
		
		Optional<Disquera> actual = disqueraManager.findById(id);
		
		if(actual.isPresent()) {
			
			Disquera actualizada = actual.get();
			actualizada.setNombre(nuevo.getNombre());
			disqueraManager.save(actualizada);
			return actualizada;
			
		}
		
		return null;
	}

}
