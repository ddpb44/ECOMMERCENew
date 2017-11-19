package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;

@Service
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService {

	@Autowired
	private ILigneCommandeDao LigneCommandeDao;

	// setter pour l'injection dependance
	public void setLigneCommandeDao(ILigneCommandeDao ligneCommandeDao) {
		LigneCommandeDao = ligneCommandeDao;
	}

	// ==========================Les
	// methodes==================================================//
	/**
	 * Service method to get the list of all commandes lignes
	 * 
	 * @return A list of all commandes lignes recovered from Dao method
	 */

	@Override
	public List<LigneCommande> GetAllLigneCommande(Client c) {
		return LigneCommandeDao.GetAllLigneCommande(c);
	}

	/**
	 * To get a commande ligne fonction of a client
	 * 
	 * @param client
	 * 
	 * @return the "commande ligne" searched in the database with DaoMethod
	 */
	@Override
	public List<LigneCommande> getLigneCommande(Client c) {
		return LigneCommandeDao.getLigneCommande(c);
	}

	/**
	 * To get a "commande ligne" with its designation
	 * 
	 * @param commande
	 *            ligne and the commande
	 * 
	 * @return the commande ligne searched in the database with DaoMethod
	 */
	@Override
	public LigneCommande addLigneCommandePanier(LigneCommande lc, Commande co) {
		lc.setAttCommande(co);
		return LigneCommandeDao.addLigneCommandePanier(lc);
	}

	/**
	 * Service method to add a commandes lignes to the existing list of
	 * commandes lignes
	 * 
	 * @param commandes
	 *            lignes
	 * 
	 * @return The added commandes lignes recovered from Dao method
	 */
	@Override
	public int deleteLigneCommandePanier(LigneCommande lc, Client c) {
		return LigneCommandeDao.deleteLigneCommandePanier(lc, c);
	}

	/**
	 * Service method to update a commandes lignes and modify the list of
	 * commandes lignes
	 * 
	 * @param commande
	 *            ligne
	 * 
	 * @return The updated commande ligne recovered from Dao method
	 */

	@Override
	public int updateLigneCommande(LigneCommande lc, Client c) {

		LigneCommande lcOut = LigneCommandeDao.getLigneCommandeById(lc);

		if (lcOut.getId_lc() == lc.getId_lc()) {
			return LigneCommandeDao.updateLigneCommande(lc, c);
		}
		return (Integer) null;
	}

	/**
	 * Service method to get commande ligne
	 * 
	 * @return A  commande ligne recovered from Dao method
	 */
	@Override
	public LigneCommande getLigneCommandeById(LigneCommande lc) {
		return LigneCommandeDao.getLigneCommandeById(lc);
	}

	@Override
	public LigneCommande getLigneCommandeById(int id) {
		return LigneCommandeDao.getLigneCommandeById(id);
	}

}
