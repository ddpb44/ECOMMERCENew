package fr.adaming.service;

import fr.adaming.model.Client;

public interface IClientService {
	
	public Client isExist(Client cl);
	public Client addClient(Client cl);
	public Client updateClient (Client cl);
	public int deleteClient (Client cl);

}
