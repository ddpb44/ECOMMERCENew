package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	// Injection automatique du sessionFactoryBean
	@Autowired
	private SessionFactory sf;

	// Setter pour l'injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// =========================les
	// methodes======================================================//

	/**
	 * This method recovers the client in the database
	 * 
	 * @return a client in the database
	 */
	@Override
	public Client isExist(Client cl) {

		// recuperation de la session
		Session s = sf.getCurrentSession();
		// La requete HQL
		String req = "FROM Client cl WHERE cl.email=:pEmail AND cl.mdpClient=:pMdp";

		// creation d'un objet query
		Query query = s.createQuery(req);

		// passage des parametres
		query.setParameter("pMail", cl.getEmail());
		query.setParameter("pMdp", cl.getMdpClient());

		// envoyer la requete et recuperation du resultat
		Client clOut = (Client) query.uniqueResult();

		return clOut;
	}

	/**
	 * Add a client to the existing list of client
	 * 
	 * @param client
	 * 
	 * @return The added client
	 */
	@Override
	public Client addClient(Client cl) {

		// recuperation de la session
		Session s = sf.getCurrentSession();

		s.save(cl);
		return cl;
	}

	/**
	 * Update a client and modify the list of client
	 * 
	 * @param client
	 * 
	 * @return The updated client
	 */
	@Override
	public Client updateClient(Client cl) {

		// recuperation de la session
		Session s = sf.getCurrentSession();

		Client clOut = (Client) s.get(Client.class, cl.getId_client());

		clOut.setNomClient(cl.getNomClient());
		clOut.setId_client(cl.getId_client());
		clOut.setEmail(cl.getEmail());
		clOut.setMdpClient(cl.getMdpClient());
		clOut.setTel(cl.getTel());

		s.saveOrUpdate(clOut);

		return clOut;
	}

	/**
	 * Delete a client from the existing list of client
	 * 
	 * @param client
	 * 
	 * @return The deleted client
	 */
	@Override
	public int deleteClient(Client cl) {

		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete HQL
		String req = "DELETE Client cl WHERE cl.id=:pIdcl";

		// creation d'un objet query
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pIdcl", cl.getId_client());

		// execution du query
		int verif = query.executeUpdate();

		return verif;
	}

	/**
	 * Get a client from the existing list of client by his name
	 * 
	 * @param name
	 * 
	 * @return The client searched
	 */
	@Override
	public Client getClientByName(String name) {

		// Recuperation de la session
		Session s = sf.getCurrentSession();

		// Le requete HQL
		String req = "FROM Client cl WHERE cl.nomClient=:pNom";

		// Creer un objet query
		Query query = s.createQuery(req);

		// Passage du param
		query.setParameter("pNom", name);

		Client clOut = (Client) query.uniqueResult();

		return clOut;
	}

	@Override
	public List<Client> getAllClients() {

		// Recuperation de la session
		Session s = sf.getCurrentSession();

		// Le requete HQL
		String req = "FROM Client cl";

		// Creer un objet query
		Query query = s.createQuery(req);

		List<Client> listeClient = query.list();

		return listeClient;
	}

}
