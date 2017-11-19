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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/admin")
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

	/**
	 * Show the products list
	 * 
	 * @return The main admin page
	 */
	// @RequestMapping(value = "/listeProduits", method = RequestMethod.GET)
	// public ModelAndView afficheListeProduit() {
	//
	// // recuperation de la liste de produits
	// List<Produit> listeProd = prodService.getAllProduits();
	//
	// return new ModelAndView("adminProdPage", "listeProd", listeProd);
	// }

	@RequestMapping(value = "produits/afficheAjoutProd", method = RequestMethod.GET)
	// Méthode du formulaire ajouter
	public ModelAndView afficheFormAjout(Model model) {

		List<Categorie> listeCategorie = catService.getAllCategorie();
		model.addAttribute("categoriesListe", listeCategorie);

		// ajout : identifiant de la page ajout.jsp
		return new ModelAndView("ajoutProd", "prodAjout", new Produit());

	}

	/**
	 * The add product method for the product admin
	 * 
	 * @param model
	 * @param produit
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "produits/insererProduit", method = RequestMethod.POST)
	public String soumettreFormAjout(Model model, @ModelAttribute("proAddForm") Produit produit, MultipartFile file) {

		// try {
		// if (!file.isEmpty()) {
		// produit.setImageBytes(file.getBytes());
		// }
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// long id_cat = produit.getCat().getId_cat();
		//
		// System.out.println(id_cat);
		//
		// Categorie categorie = catService.getCatById(id_cat);
		// produit.setCat(categorie);
		//
		// System.out.println(produit.getCat());

		// Appelle de la méthode service
		// Produit prodOut = prodService.addProduit(produit);
		//
		//// if (prodOut.getId_produit() != 0) {
		// // Actualiser la liste
		// List<Produit> liste = prodService.getAllProduits();
		// model.addAttribute("listeProd", liste);
		// List<Categorie> listeCategorie = catService.getAllCategorie();
		// model.addAttribute("listeCat", listeCategorie);
		// model.addAttribute("catAddForm", new Categorie());
		// model.addAttribute("proAddForm", new Produit());

		return "redirect:pageAdminProduits";

		// } else {
		// return "redirect:pageAdminProduits";
		// }
	}

	/**
	 * The add product method for the product admin
	 * 
	 * @param model
	 * @param produit
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "principal/insererProduit", method = RequestMethod.POST)
	public String AjoutProduitByAdminPrincipal(Model model, @ModelAttribute("proAddForm") Produit proAddForm,
			MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				proAddForm.setImageBytes(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// long id_cat = produit.getCat().getId_cat();
		//
		// System.out.println(id_cat);
		//
		// Categorie categorie = catService.getCatById(id_cat);
		// produit.setCat(categorie);
		//
		// System.out.println(produit.getCat());

		// Appelle de la méthode service
		prodService.addProduit(proAddForm);

		// Actualiser la liste
		List<Produit> liste = prodService.getAllProduits();
		model.addAttribute("listeProd", liste);
		List<Categorie> listeCategorie = catService.getAllCategorie();
		model.addAttribute("listeCat", listeCategorie);
		model.addAttribute("catAddForm", new Categorie());
		model.addAttribute("proAddForm", new Produit());

		return "adminPage";
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

	/**
	 * Delete a product by clicking on a link. Method for the main admin.
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = ("principal/supprimProduitViaLien/{pIdProd}"), method = RequestMethod.GET)
	public String suppViaLienAdminPrincipal(Model model, @PathVariable("pIdProd") long id) {

		Produit prodIn = new Produit();
		prodIn.setId_produit(id);

		prodService.deleteProduit(prodIn);

		List<Produit> liste = prodService.getAllProduits();
		model.addAttribute("listeProd", liste);
		List<Categorie> listeCategories = catService.getAllCategorie();
		model.addAttribute("listeCat", listeCategories);
		model.addAttribute("catAddForm", new Categorie());
		model.addAttribute("proAddForm", new Produit());

		return "adminPage";
	}

	/**
	 * Delete a product by clicking on a link. Method for the product admin.
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = ("produits/supprimProduitViaLien/{pIdProd}"), method = RequestMethod.GET)
	public String suppViaLienAdminProduit(Model model, @PathVariable("pIdProd") long id) {

		Produit prodIn = new Produit();
		prodIn.setId_produit(id);

		prodService.deleteProduit(prodIn);

		List<Produit> liste = prodService.getAllProduits();
		model.addAttribute("listeProd", liste);
		List<Categorie> listeCategorie = catService.getAllCategorie();
		model.addAttribute("listeCat", listeCategorie);
		model.addAttribute("catAddForm", new Categorie());
		model.addAttribute("proAddForm", new Produit());

		return "adminProdPage";
	}

	/**
	 * Show the update product form for the product Admin.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "produits/afficheModifProd", method = RequestMethod.GET)
	public String afficheFormModif(Model model) {

		// List<Categorie> listeCategorie = catService.getAllCategorie();
		// model.addAttribute("categoriesListe", listeCategorie);

		model.addAttribute("proUpdateForm", new Produit());

		return "modifProd";
	}

	/**
	 * Show the update product form for the main Admin.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "principal/afficheModifProd", method = RequestMethod.GET)
	public String afficheFormModifAdminPrincipal(Model model) {

		// List<Categorie> listeCategorie = catService.getAllCategorie();
		// model.addAttribute("categoriesListe", listeCategorie);

		List<Categorie> listeCategories = catService.getAllCategorie();
		model.addAttribute("listeCat", listeCategories);
		model.addAttribute("proUpdateForm", new Produit());

		return "modifProdAdminPrincipal";
	}

	/**
	 * Update a product. Method for product admin
	 * 
	 * @param redirectAttribute
	 * @param model
	 * @param produit
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "produits/modifProd", method = RequestMethod.POST)
	public String soumettreFormModif(RedirectAttributes redirectAttribute, Model model,
			@ModelAttribute("proUpdateForm") Produit produit, MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				produit.setImageBytes(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// long id_cat = produit.getCat().getId_cat();
		//
		// Categorie categorie = catService.getCatById(id_cat);
		// produit.setCat(categorie);

		// Appel de la méthode service
		Produit prodOut = prodService.updateProduit(produit);

		if (prodOut != null) {
			List<Produit> liste = prodService.getAllProduits();
			model.addAttribute("listeProd", liste);

			List<Categorie> listeCategorie = catService.getAllCategorie();
			model.addAttribute("listeCat", listeCategorie);

			model.addAttribute("catAddForm", new Categorie());
			model.addAttribute("proAddForm", new Produit());

			return "adminProdPage";
		} else {
			// Message d'erreur si l'étudiant n'a pas été modifié
			redirectAttribute.addFlashAttribute("message", "Le produit n'a pas été modifié");
			return "redirect:adminProdPage";
		}
	}

	/**
	 * Update a product. Method for main admin
	 * 
	 * @param redirectAttribute
	 * @param model
	 * @param produit
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "principal/modifProd", method = RequestMethod.POST)
	public String soumettreFormModifAdminPrincipal(RedirectAttributes redirectAttribute, Model model,
			@ModelAttribute("proUpdateForm") Produit produit, MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				produit.setImageBytes(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// long id_cat = produit.getCat().getId_cat();
		//
		// Categorie categorie = catService.getCatById(id_cat);
		// produit.setCat(categorie);

		// Appel de la méthode service
		Produit prodOut = prodService.updateProduit(produit);

		if (prodOut != null) {
			List<Produit> liste = prodService.getAllProduits();
			model.addAttribute("listeProd", liste);

			List<Categorie> listeCategorie = catService.getAllCategorie();
			model.addAttribute("listeCat", listeCategorie);

			model.addAttribute("catAddForm", new Categorie());
			model.addAttribute("proAddForm", new Produit());

			return "adminPage";
		} else {
			// Message d'erreur si l'étudiant n'a pas été modifié
			redirectAttribute.addFlashAttribute("message", "Le produit n'a pas été modifié");
			return "redirect:adminPage";
		}
	}

	@RequestMapping(value = "produits/modifProduitViaLien", method = RequestMethod.GET)
	public String modifProduitViaLien(Model model, @RequestParam("pName") String name) {

		Produit pro = new Produit();
		pro.setDesignation(name);

		Produit pOut = prodService.getProduitByDes(pro);

		List<Categorie> listeCategories = catService.getAllCategorie();

		model.addAttribute("proUpdateForm", pOut);
		model.addAttribute("listeCat", listeCategories);

		return "modifProd";

	}

	@RequestMapping(value = "principal/modifProduitViaLien", method = RequestMethod.GET)
	public String modifPrincipalViaLien(Model model, @RequestParam("pName") String name) {

		Produit pro = new Produit();
		pro.setDesignation(name);

		Produit pOut = prodService.getProduitByDes(pro);
		List<Categorie> listeCategories = catService.getAllCategorie();

		List<Categorie> listeCategorie = catService.getAllCategorie();
		model.addAttribute("listeCat", listeCategorie);

		model.addAttribute("proUpdateForm", pOut);
		model.addAttribute("listeCat", listeCategories);

		return "modifProdAdminPrincipal";

	}

}
