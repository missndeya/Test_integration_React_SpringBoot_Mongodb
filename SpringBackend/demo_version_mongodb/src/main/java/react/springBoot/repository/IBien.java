package react.springBoot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import react.springBoot.model.Bien;

@Repository
public interface IBien extends MongoRepository<Bien,Long>{

}
