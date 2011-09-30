/**
 * 
 */
package fr.norsys.formation.locationvelos.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.dto.DtoClient;

/**
 * @author technomaker09
 *
 */
public class MainTest {
	private Main main;
	
	@Before
	public void initMain() throws Exception{
		main = new Main();
	}
	/**
	 * - Soit l'objet main, lorsqu'on l'initialise
	 * - Alors il sera différent de null
	 */
	@Test
	public void initialiseMainEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(main);
	}
	
	/**
	 * - Étant donné l'objet main initialisé
	 * - Lorsqu'on utilise le savoir faire +creeClient
	 * - On obtient un retour non null
	 * 
	 */
	@Test
	public void initialiseMainVerifieSavoirFaireCreeClient() throws Exception {
		assertNotNull(Main.creerClient());
	}
	/**
	 * - Étant donné l'objet main initialisé
	 * - Lorsqu'on utilise le savoir faire +creeVelo
	 * - On obtient un retour non null
	 * 
	 */
	@Test
	public void initialiseMainVerifieSavoirFaireCreeVelo() throws Exception {
		assertNotNull(Main.creerVelo(new DtoClient()));
	}
	/**
	 * - Étant donné l'objet main initialisé
	 * - Lorsqu'on utilise le savoir faire +traitement
	 * - On obtient un retour true
	 * 
	 */
	@Test
	public void initialiseMainVerifieSavoirFaireTraitement() throws Exception {
		assertTrue(Main.traitement());
	}
}
