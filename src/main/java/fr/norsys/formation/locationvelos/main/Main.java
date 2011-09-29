/**
 * 
 */
package fr.norsys.formation.locationvelos.main;

import java.sql.Connection;
import java.sql.SQLException;

import fr.norsys.formation.locationvelos.conf.IConfigurationDB;
import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dao.IDaoVelo;
import fr.norsys.formation.locationvelos.dao.impl.DaoClientImpl;
import fr.norsys.formation.locationvelos.dao.impl.DaoVeloImpl;
import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.metier.ILocationVeloMetier;
import fr.norsys.formation.locationvelos.metier.impl.LocationVeloMetierImpl;
import fr.norsys.formation.locationvelos.service.IClientService;
import fr.norsys.formation.locationvelos.service.IVeloService;
import fr.norsys.formation.locationvelos.service.impl.ClientServiceImpl;
import fr.norsys.formation.locationvelos.service.impl.VeloServiceImpl;
import fr.norsys.formation.locationvelos.util.ApplicationContext;

/**
 * @author technomaker09
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection conn;
		DtoClient dtoClient = new DtoClient();
		DtoVelo dtoVelo = new DtoVelo();
		
		dtoClient.setCodeClient(ApplicationContext.genCode());
		dtoClient.setNom("boussabat");
		dtoClient.setPrenom("abdelaziz");
		
		dtoVelo.setCodeVelo(ApplicationContext.genCode());
		dtoVelo.setMarque("VTT");
		dtoVelo.setPrix(2000);
		
		dtoVelo.setClient(dtoClient);
		try {
			conn = ApplicationContext.getConnexion(ApplicationContext.xmlToStrigDB(IConfigurationDB.BD_FILENAME));
			IDaoClient daoClient = new DaoClientImpl(conn);
			IDaoVelo daoVelo = new DaoVeloImpl(conn);
			
			IClientService serviceClient = new ClientServiceImpl(daoClient);
			IVeloService serviceVelo = new VeloServiceImpl(daoVelo);
			
			ILocationVeloMetier location = new LocationVeloMetierImpl(serviceVelo, serviceClient);
			if (1 == location.louerVeloAuClient(dtoVelo, dtoClient)) {
				System.out.println("Succès de l'opération");
			}else {
				System.out.println("Echéc de l'opération");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Echéc !!!");
		}
		

		
	}

}
