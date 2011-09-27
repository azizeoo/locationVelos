/**
 * 
 */
package fr.norsys.formation.locationvelos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.locationvelos.dao.IDaoVelo;
import fr.norsys.formation.locationvelos.dto.DtoVelo;
import fr.norsys.formation.locationvelos.util.ApplicationContext;

/**
 * @author technomaker09
 *
 */
public class DaoVeloImpl implements IDaoVelo {
	private String findAllVeloQuery 				= "SELECT COD_VELO, MARQUE, PRIX, COD_CLIENT FROM VELO ";
	private String byIdQuery 						= "WHERE COD_VELO=?";
	private String addVeloQuery						= "INSERT INTO VELO VALUES(? , ? , ? , ?)";
	private String modifyVeloQuery					= "UPDATE VELO SET MARQUE= ?, PRIX= ?, COD_CLIENT= ? WHERE COD_VELO= ?";
	private String deleteVeloQuery					= "DELETE FROM VELO WHERE COD_VELO= ?";
	private Connection conn;
	

	public DaoVeloImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/* (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.dao.IDaoVelo#createVelo(DtoVelo)
	 */
	public int createVelo(DtoVelo v)
			throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(addVeloQuery);
		pstmt.setString(1, v.getCodeVelo());
		pstmt.setString(2, v.getMarque());
		pstmt.setDouble(3, v.getPrix());
		pstmt.setString(4, v.getClient().getCodeClient());
		int maj = pstmt.executeUpdate();
		pstmt.close();
		return maj;
	}

	/* (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.dao.IDaoVelo#updateVelo(DtoVelo)
	 */
	public int updateVelo(DtoVelo v)
			throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(modifyVeloQuery);
		pstmt.setString(4, v.getCodeVelo());
		pstmt.setString(1, v.getMarque());
		pstmt.setDouble(2, v.getPrix());
		pstmt.setString(3, v.getClient().getCodeClient());
		int maj = pstmt.executeUpdate();
		pstmt.close();
		return maj;
	}

	/* (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.dao.IDaoVelo#deleteVelo(DtoVelo)
	 */
	public int deleteVelo(String codeVelo)
			throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(deleteVeloQuery);
		pstmt.setString(1, codeVelo);
		int maj = pstmt.executeUpdate();
		pstmt.close();
		return maj;
	}

	/* (non-Javadoc)
	 * @see fr.norsys.formation.locationvelos.dao.IDaoVelo#selectVelo(DtoVelo)
	 */
	public List<DtoVelo>  selectVelo(String code)
			throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(findAllVeloQuery + byIdQuery);
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();
		pstmt.close();
		return ApplicationContext.veloResultSetToList(rs);
	}

}
