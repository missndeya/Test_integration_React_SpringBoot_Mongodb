package react.springBoot.controller;

import react.springBoot.Exception.RessourceNotFoundException;
import react.springBoot.model.Employe;
import react.springBoot.repository.IEmploye;
import react.springBoot.service.SequenceGeneratorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EmployerController {
    @Autowired
    private IEmploye empRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    
    //Get all rest api 
    @GetMapping(path = "/emp/all")
    public List<Employe> getAllEmp()
    {
        return empRepo.findAll();
    }
   
    //add rest api 
    @PostMapping(path="emp/add")
    public Employe createEmployee(@RequestBody Employe e) {
    	e.setId(sequenceGeneratorService.generateSequence(e.SEQUENCE_NAME));
    	return empRepo.save(e);
    }
    
    //get by id rest api
    @GetMapping(path="/emp/{id}")
    public ResponseEntity<Employe> findEmployeById(@PathVariable Long id) {
    	Employe employe=empRepo.findById(id).orElseThrow();
    	return ResponseEntity.ok(employe);
    }
    
    @GetMapping("/emp/{email}/{pwd}")
    public Employe FindEmployeByEmailAndPwd(@PathVariable String email,@PathVariable String pwd) {
    	return empRepo.findEmployeByEmailAndPwd(email, pwd);
    }
    
    //update rest api
    @PutMapping("emp/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe emp) 
    {
    	Employe empAmodifer=empRepo.findById(id).orElseThrow();
    	empAmodifer.setPrenom(emp.getPrenom());
    	empAmodifer.setNom(emp.getNom());
    	empAmodifer.setEmail(emp.getEmail());
    	empAmodifer.setAge(emp.getAge());
    	empAmodifer.setPassword(emp.getPassword());
    	
    	Employe newEmploye=empRepo.save(empAmodifer);
    	return ResponseEntity.ok(newEmploye);
     }
    
    //delete rest api
    @DeleteMapping("emp/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmploye(@PathVariable Long id) 
    {
    	Employe empAmodifer=empRepo.findById(id).orElseThrow();
    	empRepo.delete(empAmodifer);
    	Map<String,Boolean> response=new HashMap<>();
    	response.put("Supression resussie",Boolean.TRUE);
    	return ResponseEntity.ok(response);
  
     }
}


