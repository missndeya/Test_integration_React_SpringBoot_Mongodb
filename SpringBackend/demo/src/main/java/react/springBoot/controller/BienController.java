package react.springBoot.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import react.springBoot.Exception.RessourceNotFoundException;
import react.springBoot.model.Bien;
import react.springBoot.model.Employe;
import react.springBoot.repository.IBien;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class BienController {
    @Autowired
    private IBien bienRepo;

    //get rest api 
    @GetMapping(path = "/bien/all")
    public @ResponseBody
    Iterable<Bien> getAllBien()
    {
        return bienRepo.findAll();
    }

    //add rest api
    @PostMapping("/bien/add")
    public Bien addBien(@RequestBody Bien p){
        return bienRepo.save(p);
    }
    
    //get by id rest api
    
    @GetMapping(path="/bien/{id}")
    public ResponseEntity<Bien> getBienById(@PathVariable Long id){
    	Bien bien=bienRepo.findById(id).orElseThrow();
    	return ResponseEntity.ok(bien);
    }
    
    
   //update rest api
    @PutMapping(path="/bien/{id}")
    public ResponseEntity<Bien> updateBien(@PathVariable Long  id,@RequestBody Bien bien )
    {
    	Bien bienUpadte=bienRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(" "));
    	bienUpadte.setCategorie(bien.getCategorie());
    	bienUpadte.setDate(bien.getDate());
    	bienUpadte.setDescription(bien.getCategorie());
    	bienUpadte.setNom(bien.getNom());
    	
        Bien bienOk=bienRepo.save(bienUpadte);
    	return ResponseEntity.ok(bienOk) ;
    }
    
    @DeleteMapping(path="/bien/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBien(@PathVariable Long id ){
    	Bien bienAsuppr=bienRepo.findById(id).orElseThrow();
    	bienRepo.delete(bienAsuppr);
    	Map<String,Boolean> map=new HashMap<>();
        map.put("Suppression reussie", Boolean.TRUE);
        return ResponseEntity.ok(map);
    }
}


