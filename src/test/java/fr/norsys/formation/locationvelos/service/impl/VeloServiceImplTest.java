/**
 * 
 */
package fr.norsys.formation.locationvelos.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.dao.IDaoVelo;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.service.IVeloService;

/**
 * @author technomaker09
 * 
 */
public class VeloServiceImplTest {
	private IVeloService service;
	private IDaoVelo dao;

	@Before
	public void initVeloServiceImpl() throws Exception {
		dao = mock(IDaoVelo.class,"dao");
		service = new VeloServiceImpl(dao);
	}

	/**
	 * - Soit l'objet VeloServiceImplTest, lorsqu'on l'initialise - Alors il
	 * sera différent de null
	 */
	@Test
	public void initialiseVeloServiceImplEtVerifierQuIlNestPasNull()
			throws Exception {
		assertNotNull(service);
	}

	/**
	 * - Etant donné l'objet VeloServiceImpl initialisé - Alors on va tester le
	 * savoir du VeloServiceImpl s'il est different de null
	 */
	@Test
	public void initialiseVeloServiceImplEtVerifierQueSonSavoirNestPasNull()
			throws Exception {
		assertNotNull(service.getDao());
	}

	/**
	 * - Etant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * savoir faire +ajouterVelo - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireAjouterVelo()
			throws Exception {
		DtoVelo dtoVelo = new DtoVelo();
		when(dao.createVelo(dtoVelo)).thenReturn(1);
		assertEquals(0, service.ajouterVelo(new DtoVelo()));
	}

	/**
	 * - Etant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * savoir faire +modifierVelo - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireModifierVelo()
			throws Exception {
		DtoVelo dtoVelo = new DtoVelo();
		when(dao.updateVelo(dtoVelo)).thenReturn(1);
		assertEquals(1, service.modifierVelo(dtoVelo));
	}
	
	/**
	 * - Etant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +rechercherVelo - On obtient dtoVelo comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireRechercherVelo()
			throws Exception {
		List<DtoVelo> list = new ArrayList<DtoVelo>();
		DtoVelo dtoVelo = new DtoVelo();
		list.add(dtoVelo);
		when(dao.selectVelo("")).thenReturn(list);
		assertEquals(dtoVelo, service.rechercherVelo(""));
	}
	
	/**
	 * - Etant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * savoir faire +supprimerVelo - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireSupprimerVelo()
			throws Exception {
		when(dao.deleteVelo("")).thenReturn(1);
		assertEquals(1, service.supprimerVelo(""));
	}
}
