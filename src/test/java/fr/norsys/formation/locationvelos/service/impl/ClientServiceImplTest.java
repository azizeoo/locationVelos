/**
 * 
 */
package fr.norsys.formation.locationvelos.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.service.IClientService;

/**
 * @author technomaker09
 *
 */
public class ClientServiceImplTest {
	private IClientService service;
	private IDaoClient dao;

	@Before
	public void initClientServiceImpl() throws Exception {
		dao = mock(IDaoClient.class,"dao");
		service = new ClientServiceImpl(dao);
	}
	
	/**
	 * - Soit l'objet ClientServiceImpl, lorsqu'on l'initialise - Alors il
	 * - sera diff�rent de null
	 */
	@Test
	public void initialiseClientServiceImplEtVerifierQuIlNestPasNull()
			throws Exception {
		assertNotNull(service);
	}
	
	/**
	 * - �tant donn� l'objet ClientServiceImpl initialis� - Alors on va tester le
	 * - savoir du ClientServiceImpl s'il est diff�rent de null
	 */
	@Test
	public void initialiseClientServiceImplEtVerifierQueSonSavoirNestPasNull()
			throws Exception {
		assertNotNull(service.getDao());
	}
	
	/**
	 * - �tant donn� l'objet clientServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +ajouterClient - On obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseClientServiceImplEtVerfieSavoirFaireAjouterClient()
			throws Exception {
		DtoClient dtoClient = new DtoClient();
		when(dao.createClient(dtoClient)).thenReturn(1);
		assertEquals(1, service.ajouterClient(dtoClient));
	}
	
	/**
	 * - �tant donn� l'objet ClientServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +modifierClient - On obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseClientServiceImplEtVerfieSavoirFaireModifierClient()
			throws Exception {
		DtoClient dtoClient = new DtoClient();
		when(dao.updateClient(dtoClient)).thenReturn(1);
		assertEquals(1, service.modifierClient(dtoClient));
	}
	/**
	 * - �tant donn� l'objet ClientServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +rechercherClient - On obtient dtoClient comme r�sultat
	 */
	@Test
	public void initialiseClientServiceImplEtVerfieSavoirFaireRechercherClient()
			throws Exception {
		//utilisation de spy et mock combin�
		List<DtoClient> list = new ArrayList<DtoClient>();
		List<DtoClient> spy = spy(list);
		DtoClient dtoClient = new DtoClient();
		spy.add(dtoClient);
		
		//personnaliser le comportement selectClient("")
		when(dao.selectClient("")).thenReturn(spy);
		
		//description JUnit
		assertEquals(1, dao.selectClient("").size());
		assertEquals(dtoClient, service.rechercherClient(""));
	}

	/**
	 * - �tant donn� l'objet ClientServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +supprimerClient - On obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseClientServiceImplEtVerfieSavoirFaireSupprimerClient()
			throws Exception {
		when(dao.deleteClient("")).thenReturn(1);
		assertEquals(1, service.supprimerClient(""));
	}
}
