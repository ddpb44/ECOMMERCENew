package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/concept")
public class SiteController {

	/**
	 * Show the website welcome file
	 * 
	 * @return The website welcome file
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String affichePageAccueil() {

		return "accueil";
	}

}
