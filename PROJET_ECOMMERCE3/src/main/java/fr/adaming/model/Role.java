package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_role;

	private String nom;

	@ManyToOne
	@JoinColumn(name = "admin_id", referencedColumnName = "id_admin")
	private Admin admin;

	@OneToOne(mappedBy = "role")
	private Client client;

}
