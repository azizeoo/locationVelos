/**
 * 
 */
package fr.norsys.formation.locationvelos.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;

import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public class ApplicationContext {
	private static final String URL 	= "jdbc:hsqldb:file:data/location-velos-db";
	private static final String USER	= "LOCATION";
	private static final String PWD		= "location";
	private static JDBCDataSource DATASOURCE;
	
	private static DataSource getApplicationDataSource() {
		if (null == DATASOURCE) {
			DATASOURCE = new JDBCDataSource();
			DATASOURCE.setUrl(URL);
			DATASOURCE.setUser(USER);
			DATASOURCE.setPassword(PWD);
		}
		return DATASOURCE;
	}


	public static Connection getConnexion() throws SQLException{
		DataSource ds = getApplicationDataSource();
		return ds.getConnection();
	}

	public static String genCode() {
		long date = new Date().getTime();
		String s = String.valueOf(date);
		s = s.substring(3, 13);
		return s;
	}
	
	public static List<DtoVelo> veloResultSetToList(ResultSet r) throws SQLException{
		DtoVelo velo;
		DtoClient client;
		List<DtoVelo> listVelo = new ArrayList<DtoVelo>();
		while(null != r && r.next()){
			velo = new DtoVelo();
			client = new DtoClient();
			velo.setCodeVelo(r.getString("COD_VELO"));
			velo.setMarque(r.getString("MARQUE"));
			velo.setPrix(r.getDouble("PRIX"));
			client.setCodeClient(r.getString("COD_CLIENT"));
			velo.setClient(client);
			listVelo.add(velo);
		}
		return listVelo;
	}
}
