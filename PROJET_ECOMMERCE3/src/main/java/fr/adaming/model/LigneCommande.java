package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lignes_de_commande")
public class LigneCommande implements Serializable {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_lc;

	private int quantite;

	private double prix;
	
	@Transient
	private double prix2;

	@Column(name = "valide_lc")
	private String valide = "En attente";
	
	// Associations UML --> JAVA
	@ManyToOne
	@JoinColumn(name = "produit_id", referencedColumnName = "id_produit")
	private Produit attProduit;

	@ManyToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "id_commande")
	private Commande attCommande;


	// Constructeur vide
	public LigneCommande() {
		super();
	}

	// Getters/Setters
	public int getId_lc() {
		return id_lc;
	}

	public void setId_lc(int id_lc) {
		this.id_lc = id_lc;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Produit getAttProduit() {
		return attProduit;
	}

	public void setAttProduit(Produit attProduit) {
		this.attProduit = attProduit;
	}

	public Commande getAttCommande() {
		return attCommande;
	}

	public void setAttCommande(Commande attCommande) {
		this.attCommande = attCommande;
	}

	public double getPrix2() {
		return prix2;
	}

	public void setPrix2(double prix2) {
		this.prix2 = prix2;
	}

	
	public String getValide() {
		return valide;
	}

	public void setValide(String valide) {
		this.valide = valide;
	}

	@Override
	public String toString() {
		return "LigneCommande [id_lc=" + id_lc + ", quantite=" + quantite + ", prix=" + prix + ", prix2=" + prix2
				+ ", valide=" + valide + ", attProduit=" + attProduit + ", attCommande=" + attCommande + "]";
	}

	// Méthode toString()
	

}
