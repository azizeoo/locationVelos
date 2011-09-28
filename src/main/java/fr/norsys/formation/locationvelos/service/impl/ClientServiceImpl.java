/**
 * 
 */
package fr.norsys.formation.locationvelos.service.impl;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.service.IClientService;

/**
 * @author technomaker09
 *
 */
public class ClientServiceImpl implements IClientService {
	private IDaoClient dao;

	public ClientServiceImpl(IDaoClient dao) {
		this.dao = dao;
	}

	public IDaoClient getDao() {
		return dao;
	}
	/*
	 * (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.service.IClientService#ajouterClient(fr.norsys.formation.locationvelos.dto.DtoClient)
	 */
	public int ajouterClient(DtoClient client) throws SQLException {
		return dao.createClient(client);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.service.IClientService#modifierClient(fr.norsys.formation.locationvelos.dto.DtoClient)
	 */
	public int modifierClient(DtoClient client) throws SQLException {
		return dao.updateClient(client);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.service.IClientService#rechercherClient(java.lang.String)
	 */
	public DtoClient rechercherClient(String code) throws SQLException {
		return dao.selectClient(code).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.service.IClientService#supprimerVelo(java.lang.String)
	 */
	public int supprimerClient(String code) throws SQLException {
		return dao.deleteClient(code);
	}
}
