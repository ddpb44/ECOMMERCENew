package fr.adaming.dao;

import java.util.List;

import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {

	// ==================== 1 =====================
	// Injection automatique du sessionFactoryBean
	// ============================================
	@Autowired
	private SessionFactory sf;

	// ==================== 2 =====================
	// Setter pour l'injection
	// ============================================
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// ==================== 3 =====================
	// Méthodes
	// ============================================

	/**
	 * This method recovers the entire Produit list in the database
	 * 
	 * @return A list with all the Produits in the database
	 */
	@Override
	public List<Produit> getAllProduits() {

		Session s = sf.getCurrentSession();

		String req = "from Produit p";

		Query query = s.createQuery(req);

		@SuppressWarnings("unchecked")
		List<Produit> listeProduits = query.list();

		return listeProduits;
	}

	/**
	 * This method recovers a Produit by this id in the database
	 * 
	 * @param produit
	 *            The produit to add
	 * @return A single Produit in the database
	 */
	@Override
	public Produit getProduitById(Produit produit) {
		Session session = sf.getCurrentSession();
		return (Produit) session.get(Produit.class, produit.getId_produit());
	}

	/**
	 * This method recovers a Produit by this designation in the database
	 * 
	 * @param produit
	 *            The produit to add
	 * 
	 * @return A single Produit in the database
	 */
	@Override
	public Produit getProduitByDes(Produit produit) {
		Session session = sf.getCurrentSession();

		// Le requete HQL
		String req = "FROM Produit pro WHERE pro.designation=:pNom";

		// Creer un objet query
		Query query = session.createQuery(req);

		// Passage du param
		query.setParameter("pNom", produit.getDesignation());

		Produit pro_out = (Produit) query.uniqueResult();

		return pro_out;
	}

	/**
	 * Add a Produit to the existing list of Produits
	 * 
	 * @param produit
	 *            The produit to add
	 * 
	 * @return The added Produit
	 */
	@Override
	public Produit addProduit(Produit produit) {
		Session session = sf.getCurrentSession();

		session.save(produit);

		return produit;
	}

	/**
	 * Update a Produit and modify the list of Produits
	 * 
	 * @param produit
	 *            The Produit to update
	 * 
	 * @return The updated Produit
	 */
	@Override
	public Produit updateProduit(Produit produit) {
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(produit);

		return produit;
	}

	/**
	 * Delete a Produit from the existing list of Produits
	 * 
	 * @param produit
	 *            The Produit to delete
	 * 
	 * @return The deleted Produit
	 */
	@Override
	public Produit deleteProduit(Produit produit) {
		Session session = sf.getCurrentSession();

		session.delete(produit);

		return produit;
	}

}
