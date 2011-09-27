/**
 *
 */
package fr.norsys.formation.locationvelos.service.impl;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dao.IDaoVelo;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.service.IVeloService;

/**
 * @author technomaker09
 * 
 */
public class VeloServiceImpl implements IVeloService {
	private IDaoVelo dao;

	public VeloServiceImpl(IDaoVelo dao) {
		this.dao = dao;
	}

	public IDaoVelo getDao() {
		return dao;
	}

	public int ajouterVelo(DtoVelo v) throws SQLException {
		return dao.createVelo(v);
	}

	public int modifierVelo(DtoVelo v) throws SQLException{
		return dao.updateVelo(v);
	}

	public DtoVelo rechercherVelo(String code) throws SQLException {
		return dao.selectVelo(code).get(0);
	}

	public int supprimerVelo(String code) throws SQLException {
		return dao.deleteVelo(code);
	}
}