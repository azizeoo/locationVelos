/**
 * 
 */
package fr.norsys.formation.locationvelos.metier;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.service.IClientService;
import fr.norsys.formation.locationvelos.service.IVeloService;

/**
 * @author technomaker09
 *
 */
public interface ILocationVeloMetier {
	public IVeloService getServiceVelo();
	public IClientService getServiceClient();
	/**
	 * 
	 * @param dtoVelo
	 * @param dtoClient
	 * @return
	 * @throws SQLException
	 */
	public int louerVeloAuClient(DtoVelo dtoVelo, DtoClient dtoClient) throws SQLException;
}
