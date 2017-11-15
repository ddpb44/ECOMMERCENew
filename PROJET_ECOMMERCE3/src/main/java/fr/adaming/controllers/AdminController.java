package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value = "admin/pageAdmin", method = RequestMethod.GET)
	public String affichePageAdmin(ModelMap modele) {

		modele.addAttribute("message", "Bonjour M.admin !! Vous êtes dans votre page ADMIN");

		return "adminPage";
	}

	@RequestMapping(value = "adminprod/pageAdminProd", method = RequestMethod.GET)
	public String affichePageEmploye(ModelMap modele) {

		modele.addAttribute("message", "Bonjour M.adminProd !! Vous êtes dans votre page ADMIN PROD");

		return "adminProdPage";
	}

}
