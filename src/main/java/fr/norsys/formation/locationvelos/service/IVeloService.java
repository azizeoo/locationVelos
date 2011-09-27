/**
 * 
 */
package fr.norsys.formation.locationvelos.service;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dao.IDaoVelo;
import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public interface IVeloService {
	public IDaoVelo getDao();
	/**
	 * - M�thode appelante le dao pour ajouter un v�lo
	 * 
	 * @param velo
	 * @return
	 * @throws SQLException
	 */
	public int ajouterVelo(DtoVelo v) throws SQLException;
	/**
	 * - M�thode appelee le dao pour modifier un v�lo
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public int modifierVelo(DtoVelo v) throws SQLException;
	/**
	 * - M�thode appelee dao pour la recherche d'un v�lo
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public DtoVelo rechercherVelo(String code) throws SQLException;
	/**
	 * - M�thode appel�e dao pour la suppression d'un v�lo
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public int supprimerVelo(String code) throws SQLException;
}
