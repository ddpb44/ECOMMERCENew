package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichePageAccueil(){
		
		return "accueil";
	}

	@RequestMapping(value = "principal/pageAdmin", method = RequestMethod.GET)
	public String affichePageAdmin(ModelMap modele) {

		modele.addAttribute("message", "Bonjour M.admin !! Vous êtes dans votre page ADMIN");

		return "adminPage";
	}

	@RequestMapping(value = "produits/pageAdminProduits", method = RequestMethod.GET)
	public String affichePageAdminProd(ModelMap modele) {

		modele.addAttribute("message", "Bonjour M.admin !! Vous êtes dans votre page ADMIN");

		return "adminProdPage";
	}
}
