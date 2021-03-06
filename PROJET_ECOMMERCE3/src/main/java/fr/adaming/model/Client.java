package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	// Attributs

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_client;

	private String nomClient;

	private String adresse;

	private String email;

	private String tel;

	private String mdpClient;

	private boolean actived = false;

	@OneToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id_role")
	private Role role;

	// Association UML --> JAVA
	@OneToMany(mappedBy = "attClient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Commande> listeCommande;

	// Constructeur vide
	public Client() {
		super();
	}

	// Getters/Setters
	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	public String getMdpClient() {
		return mdpClient;
	}

	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	// M�thode toString()
	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email="
				+ email + ", tel=" + tel + ", mdpClient=" + mdpClient + ", listeCommande=" + listeCommande + "]";
	}

}
