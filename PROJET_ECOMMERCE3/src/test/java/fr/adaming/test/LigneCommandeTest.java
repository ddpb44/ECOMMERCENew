package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.ILigneCommandeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class LigneCommandeTest {

	// =========================Injection des
	// collaborateurs===============================//
	@Autowired
	private ILigneCommandeService ligneCommandeService;

	// Setter pour l'injection
	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	// =================================Test methode GetAllLigneCommande
	// ======================================//

	@Test
	@Rollback
	public void testGetAllLigneCommande() {
		
		System.out.println("-----------------tester la methode  GetAllLigneCommande");
		
		Client cl = new Client();
		cl.setId_client((long) 2);
		cl.setAdresse("rue du nuage");
		cl.setEmail("g@g");
		cl.setNomClient("loulou");
		cl.setTel("0125896347");
		cl.setMdpClient("g");
		
		
		List<LigneCommande> liste = ligneCommandeService.GetAllLigneCommande(cl);
		assertEquals(1, liste.size());

	}

	// =================================Test methode getLigneCommande
	// ======================================//
	
	@Test
	@Rollback
	public void testGetLigneCommande(){
		
	System.out.println("---------- Tester la méthode getLigneCommande");
	
	Client cl = new Client();
	cl.setEmail("g@g");
	
	List<LigneCommande> liste = ligneCommandeService.getLigneCommande(cl);
	assertEquals(2, liste.size());
}
	

	// =================================Test methode
	// addLigneCommandePanier======================================//

	@Test
	@Rollback
	public void testAddLigneCommande(){
		
		System.out.println("---------- Tester la méthode AddLigneCommande");
		
		Client cl = new Client();
		cl.setNomClient("doudou");
		
		Commande co = new Commande();
		co.setId_commande((long) 2);
		
		LigneCommande lc = new LigneCommande();
		lc.setPrix(12);
		
		List<LigneCommande> liste_in = ligneCommandeService.GetAllLigneCommande(cl);
		ligneCommandeService.addLigneCommandePanier(lc,co);
		assertEquals(liste_in.size() + 1, ligneCommandeService.GetAllLigneCommande(cl).size());

	}
	
	// =================================Test methode
	// deleteLigneCommandePanier======================================//


	@Test
	@Rollback
	public void testDeleteLigneCommandePanier(){
		
		System.out.println("---------- Tester la méthode deleteLigneCommandePanier");
		
		Client cl = new Client();
		cl.setNomClient("doudou");
		
		int tailleAvant = ligneCommandeService.GetAllLigneCommande(cl).size();
		LigneCommande lc= (LigneCommande) ligneCommandeService.getLigneCommande(cl);
		ligneCommandeService.deleteLigneCommandePanier(lc, cl);
		assertEquals(tailleAvant - 1, ligneCommandeService.GetAllLigneCommande(cl).size());
	
		
	}
	// =================================Test methode
	// updateLigneCommande======================================//


	@Test
	@Rollback
	public void testUpdateLigneCommande(){
		
		System.out.println("---------- Tester la méthode updateLigneCommande");
		
		Client cl = new Client();
		cl.setNomClient("doudou");
		
		int tailleAvant = ligneCommandeService.GetAllLigneCommande(cl).size();
		LigneCommande lc= (LigneCommande) ligneCommandeService.getLigneCommande(cl);
		ligneCommandeService.updateLigneCommande(lc, cl);
		assertEquals(tailleAvant, ligneCommandeService.GetAllLigneCommande(cl).size());
	
		
	}
}
