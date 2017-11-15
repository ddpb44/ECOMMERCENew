package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	IProduitService prodService;

	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}
	
	public ModelAndView afficheListeProduit(){
		
		List<Produit> listeProduits	 = prodService.getAllProduits();
		
		return new ModelAndView("");
	}
}
