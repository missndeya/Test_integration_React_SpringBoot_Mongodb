package react.springBoot.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bien implements Serializable{
	@Transient
    public static final String SEQUENCE_NAME = "biens_sequence";
	@Id
	private long idbiens;
	
	private String nom;
	private String description;
	private double prix;
	private Date date;
	private Long nbpiece;
	private String categorie;
	private int idpers;
	

	public Bien(int idbiens, String categorie, Date date, String description, Long nbpiece,  String nom, double prix, int idpers) {
		super();
		this.idbiens = idbiens;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.date = date;
		this.nbpiece = nbpiece;
		this.categorie = categorie;
		this.idpers=idpers;
	}

	public Bien() {
		super();
	}

	public long getIdbiens() {
		return idbiens;
	}

	public void setIdbiens(long  idbiens) {
		this.idbiens = idbiens;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getNbpiece() {
		return nbpiece;
	}

	public void setNbpiece(Long nbpiece) {
		this.nbpiece = nbpiece;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getIdpers() {
		return idpers;
	}

	public void setIdpers(int idpers) {
		this.idpers = idpers;
	}

}
