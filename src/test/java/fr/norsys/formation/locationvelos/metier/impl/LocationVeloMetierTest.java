/**
 * 
 */
package fr.norsys.formation.locationvelos.metier.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.metier.ILocationVeloMetier;
import fr.norsys.formation.locationvelos.service.IClientService;
import fr.norsys.formation.locationvelos.service.IVeloService;

/**
 * @author technomaker09
 *
 */
public class LocationVeloMetierTest {
	private ILocationVeloMetier metier;
	private IVeloService serviceVelo;
	private IClientService serviceClient;
	@Before
	public void LocationVeloMetierImpl() throws Exception {
		serviceVelo = mock(IVeloService.class,"serviceVelo");
		serviceClient = mock(IClientService.class,"serviceClient");
		metier = new LocationVeloMetierImpl(serviceVelo,serviceClient);
	}
	/**
	 * - Soit l'objet LocationVeloMetierImpl, lorsqu'on l'initialise - Alors il
	 * - sera différent de null
	 */
	@Test
	public void initialiseLocationVeloMetierImplEtVerifierQuIlNestPasNull()
			throws Exception {
		assertNotNull(metier);
	}

	/**
	 * - Étant donné l'objet LocationVeloMetierImpl initialisé - Alors on va tester les
	 * - savoirs du LocationVeloMetierImpl s'ils sont est différents de null
	 */
	@Test
	public void initialiseLocationVeloMetierImplEtVerifierQueSesSavoirSontPasNulls()
			throws Exception {
		assertNotNull(metier.getServiceClient());
		assertNotNull(metier.getServiceVelo());
	}
	
	/**
	 * - Étant donné l'objet LocationVeloMetierImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +louerVeloAuClient - On obtient '1' comme résultat
	 */
	@Test
	public void initialiseLocationVeloMetierImplEtVerfieSavoirFaireLouerVeloAuClient()
			throws Exception {
		DtoClient dtoClient = new DtoClient();
		DtoVelo dtoVelo = new DtoVelo();
		when(serviceClient.ajouterClient(dtoClient)).thenReturn(1);
		when(serviceVelo.ajouterVelo(dtoVelo)).thenReturn(1);
		assertEquals(1, metier.louerVeloAuClient(dtoVelo,dtoClient));
	}
	/**
	 * - Étant donné l'objet LocationVeloMetierImpl initialisé - Lorsqu'on utilise le
	 * - savoir faire +louerVeloAuClient - quand le client n'existe pas
	 * On obtient '0' comme résultat
	 */
	@Test
	public void initialiseLocationVeloMetierImplEtVerfieSavoirFaireLouerVeloAuClientNoExistant()
			throws Exception {
		DtoClient dtoClient = new DtoClient();
		DtoVelo dtoVelo = new DtoVelo();
		when(serviceClient.ajouterClient(dtoClient)).thenReturn(0);
		when(serviceVelo.ajouterVelo(dtoVelo)).thenReturn(1);
		assertEquals(0, metier.louerVeloAuClient(dtoVelo,dtoClient));
	}
}
