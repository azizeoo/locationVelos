/**
 * 
 */
package fr.norsys.formation.locationvelos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public class ApplicationContextTest {
	private Connection conn;
	private ApplicationContext app;
	
	@Before
	public void initConnexion() throws Exception{
		app = new ApplicationContext();
		conn = ApplicationContext.getConnexion();
	}
	/**
	 * - Soit l'objet conn, lorsqu'on l'initialise
	 * - Alors il sera différent de null
	 */
	@Test
	public void initialiseSavoirConnEtAppEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(app);
		assertNotNull(conn);
	}

	/**
	 * - Etant donné l'objet conn initialisé
	 * - Lorsqu'on utilise le savoir faire +genCode
	 * - On obient une chaine de caracteres de 10 caracteres
	 * 
	 */
	@Test
	public void initialiseConnVerifieSavoirFaireGenCode() throws Exception {
		String chaine = ApplicationContext.genCode();
		assertNotNull(chaine);
		assertEquals(10, chaine.length());
	}
	
	/**
	 * - Etant donné l'objet conn initialisé
	 * - Lorsqu'on utilise le savoir faire +veloResultSetToList avec le prametre 'null'
	 * - On obient une list vide des vélos size = 0
	 * 
	 */
	@Test
	public void initialiseConnVerifieSavoirFaireVeloResultSetToList() throws Exception {
		List<DtoVelo> list = ApplicationContext.veloResultSetToList(null);
		assertNotNull(list);
		assertEquals(0, list.size());
	}

}

