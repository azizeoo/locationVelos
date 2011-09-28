/**
 * 
 */
package fr.norsys.formation.locationvelos.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

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
	 * - sera différent de null
	 */
	@Test
	public void initialiseVeloServiceImplEtVerifierQuIlNestPasNull()
			throws Exception {
		assertNotNull(service);
	}

	/**
	 * - Étant donné l'objet VeloServiceImpl initialisé - Alors on va tester le
	 * - savoir du VeloServiceImpl s'il est différent de null
	 */
	@Test
	public void initialiseVeloServiceImplEtVerifierQueSonSavoirNestPasNull()
			throws Exception {
		assertNotNull(service.getDao());
	}

	/**
	 * - Étant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +ajouterVelo - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireAjouterVelo()
			throws Exception {
		DtoVelo dtoVelo = new DtoVelo();
		when(dao.createVelo(dtoVelo)).thenReturn(1);
		when(dao.createVelo(dtoVelo)).thenThrow(new SQLException());
		try{
			assertEquals(1, service.ajouterVelo(dtoVelo));
			fail();
		}catch (SQLException e) {
			assertTrue("2eme appel",true);
		}	
	}

	/**
	 * - Étant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +modifierVelo - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireModifierVelo()
			throws Exception {
		DtoVelo dtoVelo = new DtoVelo();
		when(dao.updateVelo(dtoVelo)).thenReturn(1);
		assertEquals(1, service.modifierVelo(dtoVelo));
	}
	
	/**
	 * - Étant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +rechercherVelo - On obtient dtoVelo comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireRechercherVelo()
			throws Exception {
		//utilisation de spy et mock combiné
		List<DtoVelo> list = new ArrayList<DtoVelo>();
		List<DtoVelo> spy = spy(list);
		DtoVelo dtoVelo = new DtoVelo();
		spy.add(dtoVelo);
		
		//personnaliser le comportement selectVelo("")
		when(dao.selectVelo("")).thenReturn(spy);
		
		//personnaliser le comportement size()
		when(spy.size()).thenReturn(100);
		
		//personnaliser le comportement get(1)
		doReturn("test").when(spy).get(1);
		
		//description JUnit
		assertEquals("test", spy.get(1));
		assertEquals(100, dao.selectVelo("").size());
		assertEquals(dtoVelo, service.rechercherVelo(""));
		
		//on vérifie que la méthode selectVelo() est appelée deux fois exactement
		verify(dao,times(2)).selectVelo("");
		
		//on vérifie que la méthode size() est appelée une et une seul fois
		verify(spy,times(1)).size();
		
		//on vérifie que la méthode size() est appelée une fois ou plus (1,+)
		verify(spy,atLeastOnce()).size();
		
		//on vérifie que la méthode size() est appelée une fois ou moins (1,+)
		verify(spy,atLeast(1)).size();
		
		//on vérifie que la méthode size() est appelée une fois ou plus (0,1)
		verify(spy,atMost(1)).size();
		
		//on vérifie si jamais la méthode remove() est appelée
		verify(spy,never()).remove(1);
		
		//on vérifie l'ordre (un seul objet)des méthodes size() et add() -- add() puis size()--
		InOrder inOrder = inOrder(spy);
		
		inOrder.verify(spy).add(dtoVelo);
		inOrder.verify(spy).size();
		
		//on vérifie l'ordre (2 objets) des méthodes spy.get(1) et dao.selectVelo("") -- spy.get(1) puis dao.selectVelo("")--
		InOrder inOrder2 = inOrder(spy,dao);
		inOrder2.verify(spy).get(1);
		inOrder2.verify(dao).selectVelo("");
	}
	
	/**
	 * - Étant donné l'objet VeloServiceImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +supprimerVelo - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireSupprimerVelo()
			throws Exception {
		when(dao.deleteVelo("1")).thenReturn(1,0);
		assertEquals(1, service.supprimerVelo("1"));
		assertEquals(0, service.supprimerVelo("1"));
	}
}
