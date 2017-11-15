package fr.adaming.dao;

import java.util.List;

import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {
	
	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Produit> getAllProduits() {

		Session s = sf.getCurrentSession();
		
		String req = "select * from Produit p";
		
		Query query = s.createQuery(req);
		
		@SuppressWarnings("unchecked")
		List<Produit> listeProduits = query.list();
		
		return listeProduits;
	}

	@Override
	public Produit getProduitById(Produit produit) {
		Session session = sf.getCurrentSession();
		return (Produit) session.get(Produit.class, produit.getId_produit());
	}

	@Override
	public Produit addProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteProduit(Produit produit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
