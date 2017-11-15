package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {

	// TODO getCategorieByName
	public Categorie getCatByName(String name);

	// TODO addCategorie
	public Categorie addCategorie(Categorie cat);

	// TODO deleteCategorie
	public Categorie deleteCategorie(Categorie cat);

	// TODO updateCategorie
	public Categorie updateCategorie(Categorie cat);

	// TODO getAllCategorie
	public List<Categorie> getAllCategorie();

}
