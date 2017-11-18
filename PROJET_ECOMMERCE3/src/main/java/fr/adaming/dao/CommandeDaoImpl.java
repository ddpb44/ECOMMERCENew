package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;

@Repository
public class CommandeDaoImpl implements ICommandeDao{

	@Autowired // injection automatique du collaborateur sessionFactoryBean
	private SessionFactory sf;

	// setter pour l'injection 
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	//=========================les methodes======================================================//
	
	/**
	 * This method recovers the commandes  which will be add 
	 * 
	 * @param co: commande to add
	 * 
	 * @return the added commande 
	 * 
	 * */
	
	@Override
	public Commande addCommande(Commande co) {
		
		// recuperation de la session
		Session s = sf.getCurrentSession();
				
		System.out.println("commande : " + co);
		s.save(co);		
//				
		
		return co;
	}
	
}
