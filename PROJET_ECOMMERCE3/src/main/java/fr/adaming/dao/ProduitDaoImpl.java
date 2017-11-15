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
	public Produit getProduitByDes(Produit produit) {
		Session session = sf.getCurrentSession();
		return (Produit) session.get(Produit.class, produit.getId_produit());
	}

	@Override
	public Produit addProduit(Produit produit) {
		Session session = sf.getCurrentSession();
		
		session.save(produit);
		
		return produit;
	}

	@Override
	public Produit updateProduit(Produit produit) {
		Session session = sf.getCurrentSession();
		
		session.update(produit);
		
		return produit;
	}

	@Override
	public int deleteProduit(Produit produit) {
		Session session = sf.getCurrentSession();
		
		String req = "delete from Produit p where p.id_produit=:pId";
		
		Query query = session.createQuery(req);
		
		query.setParameter("pId", produit.getId_produit());
		
		int verif = query.executeUpdate();
		
		return verif;
	}

}
