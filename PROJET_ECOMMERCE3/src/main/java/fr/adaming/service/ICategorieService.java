package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {

	// TODO getCategorieByName
	public Categorie getCatByName(String name);

	// TODO getCategorieById
	public Categorie getCatById(int id);

	// TODO addCategorie
	public Categorie addCategorie(Categorie cat);

	// TODO deleteCategorie
	public Categorie deleteCategorie(Categorie cat);

	// TODO updateCategorie
	public Categorie updateCategorie(Categorie cat);

	// TODO getAllCategorie
	public List<Categorie> getAllCategorie();

}
