/**
 * 
 */
package fr.norsys.formation.locationvelos.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author technomaker09
 *
 */
public class DtoClientTest {
	private DtoClient client;
	
	@Before
	public void initClient() {
		client = new DtoClient();
	}
	
	/**
	 * - Soit l'objet DtoClient, lorsqu'on l'initialise
	 * - Alors il sera diff�rent de null
	 */
	@Test
	public void initialiseDtoClientEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(client);
	}
	
	/**
	 * - Etant donn� l'objet client initialis�
	 * - Lorsqu'on change le savoir -codeClient en 'codeTest' en utilisant le savoir faire +setCodeClient
	 * - Lorsqu'on utilise le savoir faire +getCodeClient on obtient 'codeTest'
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirCodeClientOnUtilisantSavoirFaireSetEtGet() throws Exception {
		client.setCodeClient("codeTest");
		assertEquals("codeTest",client.getCodeClient());
	}

	/**
	 * - Etant donn� l'objet client initialis�
	 * - Lorsqu'on change le savoir -nom en 'nomTest' en utilisant le savoir faire +setNom
	 * - Lorsqu'on utilise le savoir faire +getNom on obtient 'nomTest'
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirNomOnUtilisantSavoirFaireSetEtGet() throws Exception {
		client.setNom("nomTest");
		assertEquals("nomTest",client.getNom());
	}

	/**
	 * - Etant donn� l'objet client initialis�
	 * - Lorsqu'on change le savoir -prenom en 'prenomTest' en utilisant le savoir faire +setPrenom
	 * - Lorsqu'on utilise le savoir faire +getPrenom on obtient 'prenomTest'
	 * 
	 */
	@Test
	public void initialiseDtoVeloModifieEtVerifieSavoirPrenomOnUtilisantSavoirFaireSetEtGet() throws Exception {
		client.setPrenom("prenomTest");
		assertEquals("prenomTest",client.getPrenom());
	}

}
