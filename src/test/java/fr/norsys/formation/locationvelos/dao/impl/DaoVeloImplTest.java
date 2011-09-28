/**
 * 
 */
package fr.norsys.formation.locationvelos.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.conf.IConfigurationDB;
import fr.norsys.formation.locationvelos.dao.IDaoVelo;
import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.util.ApplicationContext;

/**
 * @author technomaker09
 *
 */
public class DaoVeloImplTest{
	private IDaoVelo dao;
	private Connection conn;
	
	@Before
	public void DaoVeloImpl() throws Exception{
		conn = ApplicationContext.getConnexion(IConfigurationDB.INFO_DB);
		dao = new DaoVeloImpl(conn);
	}
	
	/**
	 * - Soit l'objet DaoVeloImpl, lorsqu'on l'initialise
	 * - Alors il sera diff�rent de null
	 */
	@Test
	public void initialiseDaoVeloImplEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(dao);
	}
	
	/**
	 * - �tant donn� l'objet DaoVeloImpl initialis� 
	 * - Lorsque on utilise le savoir faire +createVelo avec comme param�tre DtoVelo au code '111111111'
	 * - DtoVelo utilise un DtoClient existant
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoVeloImplEtUtilisationDeSavoirFaireCreateVeloPourEnregistreUnDtoVeloAuCode111111111PourDtoClientExistant() throws Exception{
		assertEquals(1, dao.createVelo(creerDtoVeloAvecDtoClientExistant()));
	}

	/**
	 * - �tant donn� l'objet DaoVeloImpl initialis� 
	 * - Lorsque on utilise le savoir faire +updateVelo avec comme param�tre DtoVelo au code '111111111'
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoVeloImplEtUtilisationDeSavoirFaireUpdateVeloPourModifierUnDtoVeloExistantAuCode111111111() throws Exception{
		assertEquals(1, dao.updateVelo(modifierDtoVeloExistant()));
	}
	
	/**
	 * - �tant donn� l'objet DaoVeloImpl initialis� 
	 * - Lorsque on utilise le savoir faire +selectVelo avec comme param�tre '111111111'
	 * - Alors on obtient resultSet comme r�sultat
	 * - On utilisant le savoir faire +ApplicationContext.veloResultSetToList
	 * - On obtient une liste d'un seul �l�ment
	 */
	@Test
	public void initialiseDtoVeloImplEtUtilisationDeSavoirFaireSelectVeloPourSelectionnerUnDtoVeloAuCode111111111() throws Exception{
		assertNotNull(dao.selectVelo("111111111"));
		assertEquals(1, dao.selectVelo("111111111").size());
	}
	
	/**
	 * - �tant donn� l'objet DaoVeloImpl initialis� 
	 * - Lorsque on utilise le savoir faire +deleteVelo avec comme param�tre '111111111'
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoVeloImplEtUtilisationDeSavoirFaireDeleteVeloPourSupprimerDtoVeloAUCode111111111() throws Exception{
		assertEquals(1, dao.deleteVelo("111111111"));
	}
	/**
	 * - M�thode interm�de pour cr�er un objet DtoVelo
	 */
	private static DtoVelo creerDtoVeloAvecDtoClientExistant(){
		DtoVelo velo = new DtoVelo();
		DtoClient client = new DtoClient();
		
		String codeVelo = "111111111";
		String marque = "marque 1";
		double prix = 5000;
		String codeClient = "99999";
		
		client.setCodeClient(codeClient);
		velo.setCodeVelo(codeVelo);
		velo.setMarque(marque);
		velo.setPrix(prix);
		velo.setClient(client);
		
		return velo;
	}
	
	/**
	 * - M�thode interm�de pour cr�er un objet DtoVelo modifi�
	 */
	private static DtoVelo modifierDtoVeloExistant(){
		DtoVelo velo = new DtoVelo();
		DtoClient client = new DtoClient();
		
		String codeVelo = "111111111";
		String marque = "marque 1 mod";
		double prix = 9000;
		String codeClient = "99999";
		
		client.setCodeClient(codeClient);
		velo.setCodeVelo(codeVelo);
		velo.setMarque(marque);
		velo.setPrix(prix);
		velo.setClient(client);	
		return velo;
	}
}

