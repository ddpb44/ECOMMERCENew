package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// Methode pour afficher le formulaire de connexion
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginMethod() {

		return "loginPage";
	}

	// Deconnexion
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String seDeconnecter() {

		return "loginPage";

	}

	@RequestMapping(value = "/loginEchec", method = RequestMethod.GET)
	public String loginErreur(ModelMap modele) {

		modele.addAttribute("erreur", true);
		return "loginPage";

	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String deniedMethod() {

		return "deniedPage";
	}

}
