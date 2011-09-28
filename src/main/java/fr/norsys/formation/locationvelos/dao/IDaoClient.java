/**
 * 
 */
package fr.norsys.formation.locationvelos.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public interface IDaoClient {
	/**
	 * DAO POUR L'AJOUT D'UN CLIENT
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	int createClient(DtoClient client) throws SQLException;
	/**
	 * DAO POUR LA SUPPRESSION D'UN CLIENT
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	int deleteClient(String code) throws SQLException;
	/**
	 * DAO POUR LA MODIFICATION D'UN CLIENT
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	int updateClient(DtoClient client) throws SQLException;
	/**
	 * DAO POUR LA SELECTION D'UN CLIENT
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	List<DtoClient> selectClient(String code) throws SQLException;

}
