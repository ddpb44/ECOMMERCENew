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

	// ============== TODO Test de getAllCategorie
	// Taille de la liste
	//@Ignore
	@Test
	public void testGetAllCategorieTaille() {

		System.out.println("---------- Tester la méthode getAllCategorieTaille");
		List<Categorie> liste = catService.getAllCategorie();
		assertEquals(3, liste.size());

	}

	// Premier élément de la liste
	//@Ignore
	@Test
	public void testGetAllCategorieFirst() {

		System.out.println("---------- Tester la méthode getAllCategorieFirst");
		assertEquals(new String("Ondes positives"), catService.getAllCategorie().get(0).getNomCategorie());

	}
}
