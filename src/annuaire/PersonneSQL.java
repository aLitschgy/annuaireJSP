package annuaire;

import java.util.ArrayList;

public class Personne {
	public Integer id;
	public String prenom;
	public String nom;
	public ArrayList<Adresse> adresses = new ArrayList<Adresse>();

	public Personne(Integer id, String prenom, String nom) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}
}
