package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class CategorieTest {

	// ==================== 1 =====================
	// Injection des collaborateurs
	// ============================================
	@Autowired
	private ICategorieService catService;

	// ==================== 2 =====================
	// Setter pour l'injection
	// ============================================
	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}

	// ==================== 3 =====================
	// Méthodes de test
	// ============================================

	/**
	 * To Test the method GetAllCategorieFirst (list size)
	 */
	// ============== TODO Test de getAllCategorie
	// Taille de la liste
	@Ignore
	@Test
	public void testGetAllCategorieTaille() {

		System.out.println("---------- Tester la méthode getAllCategorieTaille");
		List<Categorie> liste = catService.getAllCategorie();
		assertEquals(1, liste.size());

	}

	/**
	 * To Test the method GetAllCategorieFirst (firstElement)
	 */
	// Premier élément de la liste
	@Ignore
	@Test
	public void testGetAllCategorieFirst() {

		System.out.println("---------- Tester la méthode getAllCategorieFirst");
		assertEquals(new String("Bonnes Ondes"), catService.getAllCategorie().get(0).getNomCategorie());

	}

	/**
	 * To Test the method getCatByName
	 */
	// ============== TODO Test de gatCatByName
	// Tester la correspondance des noms et descriptions
	@Ignore
	@Test
	public void testGetCatByName() {

		System.out.println("---------- Tester la méthode getCatByName");
		assertEquals(new String("Happy"), catService.getCatByName("Bonnes Ondes").getDescription());

	}

	/**
	 * 
	 * To Test the method addCategorie comparing the size of the list after
	 * adding a Categorie
	 * 
	 */
	// ============== TODO Test de addCategorie
	// Tester la taille de la liste
	@Ignore
	@Test
	@Rollback
	public void testAddCategorieTaille() {
		System.out.println("---------- Tester la méthode addCategorieTaille");
		Categorie c1 = new Categorie();
		c1.setDescription("blabla");
		c1.setNomCategorie("jeparle");
		List<Categorie> liste_in = catService.getAllCategorie();
		catService.addCategorie(c1);
		assertEquals(liste_in.size() + 1, catService.getAllCategorie().size());

	}

	/**
	 * 
	 * To Test the method addCategorie comparing the description added to the
	 * description expected
	 * 
	 */
	// Tester la correspondance des noms et descriptions
	@Ignore
	@Test
	@Rollback
	public void testAddCategorieDescription() {
		System.out.println("---------- Tester la méthode addCategorieFirst");
		Categorie c1 = new Categorie();
		c1.setDescription("blabla");
		c1.setNomCategorie("jeparle");
		assertEquals(new String("blabla"), catService.addCategorie(c1).getDescription());

	}

	/**
	 * 
	 * To Test the method deleteCategorie comparing the size of the list after
	 * deleting a Categorie
	 * 
	 */
	// ============== TODO Test de deleteCategorieTaille
	// Tester la taille de la liste
	@Ignore
	@Test
	@Rollback
	public void testDeleteCategorieTaille() {
		System.out.println("---------- Tester la méthode deleteCategorieTaille");
		int tailleAvant = catService.getAllCategorie().size();
		Categorie cDel = catService.getCatByName("Ondes positives");
		catService.deleteCategorie(cDel);
		assertEquals(tailleAvant - 1, catService.getAllCategorie().size());
	}

	/**
	 * 
	 * To Test the method updateCategorie comparing the size of the list after
	 * updating the Categorie
	 * 
	 */
	// ============== TODO Test de updateCategorieTaille
	// Tester la taille de la liste
	@Ignore
	@Test
	@Rollback
	public void testUpdateCategorieTaille() {
		System.out.println("---------- Tester la méthode updateCategorieTaille");
		int tailleAvant = catService.getAllCategorie().size();
		Categorie cUp = catService.getCatByName("Ondes positives");
		catService.updateCategorie(cUp);
		assertEquals(tailleAvant, catService.getAllCategorie().size());
	}

	/**
	 * 
	 * To Test the method updateCategorie comparing the new name of the
	 * Categorie and the name expected
	 * 
	 */
	// Tester le nouveau nom de la Categorie
	@Ignore
	@Test
	@Rollback
	public void testUpdateCategorieNom() {
		System.out.println("---------- Tester la méthode testUpdateCategorieNom");
		Categorie cUp = catService.getCatByName("Ondes positives");
		cUp.setNomCategorie("Ondes très positives");
		assertEquals(new String("Ondes très positives"), catService.updateCategorie(cUp).getNomCategorie());

	}

}
