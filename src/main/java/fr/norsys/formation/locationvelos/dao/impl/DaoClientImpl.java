/**
 * 
 */
package fr.norsys.formation.locationvelos.dao.impl;
import static fr.norsys.formation.locationvelos.util.ApplicationContext.clientResultSetToList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.locationvelos.dao.IDaoClient;
import fr.norsys.formation.locationvelos.dto.DtoClient;

/**
 * @author technomaker09
 *
 */
public class DaoClientImpl implements IDaoClient {
	private String addClientQuery						= "INSERT INTO CLIENT VALUES(? , ? , ?)";
	private String deleteClientQuery					= "DELETE FROM CLIENT WHERE COD_CLIENT= ?";
	private String modifyClientQuery					= "UPDATE CLIENT SET NOM= ?, PRENOM= ? WHERE COD_CLIENT= ?";
	private String findAllClientQuery 					= "SELECT COD_CLIENT, NOM, PRENOM FROM CLIENT ";
	private String byIdQuery 							= "WHERE COD_CLIENT=?";
	
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

	public int updateClient(DtoClient client) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(modifyClientQuery);
		pstmt.setString(3, client.getCodeClient());
		pstmt.setString(1, client.getNom());
		pstmt.setString(2, client.getPrenom());
		int maj = pstmt.executeUpdate();
		pstmt.close();
		return maj;
	}

	public List<DtoClient> selectClient(String code) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(findAllClientQuery + byIdQuery);
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();
		pstmt.close();
		return clientResultSetToList(rs);
	}

}
