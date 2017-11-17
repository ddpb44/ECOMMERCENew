package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Service("catService")
@Transactional
public class CategorieServiceImpl implements ICategorieService {

	// ==================== 1 =====================
	// Injection des collaborateurs
	// ============================================
	@Autowired
	private ICategorieDao catDao;

	// ==================== 2 =====================
	// Setters pour l'injection
	// ============================================

	public void setaDao(ICategorieDao catDao) {
		this.catDao = catDao;
	}

	// ==================== 3 =====================
	// Méthodes
	// ============================================

	/**
	 * Service method to add a Categorie to the existing list of Categories
	 * 
	 * @return The added Categorie recovered from Dao method
	 */
	@Override
	public Categorie addCategorie(Categorie cat) {
		// TODO addCategorie
		return catDao.addCategorie(cat);
	}

	/**
	 * Service method to delete a Categorie from the existing list of Categories
	 * 
	 * @return The deleted Categorie recovered from Dao method
	 */
	@Override
	public Categorie deleteCategorie(Categorie cat) {
		// TODO deleteCategorie
		return catDao.deleteCategorie(cat);
	}

	/**
	 * Service method to update a Categorie and modify the list of Categories
	 * 
	 * @return A list of all Categories recovered from Dao method
	 */
	@Override
	public Categorie updateCategorie(Categorie cat) {
		// TODO updateCategorie
		return catDao.updateCategorie(cat);
	}

	/**
	 * Service method to get the list of all Categories
	 * 
	 * @return A list of all Categories recovered from Dao method
	 */
	@Override
	public List<Categorie> getAllCategorie() {
		// TODO getAllCategorie
		return catDao.getAllCategorie();
	}

	/**
	 * To get a "Categorie" with its name
	 * 
	 * @param name
	 *            the name of the "categorie" searched
	 * 
	 * @return the "categorie" searched in the database with DaoMethod
	 */
	@Override
	public Categorie getCatByName(String name) {
		return catDao.getCatByName(name);
	}

	/**
	 * To get a "Categorie" with its id
	 * 
	 * @param name
	 *            the id of the "categorie" searched
	 * 
	 * @return the "categorie" searched in the database with DaoMethod
	 */
	@Override
	public Categorie getCatById(int id) {
		return catDao.getCatById(id);
	}

}
