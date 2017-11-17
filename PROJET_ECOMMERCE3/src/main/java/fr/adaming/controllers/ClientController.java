package fr.adaming.controllers;

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

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
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

}
