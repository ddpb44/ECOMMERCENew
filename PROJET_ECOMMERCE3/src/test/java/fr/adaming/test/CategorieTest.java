package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.service.ICategorieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class CategorieTest {
	
	// ==================== 1 =====================
	// Injection des collaborateurs
	// ============================================
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
	@Ignore
	@Test
	public void testGetAllCategorieTaille() {

		System.out.println("---------- Tester la méthode getAllCategorieTaille");
		assertEquals(3, (catService.getAllCategorie().size()));

	}
	
	// Premier élément de la liste
	@Ignore
	@Test
	public void testGetAllCategorieFirst() {
		
		System.out.println("---------- Tester la méthode getAllCategorieFirst");
		assertEquals(new String("Ondes positivies"), catService.getAllCategorie().get(0).getNomCategorie());
		
	}

}
