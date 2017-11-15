package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class ProduitTest {

	// ==================injection des collaborateurs
	private IProduitService prodService;

	// setters pour l'injection
	public void setProdService(IProduitService prodService) {
		this.prodService = prodService;
	}

	// =================================Test methode
	// getAllProduits======================================//
	// test sur la taille de la liste
	@Test
	@Rollback
	public void testGetAllProduitTaille() {

		System.out.println("---------- Tester la méthode GetAllProduitTaille");
		List<Produit> liste = prodService.getAllProduits();
		assertEquals(1, liste.size());

	}

	// Premier élément de la liste

	@Test
	@Rollback
	public void testGetAllProduitFirst() {

		System.out.println("---------- Tester la méthode GetAllProduitFirst");
		assertEquals(new String("se dissout dans l'eau"), prodService.getAllProduits().get(0).getDesignation());

	}

	// Tester la correspondance des noms et descriptions

	@Test
	@Rollback
	public void testGetProdByDes() {

		System.out.println("---------- Tester la méthode getProdByDes");
		assertEquals(new String("Cachet"), prodService.getProdByDes("se dissout dans l'eau").getDesignation());

	}

	// ==========================================test methode
	// getProduitsById=================================//

	// tester la correspondances des noms et de l'identifiant
	@Test
	@Rollback
	public void testGetProdById() {

		System.out.println("---------- Tester la méthode getProdById");
		Produit prod = new Produit();
		assertEquals(new String("Cachet"), prodService.getProduitById(prod).getId_produit());

	}

	// ============================================test methode
	// addProduit=============================================//

	// test sur la taille de la liste
	@Test
	@Rollback
	public void testAddProd() {

		System.out.println("---------- Tester la méthode AddProd");

		Produit prod = new Produit();
		List<Produit> listeNew = prodService.getAllProduits();

		prodService.addProduit(prod);
		assertEquals(listeNew.size() + 1, prodService.getAllProduits().size());

	}

	// ============================================== test methode
	// updateProduit========================================//

	// test sur la correspondance des designations, descriptions, prix, quantite
	@Test
	@Rollback
	public void testUpdateProd() {

		System.out.println("---------- Tester la méthode updateProd");

		Produit prod = new Produit();

		// modification du produit
		prod.setDesignation("gelule");
		prod.setDescription("a avaler");
		
		// comparaison de la nouvelle liste avec l'ancienne
		assertEquals(new String ("gelule"), prodService.updateProduit(prod).getDesignation());
		assertEquals(new String ("a avaler"), prodService.updateProduit(prod).getDescription());
		
	}

	// ============================test methode
	// deleteProduit=============================================//

	@Test
	@Rollback
	public void testDeleteProd() {

		System.out.println("---------- Tester la méthode deletProd");

		Produit prod = new Produit();
		List<Produit> listeNew = prodService.getAllProduits();
		
		prodService.deleteProduit(prod);
		
		assertEquals(listeNew.size() - 1, prodService.getAllProduits().size());
	}

}
