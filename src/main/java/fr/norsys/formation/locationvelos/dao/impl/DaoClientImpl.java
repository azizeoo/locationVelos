/**
 * 
 */
package fr.norsys.formation.locationvelos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dto.DtoClient;

/**
 * @author technomaker09
 *
 */
public class DaoClientImpl implements IDaoClient {
	private String addClientQuery						= "INSERT INTO CLIENT VALUES(? , ? , ?)";
	private String deleteClientQuery					= "DELETE FROM CLIENT WHERE COD_CLIENT= ?";
	private Connection conn;
	/**
	 * @param conn 
	 * 
	 */
	public DaoClientImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public int createClient(DtoClient client) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(addClientQuery);
		pstmt.setString(1, client.getCodeClient());
		pstmt.setString(2, client.getNom());
		pstmt.setString(3, client.getPrenom());
		int maj = pstmt.executeUpdate();
		pstmt.close();
		return maj;
	}

	public int deleteClient(String code) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(deleteClientQuery);
		pstmt.setString(1, code);
		int maj = pstmt.executeUpdate();
		pstmt.close();
		return maj;
	}

}
