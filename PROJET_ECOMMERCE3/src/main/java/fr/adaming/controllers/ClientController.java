package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;
import fr.adaming.service.MailService;

@Controller
@RequestMapping("/client")
public class ClientController {

	// ===========================================
	// Injection du Service
	// ===========================================
	@Autowired
	private ICategorieService catService;

	@Autowired
	private IProduitService prodService;

	@Autowired
	private MailService mailService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ILigneCommandeService ligneCommandeService;

	// ===========================================
	// Setter pour le Service
	// ===========================================

	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}

	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	// ===========================================
	// PostConstruct
	// ===========================================
	public void init() {
		Admin admin = new Admin();
	}
	// ===========================================
	// Méthodes
	// ===========================================

	/**
	 * Redirect to the client page and show the products list
	 * 
	 * @param modele
	 *            Contains the page attributes
	 * @return The client page
	 */
	@RequestMapping(value = "/pageClient", method = RequestMethod.GET)
	public String affichePageClient(ModelMap modele) {

		// Récupérer la liste des catégories
		List<Categorie> listeCategories = catService.getAllCategorie();

		List<Produit> listeProduits = prodService.getAllProduits();

		modele.addAttribute("listeCat", listeCategories);
		modele.addAttribute("listeProd", listeProduits);

		return "clientPage";
	}

	// Afficher le formulaire de mail
	@RequestMapping(value = "principal/pageMail")
	public String affichePageMail(Model model) {

		model.addAttribute("mail", new SimpleMailMessage());

		return "mailForm";

	}
	// ======================afficher la liste de
	// clients==============================//

	@RequestMapping(value = "/listeClients", method = RequestMethod.GET)
	public ModelAndView afficheListeClient() {

		// recuperation de la liste de produits
		List<Client> listeClient = clientService.getAllClients();

		return new ModelAndView("adminProdPage", "listeClient", listeClient);
	}
	// ==============================Ajouter
	// client====================================//

	@RequestMapping(value = "/afficheAjoutClient", method = RequestMethod.GET)
	// Méthode du formulaire ajouter
	public ModelAndView afficheFormAjoutClient(Model model) {

		List<Client> listeClient = clientService.getAllClients();
		model.addAttribute("clientListe", listeClient);

		// ajout : identifiant de la page ajoutClient.jsp
		return new ModelAndView("ajoutClient", "clientAjout", new Client());

	}

	// =======================//

	@RequestMapping(value = "/insererClient", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @ModelAttribute("clientAjout") Client cl, MultipartFile file) {

		// Appelle de la méthode service
		Client clOut = clientService.addClient(cl);

		if (clOut.getId_client() != 0) { // Actualiser la liste
			List<Client> liste = clientService.getAllClients();
			model.addAttribute("listeClient", liste);

			return "clientPage";
		} else {
			return "redirect:afficheAjoutClient";
		}
	}

	// ==============================Modifier
	// client====================================//

	@RequestMapping(value = "/afficheModifClient", method = RequestMethod.GET)
	public ModelAndView afficherFormModif() {

		return new ModelAndView("modif", "clientModif", new Client());

	}

	// =======================//

	@RequestMapping(value = "/modifierClient", method = RequestMethod.POST)
	public String soumettreFormModif(RedirectAttributes RedirectAttributes, Model model,
			@ModelAttribute("clientModif") Client client) {

		// appelle de la methode service
		Client clOut = clientService.updateClient(client);

		if (clOut.getId_client() != 0) {

			// actualiser la liste dans accueil
			List<Client> liste = clientService.getAllClients();

			// ajout de la liste au model
			model.addAttribute("listeClients", liste);
			return "clientPage";

		} else {
			// le message d'erreur si le client n'est pas modifié
			RedirectAttributes.addFlashAttribute("message", "le clientn'a pas été modifié");
			return "redirect:afficheModifClient";// redirection
		}
	}

	// ==============================Supprimer
	// client====================================//
	@RequestMapping(value = "/afficheSupClient", method = RequestMethod.GET)
	public ModelAndView afficherFormSup() {

		return new ModelAndView("sup", "clientSup", new Client());

	}

	// =======================//

	@RequestMapping(value = "/sup", method = RequestMethod.POST)
	public String soumettreFormSup(RedirectAttributes RedirectAttributes, Model model,
			@ModelAttribute("clientsup") Client client) {

		// appelle de la methode service
		int verif = clientService.deleteClient(client);

		if (verif != 0) {

			// actualiser la liste dans accueil
			List<Client> liste = clientService.getAllClients();

			// ajout de la liste au model
			model.addAttribute("listeClients", liste);

			return "clientPage";

		} else {
			// le message d'erreur si l'etudiant n'est pas modifié
			RedirectAttributes.addFlashAttribute("message", "le client n'a pas été supprimé");
			return "redirect:afficheSupClient";// redirection
		}
	}
	// ============================Avec des
	// liens=========================================//

	@RequestMapping(value = "/SupprimeViaLien", method = RequestMethod.GET)
	public String supViaLien(Model model, @RequestParam("pId") int id_client) {
		Client cIn = new Client();
		cIn.setId_client((long) id_client);
		clientService.deleteClient(cIn);

		// actualiser la liste
		List<Client> liste = clientService.getAllClients();

		return "clientPage";
	}

	// =======================//
	@RequestMapping(value = "/ModifViaLien{pId}")
	public String afficheFormModifViaLien(Model model, @PathVariable("pId") int id_client) {

		Client cIn = new Client();
		cIn.setId_client((long) id_client);
		clientService.updateClient(cIn);
		
		Client clOut = clientService.getClientById(cIn);
		model.addAttribute("clientModif", clOut);

		return "clientPage";

	}

	// =======================//
	@RequestMapping(value = "/AjoutViaLien{pId}")
	public String afficheFormAjoutViaLien(Model model, @PathVariable("pId") int id_client) {

		Client cIn = new Client();
		cIn.setId_client((long) id_client);
		clientService.addClient(cIn);

		// actualiser la liste
		List<Client> liste = clientService.getAllClients();

		return "panierPage";

	}

	// =======================//
	//==se deconnecter===//

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
	
	// ============ Page panier
	/**
	 * Redirect to the basket
	 * 
	 */
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String affichePagePanier(ModelMap modele) {

		Client client = new Client();
		
		// Récupérer la liste des catégories
		List<LigneCommande> listeCommande = ligneCommandeService.GetAllLigneCommande(client);

		modele.addAttribute("listeLigneCommande", listeCommande);

		return "panierPage";
	}


}
