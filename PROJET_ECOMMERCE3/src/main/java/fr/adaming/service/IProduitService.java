package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitService {
	public List<Produit> getAllProduits();

	public Produit getProduitById(Produit produit);

	public Produit getProduitByDes(Produit produit);

	public Produit addProduit(Produit produit);

	public Produit updateProduit(Produit produit);

	public Produit deleteProduit(Produit produit);
}
