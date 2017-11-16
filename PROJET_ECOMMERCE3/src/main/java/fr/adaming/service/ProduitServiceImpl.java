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

	@Autowired
	IProduitDao prodDao;

	public void setProdDao(IProduitDao prodDao) {
		this.prodDao = prodDao;
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return prodDao.getAllProduits();
	}

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

	@Override
	public Produit addProduit(Produit produit) {
		return prodDao.addProduit(produit);
	}

	@Override
	public Produit updateProduit(Produit produit) {

		Produit prodOut = prodDao.getProduitById(produit);

		if (prodOut.getCat().getId_cat() == produit.getCat().getId_cat()) {
			return prodDao.updateProduit(produit);
		}

		return null;
	}

	@Override
	public int deleteProduit(Produit produit) {
		return prodDao.deleteProduit(produit);
	}

}
