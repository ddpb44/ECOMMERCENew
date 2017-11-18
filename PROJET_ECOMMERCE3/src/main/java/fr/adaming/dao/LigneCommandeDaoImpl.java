package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;

@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	// =====================Injection
	// sessionFactoryBean=======================//
	@Autowired
	private SessionFactory sf;

	// ====================Setter pour l'injection
	// ============================//
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// ========================= Méthodes
	// =====================================//

	/**
	 * This method recovers  the commandes lignes list in the database
	 * 
	 * @return list which contains all commandes lignes
	 * 
	 * */
	
	@Override
	public List<LigneCommande> GetAllLigneCommande(Client c) {

		// recuperation de la session
		Session s = sf.getCurrentSession(); 

		// La requete HQL
		String req = "FROM LigneCommande lc WHERE lc.attCommande.client.id=:pIdcl";
		
		// creation d'un objet query
		Query query = s.createQuery(req); // recuperation du query de la session

		// passage des paramètres
		query.setParameter("pIdcl", c.getId_client());

		// envoyer la requete et recuperation du resultat
		List<LigneCommande> liste = query.list();

		return liste;
	}
	
	/**
	 * This method recovers the commandes lignes list for a client in the database
	 * 
	 * @param c : client to add
	 * 
	 * @return list which contains all commandes lignes in stand by
	 * 
	 * */

	@Override
	public List<LigneCommande> getLigneCommande(Client c) {

		// recuperation de la session
		Session s = sf.getCurrentSession();

		// La requete HQL
		String req = "FROM LigneCommande lc WHERE lc.valide=:pValide_lc AND lc.attCommande.client.id=:pIdcl ";
		
		// creation d'un objet query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pValide_lc", "En attente");
		query.setParameter("pIdcl", c.getId_client());

		// 5. Envoyer la requête et récupérer le résultat
		List<LigneCommande> lcGet = query.list();

		// 6. Retourner la liste récupérée
		return lcGet;
	}

	/**
	 * This method recovers the commandes lignes in stand by
	 * 
	 * @param lc : commande ligne to add
	 * 
	 * @return list which contains all commandes lignes in stand by
	 * 
	 * */
	
	@Override
	public LigneCommande addLigneCommandePanier(LigneCommande lc) {

		// recuperation de la session
		Session s = sf.getCurrentSession();

		s.save(lc);

		return lc;
	}

	/**
	 * This method recovers the commandes lignes which will be delete from the the orders basket
	 * 
	 * @param lc and c: commande ligne and client to add
	 * 
	 * @return the deleted commande ligne
	 * 
	 * */
	
	@Override
	public int deleteLigneCommandePanier(LigneCommande lc, Client c) {

		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete HQL
		String req = "DELETE LigneCommande lc WHERE lc.id_lc=:pIdlc AND lc.attCommande.id_commande=:pIdco";

		// creation d'un objet query
		Query query = s.createQuery(req);

		// passage des paramètres

		query.setParameter("pIdlc", lc.getId_lc());
		query.setParameter("pIdco", lc.getAttCommande().getId_commande());

		// execution du query
		int verif = query.executeUpdate();

		return verif;
	}

	/**
	 * This method recovers the commandes lignes which will be update 
	 * 
	 * @param lc and c: commande ligne and client to add
	 * 
	 * @return the updated commande ligne
	 * 
	 * */
	
	@Override
	public int updateLigneCommande(LigneCommande lc, Client c) {
		
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// requete HQL
		String req = " UPDATE LigneCommande lc SET lc.quantite=:pQuantite,lc.prix=:pPrix,lc.valide=:pValide WHERE lc.id_lc=:pIdlc AND lc.attCommande.id_com=:pIdco";

		// creation d'un objet query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pQuantite", lc.getQuantite());
		query.setParameter("pPrix", lc.getPrix());
		query.setParameter("pValide", lc.getValide());
		query.setParameter("pIdlc", lc.getId_lc());
		query.setParameter("pIdco", lc.getAttCommande().getId_commande());

		int verif = query.executeUpdate();

		return verif;
	}

}
