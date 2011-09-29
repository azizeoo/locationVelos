/**
 * 
 */
package fr.norsys.formation.locationvelos.util;

import static fr.norsys.formation.locationvelos.util.ApplicationContext.clientResultSetToList;
import static fr.norsys.formation.locationvelos.util.ApplicationContext.genCode;
import static fr.norsys.formation.locationvelos.util.ApplicationContext.getConnexion;
import static fr.norsys.formation.locationvelos.util.ApplicationContext.veloResultSetToList;
import static fr.norsys.formation.locationvelos.util.ApplicationContext.xmlToStrigDB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.conf.IConfigurationDB;
import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public class ApplicationContextTest {
	private Connection conn = null;
	
	@Before
	public void initConnexion() throws Exception{
		conn = getConnexion(xmlToStrigDB(IConfigurationDB.BD_FILENAME));
	}
	/**
	 * - Soit l'objet conn, lorsqu'on l'initialise
	 * - Alors il sera diff�rent de null
	 */
	@Test
	public void initialiseSavoirConnEtAppEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(conn);
	}

	/**
	 * - �tant donn� l'objet conn initialis�
	 * - Lorsqu'on utilise le savoir faire +genCode
	 * - On obtient une cha�ne de caract�res de 10 caract�res
	 * 
	 */
	@Test
	public void initialiseConnVerifieSavoirFaireGenCode() throws Exception {
		String chaine = genCode();
		assertNotNull(chaine);
		assertEquals(10, chaine.length());
	}
	
	/**
	 * - �tant donn� l'objet conn initialis�
	 * - Lorsqu'on utilise le savoir faire +veloResultSetToList avec le param�tre 'null'
	 * - On obtient une liste vide des v�los size = 0
	 * 
	 */
	@Test
	public void initialiseConnVerifieSavoirFaireVeloResultSetToList() throws Exception {
		List<DtoVelo> list = veloResultSetToList(null);
		assertNotNull(list);
		assertEquals(0, list.size());
	}
	/**
	 * - �tant donn� l'objet conn initialis�
	 * - Lorsqu'on utilise le savoir faire +clientResultSetToList avec le param�tre 'null'
	 * - On obtient une liste vide des v�los size = 0
	 * 
	 */
	@Test
	public void initialiseConnVerifieSavoirFaireClientResultSetToList() throws Exception {
		List<DtoClient> list = clientResultSetToList(null);
		assertNotNull(list);
		assertEquals(0, list.size());
	}
	/**
	 * - �tant donn� l'objet conn initialis�
	 * - Lorsqu'on utilise le savoir faire +clientResultSetToList avec le param�tre 'null'
	 * - On obtient une liste vide des v�los size = 0
	 * 
	 */
	@Test
	public void initialiseConnVerifieSavoirFairexmlToStrigDB() throws Exception {
		String[] info = xmlToStrigDB(IConfigurationDB.BD_FILENAME);
		assertNotNull(info);
		assertEquals(3, info.length);
	}
}

