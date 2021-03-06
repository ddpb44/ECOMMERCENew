package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface IClientService {
	
	public Client isExist(Client cl);
	public Client addClient(Client cl);
	public Client updateClient (Client cl);
	public int deleteClient (Client cl);
	public Client getClientByName(String name);
	public List<Client> getAllClients();
	public Client getClientById(Client cl);
	
}
