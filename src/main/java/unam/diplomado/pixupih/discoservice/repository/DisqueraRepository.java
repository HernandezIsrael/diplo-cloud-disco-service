package unam.diplomado.pixupih.discoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixupih.discoservice.domain.Disquera;

public interface DisqueraRepository extends MongoRepository<Disquera, String> {
	
}
