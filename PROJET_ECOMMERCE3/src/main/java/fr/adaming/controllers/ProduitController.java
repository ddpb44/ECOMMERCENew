package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	//======================= injection de la dependence service========================//
	@Autowired
	IProduitService prodService;

	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}
	
	
	@RequestMapping(value = "/listeProduits", method = RequestMethod.GET)
	public ModelAndView afficheListeProduit(){
		
		//recuperation de la liste  de produits
		List<Produit> listeProd	 = prodService.getAllProduits();
		
		return new ModelAndView("adminProdPage", "listeProduits", listeProd);
	}
}
