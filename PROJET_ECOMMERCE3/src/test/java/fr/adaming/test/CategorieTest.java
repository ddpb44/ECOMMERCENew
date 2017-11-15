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

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
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
	 * To Test the method GetAllCategorieFirst (taille de la liste)
	 */
	// ============== TODO Test de getAllCategorie
	// Taille de la liste
	//@Ignore
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
	//@Ignore
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
	//@Ignore
	@Test
	public void testGetCatByName(){
		
		System.out.println("---------- Tester la méthode getCatByName");
		assertEquals(new String("Happy"), catService.getCatByName("Bonnes Ondes").getDescription());
		
	}
	
	/**
	 * 
	 * To Test the method addCategorie comparing the size of the list after using the method and before +1
	 * 
	 */
	// ============== TODO Test de addCategorie
	// Tester la correspondance des noms et descriptions
	@Test
	@Rollback
	public void testaddCategorie(){
		System.out.println("---------- Tester la méthode getCatByName");
		Categorie c1 = new Categorie();
		c1.setDescription("blabla");
		c1.setNomCategorie("jeparle");
		List<Categorie> liste_in = catService.getAllCategorie();
		catService.addCategorie(c1);
		assertEquals(catService.getAllCategorie().size(), liste_in.size()+1);
		
	}
	
	
}
