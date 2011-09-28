/**
 * 
 */
package fr.norsys.formation.locationvelos.metier.impl;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.metier.ILocationVeloMetier;
import fr.norsys.formation.locationvelos.service.IClientService;
import fr.norsys.formation.locationvelos.service.IVeloService;

/**
 * @author technomaker09
 *
 */
public class LocationVeloMetierImpl implements ILocationVeloMetier {
	private IVeloService serviceVelo;
	private IClientService serviceClient;
	public LocationVeloMetierImpl(IVeloService serviceVelo,
			IClientService serviceClient) {
		this.serviceClient = serviceClient;
		this.serviceVelo = serviceVelo;
	}
	public IVeloService getServiceVelo() {
		return serviceVelo;
	}
	public IClientService getServiceClient() {
		return serviceClient;
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.metier.ILocationVeloMetier#louerVeloAuClient(fr.norsys.formation.locationvelos.dto.DtoVelo, fr.norsys.formation.locationvelos.dto.DtoClient)
	 */
	public int louerVeloAuClient(DtoVelo dtoVelo, DtoClient dtoClient)
			throws SQLException {
		int retour = 0;
		if(1 == serviceClient.ajouterClient(dtoClient)){
			if(1 == serviceVelo.ajouterVelo(dtoVelo)){
				retour = 1;
			}
		}
		return retour;
	}

}
