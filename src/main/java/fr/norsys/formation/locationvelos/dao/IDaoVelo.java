/**
 * 
 */
package fr.norsys.formation.locationvelos.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public interface IDaoVelo {
	/**
	 * DAO POUR L'AJOUT D'UN VELO
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public int createVelo(DtoVelo v) throws SQLException;
	/**
	 * DAO POUR LA MODIFICATION D'UN VELO
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public int updateVelo(DtoVelo v) throws SQLException;
	/**
	 * DAO POUR LA SUPPRESSION D'UN VELO
	 * @param codeVelo
	 * @return
	 * @throws SQLException
	 */
	public int deleteVelo(String codeVelo) throws SQLException;
	/**
	 * DAO POUR LA RERECUPERATION D'UN VELO DONNE
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public List<DtoVelo> selectVelo(String code) throws SQLException;
}
