/**
 * 
 */
package fr.norsys.formation.locationvelos.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author technomaker09
 *
 */
public class DtoVeloTest {
	private DtoVelo velo;
	
	@Before
	public void initVelo() {
		velo = new DtoVelo();
	}

	/**
	 * - Soit l'objet DtoVelo, lorsqu'on l'initialise
	 * - Alors il sera différent de null
	 */
	@Test
	public void initialiseDtoVeloEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(velo);
	}
	
	/**
	 * - Etant donné l'objet vélo initialisé
	 * - Lorsqu'on change le savoir -codeVelo en 'codeTest' en utilisant le savoir faire +setCodeVelo
	 * - Lorsqu'on utilise le savoir faire +getCodeVelo on obtient 'codeTest'
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirCodeVeloOnUtilisantSavoirFaireSetEtGet() throws Exception {
		velo.setCodeVelo("codeTest");
		assertEquals("codeTest",velo.getCodeVelo());
	}
	
	/**
	 * - Etant donné l'objet vélo initialisé
	 * - Lorsqu'on change le savoir -marque en 'marqueTest' en utilisant le savoir faire +setMarque
	 * - Lorsqu'on utilise le savoir faire +getMarque on obtient 'marqueTest'
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirPrixOnUtilisantSavoirFaireSetEtGet() throws Exception {
		velo.setPrix(9999);
		assertTrue(9999 == velo.getPrix());
	}
	
	/**
	 * - Etant donné l'objet vélo initialisé
	 * - Lorsqu'on change le savoir -prix en 9999 en utilisant le savoir faire +setPrix
	 * - Lorsqu'on utilise le savoir faire +getPrixon obtient 9999
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirMarqueOnUtilisantSavoirFaireSetEtGet() throws Exception {
		velo.setMarque("marqueTest");
		assertEquals("marqueTest",velo.getMarque());
	}
	
	/**
	 * - Etant donné l'objet vélo initialisé
	 * - Lorsqu'on change le savoir -client en 'marqueTest' en utilisant le savoir faire +setMarque
	 * - Lorsqu'on utilise le savoir faire +getMarque on obtient 'marqueTest'
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirClientOnUtilisantSavoirFaireSetEtGet() throws Exception {
		DtoClient client = new DtoClient();
		velo.setClient(client);
		assertEquals(client,velo.getClient());
	}	

}
