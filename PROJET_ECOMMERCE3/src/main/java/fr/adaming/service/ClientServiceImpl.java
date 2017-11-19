package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	// Injection des collaborateurs
	@Autowired
	private IClientDao clientDao;

	// setter pour l'injection dependance
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	// ==========================Les
	// methodes==================================================//

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

	/**
	 * Service method to get a client by his name
	 * 
	 * @param client
	 * 
	 * @return The client searched, recovered from Dao method
	 */
	@Override
	public Client getClientByName(String name) {
		return clientDao.getClientByName(name);
	}

	/**
	 * Service method to get a list of clients
	 * 
	 * @param client
	 * 
	 * @return The clients list, recovered from Dao method
	 */
	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	/**
	 * Service method to get a client by his id
	 * 
	 * @param client
	 * 
	 * @return The client searched, recovered from Dao method
	 */
	@Override
	public Client getClientById(Client cl) {
		return clientDao.getClientById(cl);
	}

}
