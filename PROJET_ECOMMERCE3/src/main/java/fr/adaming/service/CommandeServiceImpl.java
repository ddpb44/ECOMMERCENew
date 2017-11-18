package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

@Service
@Transactional
public class CommandeServiceImpl implements ICommandeService{

	
	@Autowired
	private ICommandeDao CommandeDao;
	
	//setter pour l'injection dependance
	public void setCommandeDao(ICommandeDao commandeDao) {
		CommandeDao = commandeDao;
	}
	
	//==========================Les methodes==================================================//

	@Override
	public Commande addCommande(Commande co, Client cl) {
		co.setAttClient(cl);
		return CommandeDao.addCommande(co);
	}

}
