package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="admins")
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_admin;
	
	
	private String mail;
	
	
	private String mdp;
	
	private boolean actived;
	
	@OneToMany(mappedBy="admin")
	private List<Role> listeRole;

	public Admin() {
		super();
	}

	
	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Role> getListeRole() {
		return listeRole;
	}


	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}


	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", mail=" + mail + ", mdp=" + mdp + ", listeRole=" + listeRole + "]";
	}




	
	
	
	

}
