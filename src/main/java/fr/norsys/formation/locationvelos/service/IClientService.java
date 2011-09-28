/**
 * 
 */
package fr.norsys.formation.locationvelos.service;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dto.DtoClient;

/**
 * @author technomaker09
 *
 */
public interface IClientService {
	public IDaoClient getDao();

	/**
	 * - Méthode appelante le dao pour ajouter un client
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	public int ajouterClient(DtoClient client) throws SQLException;

	/**
	 * - Méthode appelante le dao pour modifier un client
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	public int modifierClient(DtoClient client) throws SQLException;
	
	/**
	 * - Méthode appelante le dao pour rechercher un client
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public DtoClient rechercherClient(String code) throws SQLException;

	/**
	 * - Méthode appelante le dao pour supprimer un client
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public int supprimerClient(String code) throws SQLException;
}
