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
	// Méthodes
	// ============================================

	/**
	 * To get a "Categorie" with its name
	 * 
	 * @param name
	 *            the name of the "categorie" searched
	 * 
	 * @return the "categorie" searched in the database
	 */
	@Override
	public Categorie getCatByName(String name) {
		// Recuperation de la session
		Session s = sf.getCurrentSession();

		// Le requete HQL
		String req = "FROM Categorie cat WHERE cat.nomCategorie=:pNom";

		// Creer un objet query
		Query query = s.createQuery(req);

		// Passage du param
		query.setParameter("pNom", name);

		Categorie cat_out = (Categorie) query.uniqueResult();

		return cat_out;

	}

	/**
	 * Add a Categorie to the existing list of Categories
	 * 
	 * @param cat
	 *            The Categorie to add
	 * 
	 * @return The added Categorie
	 */
	@Override
	public Categorie addCategorie(Categorie cat) {
		// TODO addCategorie

		// 1. Récupérer la session
		Session hbs = sf.getCurrentSession();

		// 2. Sauvegarder la catégorie dans la base de données
		hbs.save(cat);
		return cat;
	}

	/**
	 * Delete a Categorie from the existing list of Categories
	 * 
	 * @param cat
	 *            The Categorie to delete
	 * 
	 * @return The deleted Categorie
	 */
	@Override
	public Categorie deleteCategorie(Categorie cat) {
		// TODO deleteCategorie

		// 1. Récupérer la session
		Session hbs = sf.getCurrentSession();

		// 2. Supprimer la catégorie dans la base de données
		hbs.delete(cat);

		return cat;
	}

	/**
	 * Update a Categorie and modify the list of Categories
	 * 
	 * @param cat
	 *            The Categorie to update
	 * 
	 * @return The updated Categorie
	 */
	@Override
	public Categorie updateCategorie(Categorie cat) {
		// TODO updateCategorie

		// 1. Récupérer la session
		Session hbs = sf.getCurrentSession();

		// 2. Modifier l'étudiant dans la base de données
		hbs.saveOrUpdate(cat);

		return cat;
	}

	/**
	 * This method recovers the entire Categorie list in the database
	 * 
	 * @return A list with all the Categories in the database
	 */

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO getAllCategorie

		// 1. Récupérer la session
		Session hbs = sf.getCurrentSession();

		// 2. Requête HQL
		String req = "FROM Categorie cat";

		// 3. Créer un objet Query
		Query hbQuery = hbs.createQuery(req);

		// 4. Envoyer la requête et récupérer le résultat
		@SuppressWarnings("unchecked")
		List<Categorie> listeCategorie = hbQuery.list();

		// 5. Retourner la liste récupérée
		return listeCategorie;
	}

}
