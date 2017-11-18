package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

public class ClientServiceImpl implements IClientService{

	// Injection des collaborateurs
	@Autowired
	private IClientDao clientDao;
	
	//setter pour l'injection dependance
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

//==========================Les methodes==================================================//
	
	/**
	 * Service method to check if the client exist
	 * 
	 * @return a client recovered from Dao method
	 */
	@Override
	public Client isExist(Client cl) {
		return clientDao.isExist(cl);
	}

	/**
	 * Service method to add a client 
	 * 
	 * @param client
	 * 
	 * @return The added client recovered from Dao method
	 */
	@Override
	public Client addClient(Client cl) {
		return clientDao.addClient(cl);
	}

	/**
	 * Service method to update a client 
	 * 
	 * @param client
	 * 
	 * @return The updated client recovered from Dao method
	 */
	@Override
	public Client updateClient(Client cl) {
		return clientDao.updateClient(cl);
	}

	/**
	 * Service method to delete a client 
	 * 
	 * @param client
	 * 
	 * @return The deleted client recovered from Dao method
	 */
	@Override
	public int deleteClient(Client cl) {
		return clientDao.deleteClient(cl);

	}

}
