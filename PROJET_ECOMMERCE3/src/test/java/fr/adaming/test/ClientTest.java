package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
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

	}

	// =================================Test methode
	// addClient======================================//

	// test sur la correspondance des noms
	
	@Ignore
	@Test
	@Rollback
	public void testAddClient() {
		
		System.out.println("--------tester la methode addClient");

		Client cl=new Client();
		cl.setNomClient("Anissa");
		assertEquals(new String("Anissa"), clientService.addClient(cl).getNomClient());

		
	}

	// =================================Test methode
	// updateClient======================================//
	
	@Ignore
	@Test
	@Rollback
	public void testUpdateClient() {

	}

	// =================================Test methode
	// deleteClient======================================//
	
	@Ignore
	@Test
	@Rollback
	public void testDeleteClient(){
		
		
	}
	
	
	
}