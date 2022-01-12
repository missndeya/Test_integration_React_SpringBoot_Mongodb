package react.springBoot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import react.springBoot.model.Employe;

@Repository
public interface IEmploye  extends MongoRepository<Employe,Long>{
  
	@Query("{email: ?0, password: ?1}") 
	Employe findEmployeByEmailAndPwd(String email,String password);
	
}
