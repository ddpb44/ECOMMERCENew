package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/admin")
public class CategorieController {

	// ===========================================
	// Injection du Service
	// ===========================================
	@Autowired
	private ICategorieService catService;

	// ===========================================
	// Setter pour le Service
	// ===========================================

	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}

	// //Affichr le formulaire de modification
	// @RequestMapping(value = "/afficheModif", method = RequestMethod.GET)
	// public ModelAndView afficheFormCatUpdate(){
	//
	// return new ModelAndView ("modifAdminCatPage", "catUpdateForm", new
	// Categorie());
	//
	//
	// }

	// Faire la modification
	@RequestMapping(value = "principal/modifierCat", method = RequestMethod.POST)
	public String modifCat(Model model, @ModelAttribute("catUpdateForm") Categorie cat, RedirectAttributes red) {

		Categorie cOut = catService.updateCategorie(cat);
		if (cOut != null) {

			List<Categorie> listeCategories = catService.getAllCategorie();
			model.addAttribute("listeCat", listeCategories);
			model.addAttribute("catAddForm", new Categorie());
			return "adminPage";

		} else {
			red.addFlashAttribute("message", "La categorie n'a pas pu être modifiée");
			return "redirect:afficheModif";
		}

	}

	// Recuperer les information via le lien de la categorie de la ligne
	// associée
	@RequestMapping(value = "principal/modifViaLien", method = RequestMethod.GET)
	public ModelAndView modifViaLien(@RequestParam("pName") String name) {

		Categorie cat = new Categorie();
		cat.setNomCategorie(name);

		Categorie cOut = catService.getCatByName(name);

		return new ModelAndView("modifAdminCatPage", "catUpdateForm", cOut);

	}

	@RequestMapping(value = "principal/supprimViaLien/{pId}", method = RequestMethod.GET)
	public String supprimViaLien(Model model, @PathVariable("pId") long id) {

		Categorie cat = new Categorie();
		cat.setId_cat(id);
		catService.deleteCategorie(cat);

		List<Categorie> listeCategories = catService.getAllCategorie();
		model.addAttribute("listeCat", listeCategories);
		model.addAttribute("catAddForm", new Categorie());

		return "adminPage";
	}

	// Faire l'ajout
	@RequestMapping(value = "principal/ajouterCat", method = RequestMethod.POST)
	public String ajoutCat(Model model, @ModelAttribute("catAddForm") Categorie cat, RedirectAttributes red) {

		Categorie cOut = catService.addCategorie(cat);
		if (cOut != null) {

			List<Categorie> listeCategories = catService.getAllCategorie();
			model.addAttribute("listeCat", listeCategories);
			return "adminPage";

		} else {
			red.addFlashAttribute("message", "La categorie n'a pas pu être ajoutée");
			return "adminPage";
		}

	}

}
