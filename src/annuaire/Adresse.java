package annuaire;

import javax.persistence.*;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	public String ville;
	public String rue;
	@ManyToOne
	Personne proprietaire;
	
	public Adresse(){}
	
	public Adresse(String rue, String ville) {
		this.setRue(rue);
		this.setVille(ville);
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public void setProprietaire(Personne p) {
		this.proprietaire = p;
	}
	
	
}
