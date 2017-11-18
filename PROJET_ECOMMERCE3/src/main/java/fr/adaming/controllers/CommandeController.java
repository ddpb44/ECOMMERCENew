package fr.adaming.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.ICommandeService;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	// =======================================================================//
	// injection dependance service

	@Autowired
	private ICommandeService commandeService;

	
	// ===================== setter==========================================//
}
