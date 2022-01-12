package react.springBoot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profil {

	@Id
	private long id;
	private String profil;
	
	public Profil() {
		super();
	}

	public Profil(long id, String profil) {
		super();
		this.id = id;
		this.profil = profil;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	
}
