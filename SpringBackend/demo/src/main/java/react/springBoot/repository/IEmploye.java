package react.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import react.springBoot.model.Employe;

@RepositoryRestResource
public interface IEmploye  extends JpaRepository<Employe,Long>{

}
