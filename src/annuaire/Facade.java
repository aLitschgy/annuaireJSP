package annuaire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.sql.*;



@Singleton

public class Facade {
	Connection con;

	String requete;
	
	@PostConstruct
	void init() throws SQLException, ClassNotFoundException {
	String db_url = "jdbc:hsqldb:hsql://localhost/xdb";
	String db_user = "sa";
	Class.forName("org.hsqldb.jdbcDriver");
	con = DriverManager.getConnection(db_url, db_user, null);
	}

	public void ajoutPersonne(String nom, String prenom) {
		requete = "INSERT INTO personne (prenom, nom) VALUES ('" +prenom+"', '"+nom+"')";
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery(requete);
		} catch (SQLException e) {
	          e.printStackTrace();
		}
	}
	
	public void ajoutAdresse(String rue, String ville) {
		requete = "INSERT INTO adresse (rue, ville) VALUES ('" +rue+"', '"+ville+"')";
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery(requete);
		} catch (SQLException e) {
	          e.printStackTrace();
		}
	}
	
	public void associer(int personneId, int adresseId) {
		requete = "UPDATE adresse SET personneid = '"+personneId+"' WHERE (id='"+adresseId+"')";
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery(requete);
		} catch (SQLException e) {
	          e.printStackTrace();
		}
				
	}
	
	public Collection<Personne> listePersonnes(){
		ArrayList<Personne> lp = new ArrayList<Personne>();
		requete = "SELECT * FROM personne";

		try {
			Statement sta = con.createStatement();
			ResultSet res = sta.executeQuery(requete);
			while (res.next()) {
		        String prenom = res.getString("prenom");
		        String nom = res.getString("nom");
		        Integer id = Integer.parseInt(res.getString("id"));
		        Personne p = new Personne(id, prenom, nom);
		        
		        requete = "SELECT * FROM adresse WHERE personneid='"+id+"'";
		        Statement sta2 = con.createStatement();
				ResultSet res2 = sta2.executeQuery(requete);
				while (res2.next()) {
					String rue = res2.getString("rue");
					String ville = res2.getString("ville");
					Integer id2 = Integer.parseInt(res2.getString("id"));
					Adresse a = new Adresse(id2, rue, ville);
					p.adresses.add(a);
				}
				lp.add(p);
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lp;
	};
	
	public Collection<Adresse> listeAdresses(){
		ArrayList<Adresse> la = new ArrayList<Adresse>();
		requete = "SELECT * FROM adresse";

		try {
			Statement sta = con.createStatement();
			ResultSet res = sta.executeQuery(requete);
			while (res.next()) {
		        String rue = res.getString("rue");
		        String ville = res.getString("ville");
		        Integer id = Integer.parseInt(res.getString("id"));
		        Adresse a = new Adresse(id, rue, ville);
				la.add(a);
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return la;
	};

}