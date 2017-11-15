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

	@Override
	public Categorie addCategorie(Categorie cat) {
		// TODO addCategorie
		return null;
	}

	@Override
	public Categorie deleteCategorie(Categorie cat) {
		// TODO deleteCategorie
		return null;
	}

	@Override
	public Categorie updateCategorie(Categorie cat) {
		// TODO updateCategorie
		return null;
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
	 * the name of the "categorie" searched
	 * 
	 * @return the "categorie" searched in the database with DaoMethod
	 */
	@Override
	public Categorie getCatByName(String name) {
		return catDao.getCatByName(name);
	}

}
