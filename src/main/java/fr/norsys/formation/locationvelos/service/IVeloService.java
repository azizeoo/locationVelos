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
	 * - Méthode appelante le dao pour ajouter un vélo
	 * 
	 * @param velo
	 * @return
	 * @throws SQLException
	 */
	public int ajouterVelo(DtoVelo v) throws SQLException;
	/**
	 * - Méthode appelee le dao pour modifier un vélo
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public int modifierVelo(DtoVelo v) throws SQLException;
	/**
	 * - Méthode appelee dao pour la recherche d'un vélo
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public DtoVelo rechercherVelo(String code) throws SQLException;
	/**
	 * - Méthode appelée dao pour la suppression d'un vélo
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public int supprimerVelo(String code) throws SQLException;
}
