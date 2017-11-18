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

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Formateur;
import fr.adaming.model.Produit;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
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

	// ===========================================
	// Méthodes
	// ===========================================

	/**
	 * Show the website welcome file
	 * 
	 * @return The website welcome file
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String affichePageAccueil() {

		return "accueil";
	}

	/**
	 * Redirect to the main admin page and show the Categorie list
	 * 
	 * @param modele
	 *            Contains the page attributes
	 * @return The main admin page
	 */
	@RequestMapping(value = "principal/pageClient", method = RequestMethod.GET)
	public String affichePageAdmin(ModelMap modele) {

		// Récupérer la liste des catégories
		List<Categorie> listeCategories = catService.getAllCategorie();

		List<Produit> listeProduits = prodService.getAllProduits();

		modele.addAttribute("listeCat", listeCategories);
		modele.addAttribute("listeProd", listeProduits);
		
		return "clientPage";
	}

	@RequestMapping(value = "produits/pageClientProduits", method = RequestMethod.GET)
	public String affichePageAdminProd(ModelMap modele) {

		// Récupérer la liste des catégories
		List<Categorie> listeCategories = catService.getAllCategorie();
		List<Produit> listeProduits = prodService.getAllProduits();

		modele.addAttribute("listeCat", listeCategories);
		modele.addAttribute("listeProd", listeProduits);

		return "clientProdPage";
	}

	// Afficher le formulaire de mail
	@RequestMapping(value = "principal/pageMail")
	public String affichePageMail(Model model) {

		model.addAttribute("mail", new SimpleMailMessage());

		return "mailForm";

	}
	//======================afficher la liste de clients==============================//
	
	@RequestMapping(value = "/listeClients", method = RequestMethod.GET)
	public ModelAndView afficheListeClient() {

		// recuperation de la liste de produits
		List<Client> listeClient = clientService.getAllClients();

		return new ModelAndView("adminProdPage", "listeClient", listeClient);
	}
	//==============================Ajouter client====================================//

	@RequestMapping(value = "/afficheAjoutClient", method = RequestMethod.GET)
	// Méthode du formulaire ajouter
	public ModelAndView afficheFormAjoutClient(Model model) {

		List<Client> listeClient = clientService.getAllClients();
		model.addAttribute("clientListe", listeClient);

		// ajout : identifiant de la page ajout.jsp
		return new ModelAndView("ajoutClient", "clientAjout", new Client());

	}
	
							//=======================//
	
	
	@RequestMapping(value = "/insererClient", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @ModelAttribute("clientAjout") Client cl, MultipartFile file) {

		// Appelle de la méthode service
		Client clOut = clientService.addClient(cl);

		if (clOut.getId_client() != 0) {			// Actualiser la liste
			List<Client> liste = clientService.getAllClients();
			model.addAttribute("listeClient", liste);

			return "clientPage";
		} else {
			return "redirect:afficheAjoutClient";
		}
	}

}
