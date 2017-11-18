package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class ClientTest {

	// ==================injection des collaborateurs========================//
	@Autowired
	private IClientService clientService;

	// setters pour l'injection
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	// =================================Test methode
	// isExist======================================//

	@Ignore
	@Test
	@Rollback
	public void testIsExistClient() {

		System.out.println("---------- Tester la méthode GetClientByName");
		
		Client cl=new Client();
		cl.setEmail("c@c");
		List<Client> liste=clientService.getAllClients();
		clientService.isExist(cl);
		assertEquals(liste.size(), clientService.getAllClients().size());


	}

	// =================================Test methode
	// getAllClients======================================//
	@Ignore
	@Test
	@Rollback
	public void testGetAllClients(){
		
	System.out.println("---------- Tester la méthode getAllClients");
	assertEquals(new String("chouchou"), clientService.getAllClients().get(0).getNomClient());
	}

	// =================================Test methode
	// getClientByName======================================//

	
	public void testGetClientByName(){
		
		System.out.println("---------- Tester la méthode GetClientByName");
		assertEquals(new String("d@d"), clientService.getClientByName("c@c").getEmail());

	}
	// =================================Test methode
	// addClient======================================//

	// test sur la correspondance des noms

	@Ignore
	@Test
	@Rollback
	public void testAddClient() {

		System.out.println("--------tester la methode addClient");

		Client cl = new Client();
		cl.setNomClient("Anissa");
		assertEquals(new String("Anissa"), clientService.addClient(cl).getNomClient());

	}

	// =================================Test methode
	// updateClient======================================//

	@Ignore
	@Test
	@Rollback
	public void testUpdateClientNom() {

		System.out.println("---------- Tester la méthode testUpdateClient");
		Client cl = clientService.getClientByName("chouchou");
		cl.setNomClient("nounours");
		assertEquals(new String("nounours"), clientService.updateClient(cl).getNomClient());

	}

	// =================================Test methode
	// deleteClient======================================//

	@Ignore
	@Test
	@Rollback
	public void testDeleteClientTaille() {

		System.out.println("---------- Tester la méthode deleteClientTaille");

		int listOld = clientService.getAllClients().size();
		Client cl = clientService.getClientByName("chouchou");
		clientService.deleteClient(cl);

		assertEquals(listOld - 1, clientService.getAllClients().size());

	}

}