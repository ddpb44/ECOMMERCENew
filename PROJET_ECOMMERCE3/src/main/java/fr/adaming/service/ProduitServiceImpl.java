package fr.adaming.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {

	// ==================== 1 =====================
	// Injection des collaborateurs
	// ============================================
	@Autowired
	IProduitDao prodDao;

	// ==================== 2 =====================
	// Setters pour l'injection
	// ============================================
	public void setProdDao(IProduitDao prodDao) {
		this.prodDao = prodDao;
	}

	// ==================== 3 =====================
	// Méthodes
	// ============================================
	
	/**
	 * Service method to get the list of all Produits
	 * 
	 * @return A list of all Produits recovered from Dao method
	 */
	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return prodDao.getAllProduits();
	}

	/**
	 * To get a "Produit" with its id
	 * 
	 * @param produit
	 *            the produit searched
	 * 
	 * @return the "produit" searched in the database with DaoMethod
	 */
	@Override
	public Produit getProduitById(Produit produit) {
		Produit prodOut = prodDao.getProduitById(produit);

		if (prodOut.getId_produit() != 0) {
			if (prodOut.getCat().getId_cat() == produit.getCat().getId_cat()) {
				return prodOut;
			}
		}
		return null;
	}

	/**
	 * To get a "Produit" with its designation
	 * 
	 * @param produit
	 *            the produit searched
	 * 
	 * @return the "produit" searched in the database with DaoMethod
	 */
	@Override
	public Produit getProduitByDes(Produit produit) {
		Produit prodOut = prodDao.getProduitByDes(produit);

		if (prodOut.getDesignation() == produit.getDesignation()) {
			if (prodOut.getCat().getId_cat() == produit.getCat().getId_cat()) {
				return prodOut;
			}
		}
		return null;
	}

	/**
	 * Service method to add a Produit to the existing list of Produits
	 * 
	 * @param produit
	 *            the produit to add
	 * 
	 * @return The added Produit recovered from Dao method
	 */
	@Override
	public Produit addProduit(Produit produit) {
		return prodDao.addProduit(produit);
	}

	/**
	 * Service method to update a Produit and modify the list of Produits
	 * 
	 * @param produit
	 *            the produit to update
	 * 
	 * @return The updated Produit recovered from Dao method
	 */
	@Override
	public Produit updateProduit(Produit produit) {

		Produit prodOut = prodDao.getProduitById(produit);

		if (prodOut.getCat().getId_cat() == produit.getCat().getId_cat()) {
			return prodDao.updateProduit(produit);
		}

		return null;
	}

	/**
	 * Service method to delete a Produit from the existing list of Produits
	 * 
	 * @param produit
	 *            the produit to delete
	 * 
	 * @return The deleted Produit recovered from Dao method
	 */
	@Override
	public int deleteProduit(Produit produit) {
		return prodDao.deleteProduit(produit);
	}

}
