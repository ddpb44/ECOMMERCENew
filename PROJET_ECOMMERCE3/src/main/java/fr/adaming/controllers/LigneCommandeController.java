package fr.adaming.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/ligneCommande")
public class LigneCommandeController {

	// ======================= injection de la dependence
	// service========================//
	@Autowired
	private ILigneCommandeService ligneCommandeService;

	@Autowired
	private IProduitService prodService;

	@Autowired
	private ICommandeService commandeService;

	@Autowired
	private IClientService clientService;

	// ===================== setter==========================================//
	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	Client client;

	// ===========================================
	// PostConstruct
	// ===========================================
	public void init() {
		this.client = new Client();

	}

	// ======================afficher la liste des lignes
	// commandes======================//
	@RequestMapping(value = "/principal/pageLigneCommande", method = RequestMethod.GET)
	public String afficheListeLigneCommande(ModelMap modele) {

		// Récupérer la liste des lignes de commandes
		List<LigneCommande> listeLigneCommandes = ligneCommandeService.GetAllLigneCommande(this.client);

		modele.addAttribute("ligneCommandeListe", listeLigneCommandes);
		
		return "panierPage";
	}

	// ==============================Ajouter ligne commande================//

	@RequestMapping(value = "/afficheAjoutLigneCommande", method = RequestMethod.GET)
	// Méthode du formulaire ajouter
	public ModelAndView afficheFormAjoutLigneCommande(Model model) {

		List<LigneCommande> listeLigneCommandes = ligneCommandeService.GetAllLigneCommande(this.client);
		model.addAttribute("ligneCommandeListe", listeLigneCommandes);

		// ajout : identifiant de la page ajoutLigneCommande.jsp
		return new ModelAndView("ligneCommandeListe", "ligneCommandeAjout", new LigneCommande());

	}

	// =======================//
	@RequestMapping(value = "/AjoutLigneCommande", method = RequestMethod.POST)
	public String afficheFormAjoutLigneCommande(Model model, @ModelAttribute("ligneCommandeAjout") LigneCommande ligneCommande, 
			HttpSession session) {

		LigneCommande lcIn = new LigneCommande();
		Commande co = new Commande();

		// ajouter un client dans la commande
		co.setAttClient(this.client);

		// ajout de commande
		co = commandeService.addCommande(co, this.client);

		// ajouter les informations dans le panier
		Produit prodAjout = new Produit();
		lcIn.setAttProduit(prodAjout);
		prodAjout = prodService.getProduitById(prodAjout);
		lcIn.setPrix(prodAjout.getPrix() * lcIn.getQuantite());

		lcIn.setAttCommande(co);
		ligneCommandeService.addLigneCommandePanier(lcIn, co);

		// actualiser la liste
		List<LigneCommande> liste = ligneCommandeService.GetAllLigneCommande(this.client);

		model.addAttribute("listeligneCommande", liste);

		return "panierPage";

	}

	// ==============================Modifier ligne commande================//

	@RequestMapping(value = "/afficheModifLigneCommande", method = RequestMethod.GET)
	public ModelAndView afficherFormModifLigneCommande() {

		return new ModelAndView("modifLigneCommande", "ligneCommandeModif", new LigneCommande());

	}

	// =======================//
	@RequestMapping(value = "/ModifLigneCommandeViaLien{pId}")
	public String afficheFormModifLigneCommandeViaLien(Model model, @PathVariable("pId") int id_lc,
			HttpSession session) {

		LigneCommande lcIn = new LigneCommande();
		lcIn.setId_lc(id_lc);

		// Trouver la ligne à modifier
		LigneCommande lcUp = (LigneCommande) ligneCommandeService.getLigneCommande(this.client);

		// Modifier la ligne retrouvée
		lcUp.setValide(lcIn.getValide());

		ligneCommandeService.updateLigneCommande(lcIn, this.client);

		// actualiser la liste
		List<LigneCommande> liste = ligneCommandeService.GetAllLigneCommande(this.client);

		return "panierPage";

	}

	// ==============================Supprimer ligne commande================//
	@RequestMapping(value = "/afficheSupLigneCommande", method = RequestMethod.GET)
	public ModelAndView afficherFormSupLigneCommande() {

		return new ModelAndView("sup", "LigneCommandeSup", new LigneCommande());

	}

	// =======================//
	@RequestMapping(value = "/SupprimeLigneCommandeViaLien", method = RequestMethod.GET)
	public String supLigneCommandeViaLien(Model model, @RequestParam("pId") int id_lc, HttpSession session) {

		// Trouver le produit à supprimer
		LigneCommande lcIn = (LigneCommande) ligneCommandeService.getLigneCommande(this.client);

		// Supprimer le produit recherché
		ligneCommandeService.deleteLigneCommandePanier(lcIn, this.client);

		// actualiser la liste
		List<LigneCommande> liste = ligneCommandeService.GetAllLigneCommande(this.client);

		return "panierPage";
	}

	// ==============================Rechercher ligne commande================//
	@RequestMapping(value = "/afficheRechercheLigneCommande", method = RequestMethod.GET)
	public String afficheFormRechercheLigneCommande(ModelMap model) {

		model.addAttribute("ligneCommandeRecherche", new LigneCommande());

		return "panierPage";
	}

	// =======================//
	@RequestMapping(value = "/RechercheLigneCommandeViaLien", method = RequestMethod.GET)
	public String rechercheLigneCommandeViaLien(Model model, @RequestParam("pId") int id_lc, HttpSession session) {

		LigneCommande lcIn = new LigneCommande();
		lcIn.setId_lc(id_lc);

		ligneCommandeService.getLigneCommande(this.client);

		// actualiser la liste
		List<LigneCommande> liste = ligneCommandeService.GetAllLigneCommande(this.client);

		return "panierPage";
	}

	// ==============================Valider ligne commande================//

	@RequestMapping(value = "/afficheValideLigneCommande", method = RequestMethod.GET)
	public String afficheFormValiderLignecommande(ModelMap model) {

		model.addAttribute("ligneCommandeValide", new LigneCommande());

		return "panierPage";
	}
	// =======================//

	@RequestMapping(value = "/ValideLigneCommandeViaLien", method = RequestMethod.GET)
	public String valideLigneCommandeViaLien(Model model, HttpSession session) {
	
		double sommePrixTotal = 0;
		List<LigneCommande> listeLigneCommandes = ligneCommandeService.GetAllLigneCommande(this.client);
		
		for (LigneCommande ligne : listeLigneCommandes) {
			if (ligne.getValide().equals("En attente")) {

				// Récupérer le produit commandé
				Produit prodValide = ligne.getAttProduit();
				prodValide = prodService.getProduitById(prodValide);
				prodValide.setQuantite(prodValide.getQuantite() - ligne.getQuantite());

				if (prodValide.getQuantite() > 0) {

					sommePrixTotal = sommePrixTotal + ligne.getPrix();
					ligne.setValide("Payée");
					Commande commande =new Commande();
					commande.setAttClient(this.client);

					prodService.updateProduit(prodValide);
					ligneCommandeService.updateLigneCommande(ligne, this.client);

				} else if (prodValide.getQuantite() == 0) {

					sommePrixTotal = sommePrixTotal + ligne.getPrix();
					ligne.setValide("Payée");
					prodService.deleteProduit(prodValide);
					
					Commande commande =new Commande();
					commande.setAttClient(this.client);

					prodService.updateProduit(prodValide);
					ligneCommandeService.updateLigneCommande(ligne, this.client);

				} else {
					return "panierPage";
				}
			} else {
				continue;
			}

		}

		return "panierPage";
	
	
	
	
	}
}
