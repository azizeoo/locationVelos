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
	 * - sera diff�rent de null
	 */
	@Test
	public void initialiseVeloServiceImplEtVerifierQuIlNestPasNull()
			throws Exception {
		assertNotNull(service);
	}

	/**
	 * - �tant donn� l'objet VeloServiceImpl initialis� - Alors on va tester le
	 * - savoir du VeloServiceImpl s'il est diff�rent de null
	 */
	@Test
	public void initialiseVeloServiceImplEtVerifierQueSonSavoirNestPasNull()
			throws Exception {
		assertNotNull(service.getDao());
	}

	/**
	 * - �tant donn� l'objet VeloServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +ajouterVelo - On obtient '1' comme r�sultat
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
	 * - �tant donn� l'objet VeloServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +modifierVelo - On obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireModifierVelo()
			throws Exception {
		DtoVelo dtoVelo = new DtoVelo();
		when(dao.updateVelo(dtoVelo)).thenReturn(1);
		assertEquals(1, service.modifierVelo(dtoVelo));
	}
	
	/**
	 * - �tant donn� l'objet VeloServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +rechercherVelo - On obtient dtoVelo comme r�sultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireRechercherVelo()
			throws Exception {
		//utilisation de spy et mock combin�
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
		
		//on v�rifie que la m�thode selectVelo() est appel�e deux fois exactement
		verify(dao,times(2)).selectVelo("");
		
		//on v�rifie que la m�thode size() est appel�e une et une seul fois
		verify(spy,times(1)).size();
		
		//on v�rifie que la m�thode size() est appel�e une fois ou plus (1,+)
		verify(spy,atLeastOnce()).size();
		
		//on v�rifie que la m�thode size() est appel�e une fois ou moins (1,+)
		verify(spy,atLeast(1)).size();
		
		//on v�rifie que la m�thode size() est appel�e une fois ou plus (0,1)
		verify(spy,atMost(1)).size();
		
		//on v�rifie si jamais la m�thode remove() est appel�e
		verify(spy,never()).remove(1);
		
		//on v�rifie l'ordre (un seul objet)des m�thodes size() et add() -- add() puis size()--
		InOrder inOrder = inOrder(spy);
		
		inOrder.verify(spy).add(dtoVelo);
		inOrder.verify(spy).size();
		
		//on v�rifie l'ordre (2 objets) des m�thodes spy.get(1) et dao.selectVelo("") -- spy.get(1) puis dao.selectVelo("")--
		InOrder inOrder2 = inOrder(spy,dao);
		inOrder2.verify(spy).get(1);
		inOrder2.verify(dao).selectVelo("");
	}
	
	/**
	 * - �tant donn� l'objet VeloServiceImpl initialis� - Lorsqu'on utilise le
	 * - savoir faire +supprimerVelo - On obtient '1' comme r�sultat
	 */
	@Test
	public void initialiseVeloServiceImplEtVerfieSavoirFaireSupprimerVelo()
			throws Exception {
		when(dao.deleteVelo("1")).thenReturn(1,0);
		assertEquals(1, service.supprimerVelo("1"));
		assertEquals(0, service.supprimerVelo("1"));
	}
}
