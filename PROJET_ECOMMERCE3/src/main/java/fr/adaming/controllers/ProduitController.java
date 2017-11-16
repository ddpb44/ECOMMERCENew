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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	// ======================= injection de la dependence
	// service========================//
	@Autowired
	IProduitService prodService;

	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}

	@RequestMapping(value = "/listeProduits", method = RequestMethod.GET)
	public ModelAndView afficheListeProduit() {

		// recuperation de la liste de produits
		List<Produit> listeProd = prodService.getAllProduits();

		return new ModelAndView("adminProdPage", "listeProduits", listeProd);
	}

	@RequestMapping(value = "/afficheAjoutProd", method = RequestMethod.GET)
	// M�thode du formulaire ajouter
	public ModelAndView afficheFormAjout() {

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

		// Appelle de la m�thode service
		Produit prodOut = prodService.addProduit(produit);

		if (prodOut.getId_produit() != 0) {
			// Actualiser la liste
			List<Produit> liste = prodService.getAllProduits();
			model.addAttribute("listeProduits", liste);

			return "adminProdPage";
		} else {
			return "redirect:afficheAjoutProd";
		}
	}
	
	@RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Produit produit) throws IOException {
		Produit	prod = prodService.getProduitById(produit);
		if (prod.getImageBytes() == null)
			return new byte[0];
		else
			return IOUtils
					.toByteArray(new ByteArrayInputStream(prod.getImageBytes()));
	}
}
