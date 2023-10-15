package unam.diplomado.pixupih.discoservice.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixupih.discoservice.domain.Disquera;
import unam.diplomado.pixupih.discoservice.repository.DisqueraRepository;
import unam.diplomado.pixupih.discoservice.service.DisqueraService;

@RestController
@RequestMapping(path = "disqueras")
public class DisqueraController implements DisqueraApi{

	@Autowired
	private DisqueraRepository disqueraManager;
	@Autowired
	private DisqueraService disqueraService;
	
	/***************** Mètodos GET *****************/
	
	@GetMapping
	public Iterable<Disquera> obtenerDisqueras(){
		return disqueraManager.findAll();
	}
	
	//
	
	@GetMapping("{id}")
	public ResponseEntity<Disquera> obtenerDisqueraById(@PathVariable("id") String id){
		
		Optional<Disquera> existe = disqueraManager.findById(id);
		if(existe.isPresent()) {
			return new ResponseEntity<Disquera>(existe.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	/***************** Mètodos POST *****************/
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Disquera crearDisquera(@RequestBody Disquera nuevo) {
		Disquera saved = disqueraManager.save(nuevo);
		return saved;
	}
	
	/***************** Mètodos PUT *****************/
	
	@PutMapping(path = "{id}", consumes = "application/json")
	public ResponseEntity<Disquera> actualizaDisquera(@PathVariable("id") String id, @RequestBody Disquera nueva) {
		
		Disquera actualizada = disqueraService.actualizarDisquera(id, nueva);
		
		if(actualizada != null) {
			
			return new ResponseEntity<Disquera>(actualizada, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	/***************** Mètodos DELETE *****************/
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarDisqueraPorId(@PathVariable("id") String id){
		
		disqueraManager.deleteById(id);
		
	}

}
