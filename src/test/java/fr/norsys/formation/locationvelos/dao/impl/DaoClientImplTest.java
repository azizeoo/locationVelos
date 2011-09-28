/**
 * 
 */
package fr.norsys.formation.locationvelos.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.util.ApplicationContext;

/**
 * @author technomaker09
 *
 */
/**
 *  -L'ordre des tests est important
 * 
 */
public class DaoClientImplTest {
	private IDaoClient dao;
	private Connection conn;
	@Before
	public void DaoClientImpl() throws Exception{
		conn = ApplicationContext.getConnexion();
		dao = new DaoClientImpl(conn);
	}
	/**
	 * - Soit l'objet DaoClientImpl, lorsqu'on l'initialise
	 * - Alors il sera diff�rent de null
	 */
	@Test
	public void initialiseDaoClientImplEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(dao);
	}
	
	/**
	 * - �tant donn� l'objet DaoClientImpl initialis� 
	 * - Lorsque on utilise le savoir faire +createClient avec comme param�tre ClientClient au code '111111111'
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireCreateClientPourEnregistreUnDtoClientAuCode111111111PourDtoClientExistant() throws Exception{
		assertEquals(1, dao.createClient(creerDtoClient()));
	}

	/**
	 * - �tant donn� l'objet DaoClientImpl initialis� 
	 * - Lorsque on utilise le savoir faire +updateClient avec comme param�tre DtoClient au code '111111111'
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireUpdateClientPourModifierUnDtoClientAuCode111111111() throws Exception{
		assertEquals(1, dao.updateClient(modifierDtoClientExistant()));
	}
	
	/**
	 * - �tant donn� l'objet DaoClientImpl initialis� 
	 * - Lorsque on utilise le savoir faire +selectClient avec comme param�tre '111111111'
	 * - Alors on obtient resultSet comme r�sultat
	 * - On utilisant le savoir faire +ApplicationContext.veloResultSetToList
	 * - On obtient une liste d'un seul �l�ment
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireSelectClientPourSelectionnerUnDtoClientAuCode111111111() throws Exception{
		assertNotNull(dao.selectClient("111111111"));
		assertEquals(1, dao.selectClient("111111111").size());
	}	
	/**
	 * - �tant donn� l'objet DaoClientImpl initialis� 
	 * - Lorsque on utilise le savoir faire +deleteClient avec comme param�tre '111111111'
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireDeleteClientPourSupprimerDtoClientAUCode111111111() throws Exception{
		assertEquals(1, dao.deleteClient("111111111"));
	}
	
	
	/**
	 * - M�thode interm�de pour cr�er un objet DtoClient
	 */
	private static DtoClient creerDtoClient(){
		DtoClient client = new DtoClient();
		
		String codeClient = "111111111";
		String nom = "nom test";
		String prenom = "pr�nom test";
		
		client.setCodeClient(codeClient);
		client.setNom(nom);
		client.setPrenom(prenom);
		
		return client;
	}
	/**
	 * - M�thode interm�de pour cr�er un objet DtoClient modifi�
	 */
	private static DtoClient modifierDtoClientExistant(){
		DtoClient client = new DtoClient();
		
		String codeClient = "111111111";
		String nom = "nom modif";
		String prenom = "pr�nom modif";
		
		client.setCodeClient(codeClient);
		client.setNom(nom);
		client.setPrenom(prenom);
		return client;
	}
}
