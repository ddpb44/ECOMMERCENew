package fr.adaming.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	// =======================================================================//
	// injection dependance service

	@Autowired
	private ICommandeService commandeService;

	@Autowired
	private IClientService clientService;

	// ===================== setter==========================================//
	
	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	// ==================== methodes==============================================//
		
	// ==============================Ajouter commande====================================//

	
	
}
