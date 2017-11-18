package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/ligneCommande")
public class LigneCommandeController {
	
	// ======================= injection de la dependence service========================//
	@Autowired
	private ILigneCommandeService ligneCommandeService;
	
	@Autowired
	private IProduitService prodService;
	
	@Autowired
	private ICommandeService commandeService;

	// ===================== setter==========================================//
	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	// =============================================================================//
	// ===================== Formulaire ==========================================//

	
	
	
}
