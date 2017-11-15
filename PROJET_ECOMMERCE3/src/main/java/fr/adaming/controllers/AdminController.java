package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	// ===========================================
	// Injection du Service
	// ===========================================
	@Autowired
	private ICategorieService catService;
	
	@Autowired
	private IProduitService prodService;

	// ===========================================
	// Setter pour le Service
	// ===========================================

	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}
	
	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}


	// ===========================================
	// PostConstruct
	// ===========================================


	
	// ===========================================
	// Méthodes
	// ===========================================
	
	/**
	 * Show the website welcome file
	 * @return The website welcome file
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String affichePageAccueil() {

		return "accueil";
	}

	/**
	 * Redirect to the main admin page and show the Categorie list
	 * @param modele 
	 * 				Contains the page attributes
	 * @return The main admin page
	 */
	@RequestMapping(value = "principal/pageAdmin", method = RequestMethod.GET)
	public String affichePageAdmin(ModelMap modele) {

		// Récupérer la liste des catégories
		List<Categorie> listeCategories = catService.getAllCategorie();
		
		List<Produit> listeProduits = prodService.getAllProduits();
		
		modele.addAttribute("message", "Bonjour M.admin !! Vous êtes dans votre page ADMIN");
		
		modele.addAttribute("listeCat", listeCategories);
		modele.addAttribute("listeProd", listeProduits);

		return "adminPage";
	}

	@RequestMapping(value = "produits/pageAdminProduits", method = RequestMethod.GET)
	public String affichePageAdminProd(ModelMap modele) {

		modele.addAttribute("message", "Bonjour M.admin !! Vous êtes dans votre page ADMIN");

		return "adminProdPage";
	}
}
