package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface ICommandeService {
	
	public Commande addCommande(Commande co, Client cl);

}
