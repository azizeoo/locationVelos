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
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.util.ApplicationContext;

/**
 * @author technomaker09
 *
 */
public class DaoClientImplTest {
	private IDaoClient dao;
	private Connection conn;

	@Before
	public void DaoVeloImpl() throws Exception{
		conn = ApplicationContext.getConnexion();
		dao = new DaoClientImpl(conn);
	}
	/**
	 * - Soit l'objet DaoClientImpl, lorsqu'on l'initialise
	 * - Alors il sera diff�rent de null
	 */
	@Test
	public void initialiseDaoVeloImplEtVerifierQuIlNestPasNull() throws Exception  {
		assertNotNull(dao);
	}
	/**
	 * - �tant donn� l'objet DaoClientImpl initialis� 
	 * - Lorsque on utilise le savoir faire +createClient avec comme param�tre ClientVelo au code '111111111'
	 * - Alors on obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseDtoVeloImplEtUtilisationDeSavoirFaireCreateVeloPourEnregistreUnDtoVeloAuCode111111111PourDtoClientExistant() throws Exception{
		assertEquals(1, dao.createVelo(creerDtoClient()));
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
}
