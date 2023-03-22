package annuaire;

import java.util.Collection;
import javax.persistence.*;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	public String prenom;
	public String nom;
	@OneToMany(mappedBy="proprietaire", fetch = FetchType.EAGER)
	public Collection<Adresse> adresses;

	public Personne(){}
	
	public Personne(String prenom, String nom) {
		this.setPrenom(prenom);
		this.setNom(nom);
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void addAdresse(Adresse a) {
		this.adresses.add(a);
	}
}
