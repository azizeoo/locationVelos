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
	 * - Alors il sera différent de null
	 */
	@Test
	public void initialiseDaoClientImplEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(dao);
	}
	
	/**
	 * - Étant donné l'objet DaoClientImpl initialisé 
	 * - Lorsque on utilise le savoir faire +createClient avec comme paramètre ClientClient au code '111111111'
	 * - Alors on obtient '1' comme résultat
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireCreateClientPourEnregistreUnDtoClientAuCode111111111PourDtoClientExistant() throws Exception{
		assertEquals(1, dao.createClient(creerDtoClient()));
	}

	/**
	 * - Étant donné l'objet DaoClientImpl initialisé 
	 * - Lorsque on utilise le savoir faire +updateClient avec comme paramètre DtoClient au code '111111111'
	 * - Alors on obtient '1' comme résultat
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireUpdateClientPourModifierUnDtoClientAuCode111111111() throws Exception{
		assertEquals(1, dao.updateClient(modifierDtoClientExistant()));
	}
	
	/**
	 * - Étant donné l'objet DaoClientImpl initialisé 
	 * - Lorsque on utilise le savoir faire +selectClient avec comme paramètre '111111111'
	 * - Alors on obtient resultSet comme résultat
	 * - On utilisant le savoir faire +ApplicationContext.veloResultSetToList
	 * - On obtient une liste d'un seul élément
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireSelectClientPourSelectionnerUnDtoClientAuCode111111111() throws Exception{
		assertNotNull(dao.selectClient("111111111"));
		assertEquals(1, dao.selectClient("111111111").size());
	}	
	/**
	 * - Étant donné l'objet DaoClientImpl initialisé 
	 * - Lorsque on utilise le savoir faire +deleteClient avec comme paramètre '111111111'
	 * - Alors on obtient '1' comme résultat
	 */
	@Test
	public void initialiseDtoClientImplEtUtilisationDeSavoirFaireDeleteClientPourSupprimerDtoClientAUCode111111111() throws Exception{
		assertEquals(1, dao.deleteClient("111111111"));
	}
	
	
	/**
	 * - Méthode intermède pour créer un objet DtoClient
	 */
	private static DtoClient creerDtoClient(){
		DtoClient client = new DtoClient();
		
		String codeClient = "111111111";
		String nom = "nom test";
		String prenom = "prénom test";
		
		client.setCodeClient(codeClient);
		client.setNom(nom);
		client.setPrenom(prenom);
		
		return client;
	}
	/**
	 * - Méthode intermède pour créer un objet DtoClient modifié
	 */
	private static DtoClient modifierDtoClientExistant(){
		DtoClient client = new DtoClient();
		
		String codeClient = "111111111";
		String nom = "nom modif";
		String prenom = "prénom modif";
		
		client.setCodeClient(codeClient);
		client.setNom(nom);
		client.setPrenom(prenom);
		return client;
	}
}
