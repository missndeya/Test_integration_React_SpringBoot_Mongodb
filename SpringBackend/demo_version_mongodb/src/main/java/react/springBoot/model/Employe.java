package react.springBoot.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Employe implements Serializable  {
	@Transient
    public static final String SEQUENCE_NAME = "employes_sequence";
	@Id
	private long id;
	private String  nom;
	private String prenom;
	private int age ;
	private String email;
	private String password;
	private List<Profil> profils;
	public Employe() {
		super();
	}
	public Employe(long id, String nom, String prenom, int age, String email, String password, List<Profil> profils) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.password = password;
		this.profils = profils;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Profil> getProfils() {
		return profils;
	}
	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}
	
	
	
	

}
