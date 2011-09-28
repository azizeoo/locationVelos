/**
 * 
 */
package fr.norsys.formation.locationvelos.dao;

import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dto.DtoClient;

/**
 * @author technomaker09
 *
 */
public interface IDaoClient {

	int createClient(DtoClient client) throws SQLException;

	int deleteClient(String code) throws SQLException;

}
