package annuaire;

import java.util.Collection;
import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class Facade {
	
	@PersistenceContext
	EntityManager em;

	public void ajoutPersonne(String nom, String prenom) {
		Personne p = new Personne(prenom, nom);
		em.persist(p);
	}
	
	public void ajoutAdresse(String rue, String ville) {
		Adresse a = new Adresse(rue, ville);
		em.persist(a);
	}
	
	public void associer(int personneId, int adresseId) {
		Personne p = em.find(Personne.class, personneId);
		Adresse a = em.find(Adresse.class, adresseId);
		a.setProprietaire(p);
	}
	
	public Collection<Personne> listePersonnes(){
		return em.createQuery("from Personne", Personne.class).getResultList();
	};
	
	public Collection<Adresse> listeAdresses(){
		return em.createQuery("from Adresse", Adresse.class).getResultList();
	};

}