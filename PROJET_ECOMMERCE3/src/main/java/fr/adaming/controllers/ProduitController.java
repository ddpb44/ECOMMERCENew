package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	// ======================= injection de la dependence
	// service========================//
	@Autowired
	IProduitService prodService;

	@Autowired
	ICategorieService catService;

	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}

	@RequestMapping(value = "/listeProduits", method = RequestMethod.GET)
	public ModelAndView afficheListeProduit() {

		// recuperation de la liste de produits
		List<Produit> listeProd = prodService.getAllProduits();

		return new ModelAndView("adminProdPage", "listeProd", listeProd);
	}

	@RequestMapping(value = "/afficheAjoutProd", method = RequestMethod.GET)
	// Méthode du formulaire ajouter
	public ModelAndView afficheFormAjout(Model model) {

		List<Categorie> listeCategorie = catService.getAllCategorie();
		model.addAttribute("categoriesListe", listeCategorie);

		// ajout : identifiant de la page ajout.jsp
		return new ModelAndView("ajoutProd", "prodAjout", new Produit());

	}

	@RequestMapping(value = "/insererProduit", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @ModelAttribute("prodAjout") Produit produit, MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				produit.setImageBytes(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long id_cat = produit.getCat().getId_cat();
		
		System.out.println(id_cat);
		
		Categorie categorie = catService.getCatById(id_cat);
		produit.setCat(categorie);

		System.out.println(produit.getCat());

		// Appelle de la méthode service
		Produit prodOut = prodService.addProduit(produit);

		if (prodOut.getId_produit() != 0) {
			// Actualiser la liste
			List<Produit> liste = prodService.getAllProduits();
			model.addAttribute("listeProd", liste);

			return "adminProdPage";
		} else {
			return "redirect:afficheAjoutProd";
		}
	}

	@RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Produit produit) throws IOException {
		Produit prod = prodService.getProduitById(produit);
		if (prod.getImageBytes() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(prod.getImageBytes()));
	}
	
	@RequestMapping(value=("/supprimViaLien"), method=RequestMethod.GET)
	public String suppViaLien (Model model, @RequestParam("pIdProd") long id){
		Produit prodIn = new Produit();
		prodIn.setId_produit(id);
		
		prodService.deleteProduit(prodIn);
		
		List<Produit> liste = prodService.getAllProduits();
		model.addAttribute("listeProd", liste);
		model.addAttribute("catAddForm", new Categorie());
		model.addAttribute("proAddForm", new Produit());

		return "adminPage";
		
	}
	
	@RequestMapping(value = "/afficheModifProd", method = RequestMethod.GET)
	public String afficheFormModif(Model model) {
		
		List<Categorie> listeCategorie = catService.getAllCategorie();
		model.addAttribute("categoriesListe", listeCategorie);

		model.addAttribute("produitModifier", new Produit());
		return "modifProd";
	}

	@RequestMapping(value = "/modifProd", method = RequestMethod.POST)
	public String soumettreFormModif(RedirectAttributes redirectAttribute, Model model,
			@ModelAttribute("produitModifier") Produit produit, MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				produit.setImageBytes(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long id_cat = produit.getCat().getId_cat();
		
		Categorie categorie = catService.getCatById(id_cat);
		produit.setCat(categorie);
		
		// Appel de la méthode service
		Produit prodOut = prodService.updateProduit(produit);

		if (prodOut.getId_produit() == produit.getId_produit()) {
			List<Produit> liste = prodService.getAllProduits();
			model.addAttribute("listeProd", liste);

			return "adminProdPage";
		} else {
			// Message d'erreur si l'étudiant n'a pas été modifié
			redirectAttribute.addFlashAttribute("message", "Le produit n'a pas été modifié");
			return "redirect:adminProdPage";
		}
	}
}
