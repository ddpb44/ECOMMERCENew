package fr.adaming.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
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

	// ==============================Ajouter  commande================//

		@RequestMapping(value = "/afficheAjoutCommande", method = RequestMethod.GET)
		// Méthode du formulaire ajouter
		public ModelAndView afficheFormAjoutCommande(Model model) {

			return new ModelAndView("ligneCommandeListe", "ligneCommandeAjout", new Commande());

		}
		
		// =======================//
		@RequestMapping(value = "/AjoutCommandeViaLien{pId}")
		public String afficheFormAjoutCommandeViaLien(Model model, @PathVariable("pId") int id_co) {

			Client cl= new Client();
			Commande co=new Commande();
			co.setId_commande((long) 1);;
			
			co.setAttClient(cl);
			commandeService.addCommande(co, cl);

			if (co != null) {

				return "panierPage";

			} 

				return "accueilgeneral";
			
		}
		
	
}
