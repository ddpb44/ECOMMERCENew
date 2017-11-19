package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {

	public Client isExist(Client cl);
	public Client addClient(Client cl);
	public Client updateClient (Client cl);
	public int deleteClient (Client cl);
	public Client getClientByName(String name);
	public List<Client> getAllClients();
	public Client getClientById(Client cl);
	
}
