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

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class ProduitTest {

	// ==================injection des collaborateurs
	@Autowired
	private IProduitService prodService;

	// setters pour l'injection
	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}

	// =================================Test methode
	// getAllProduits======================================//
	// test sur la taille de la liste
	@Ignore
	@Test
	@Rollback
	public void testGetAllProduitTaille() {

		System.out.println("---------- Tester la méthode GetAllProduitTaille");
		List<Produit> liste = prodService.getAllProduits();
		assertEquals(2, liste.size());

	}

	// Premier élément de la liste
	@Ignore
	@Test
	@Rollback
	public void testGetAllProduitFirst() {

		System.out.println("---------- Tester la méthode GetAllProduitFirst");
		assertEquals(new String("rouge, à avaler"), prodService.getAllProduits().get(0).getDesignation());

	}

	// ==========================================test methode
	// getProduitsById=================================//

	// tester la correspondances des noms et de l'identifiant
	@Ignore
	@Test
	@Rollback
	public void testGetProdById() {

		System.out.println("---------- Tester la méthode getProdById");
		Produit prod = new Produit();
		prod.setId_produit((long) 1);

		assertEquals(new String("gelule"), prodService.getProduitById(prod).getDescription());

	}

	// ============================================test methode
	// addProduit=============================================//

	// test sur la taille de la liste
	@Ignore
	@Test
	@Rollback
	public void testAddProd() {

		System.out.println("---------- Tester la méthode AddProd");

		Produit prod = new Produit();
		prod.setDescription("rouge");
		prod.setDescription("gelule");
		List<Produit> listeNew = prodService.getAllProduits();

		prodService.addProduit(prod);
		assertEquals(listeNew.size() + 1, prodService.getAllProduits().size());

	}

	// ============================================== test methode
	// updateProduit========================================//

	// test sur la correspondance des designations, descriptions, prix, quantite
	@Ignore
	@Test
	@Rollback
	public void testUpdateProd() {

		System.out.println("---------- Tester la méthode updateProd");

		Produit prod = new Produit();
		prod.setId_produit((long) 1);
		prod = prodService.getProduitById(prod);
		// modification du produit
		prod.setDesignation("sachet");

		// comparaison de la nouvelle liste avec l'ancienne
		assertEquals(new String("sachet"), prodService.updateProduit(prod).getDesignation());

	}

	// ============================test methode
	// deleteProduit=============================================//
	@Ignore
	@Test
	@Rollback
	public void testDeleteProd() {

		System.out.println("---------- Tester la méthode deletProd");

		Produit prod = new Produit();
		prod.setId_produit((long) 1);
		prod = prodService.getProduitById(prod);
		// recuperation de la liste avant suppression
		List<Produit> listeNew = prodService.getAllProduits();

		prodService.deleteProduit(prod);

		assertEquals(listeNew.size() - 1, prodService.getAllProduits().size());
	}

}
