package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements ICategorieDao {

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
	// M�thodes
	// ============================================

	@Override
	public Categorie getCategorieById(Categorie cat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie addCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie deleteCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie updateCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method recovers the entire Categorie list in the database
	 * 
	 * @return A list with all the Categories in the database
	 */

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO getAllCategorie

		// 1. R�cup�rer la session
		Session hbs = sf.getCurrentSession();

		// 2. Requ�te HQL
		String req = "FROM Categorie cat";

		// 3. Cr�er un objet Query
		Query hbQuery = hbs.createQuery(req);

		// 4. Envoyer la requ�te et r�cup�rer le r�sultat
		@SuppressWarnings("unchecked")
		List<Categorie> listeCategorie = hbQuery.list();

		// 5. Retourner la liste r�cup�r�e
		return listeCategorie;
	}

}