/**
 * 
 */
package fr.norsys.formation.locationvelos.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import fr.norsys.formation.locationvelos.dto.DtoClient;
import fr.norsys.formation.locationvelos.dto.DtoVelo;

/**
 * @author technomaker09
 *
 */
public class ApplicationContext {
	private static JDBCDataSource DATASOURCE;
	
	/**
	 * METHODE POUR CONFIGURER LES INFORMATIONS NÈCESSAIRES POUR ACCÈS A LA BASE DE DONNÈES
	 * @return
	 */
	private static DataSource getApplicationDataSource(String[] infoDB) {
		if (null == DATASOURCE) {
			DATASOURCE = new JDBCDataSource();
			DATASOURCE.setUrl(infoDB[0]);
			DATASOURCE.setUser(infoDB[1]);
			DATASOURCE.setPassword(infoDB[2]);
		}
		return DATASOURCE;
	}

	/**
	 * METHODE POUR RENDRE LA CONNEXION VERS LA BASE DE DONNÈES
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnexion(String[] infoDB) throws SQLException{
		DataSource ds = getApplicationDataSource(infoDB);
		return ds.getConnection();
	}
	/**
	 * METHODE POUR RECUPERER LES DONNÈES A PARTIR D'UN FICHIER XML
	 * @param nomFichierXML
	 * @return
	 */
	public static String[] xmlToStrigDB(String nomFichierXML){
		Document document = null;
		String[] retour = new String[3];
		File xmlFile = new File(nomFichierXML);

		SAXBuilder builder = new SAXBuilder();
		try {
			document = builder.build(xmlFile);
				retour[0] = XPath.newInstance("//url").valueOf(document.getRootElement());
				retour[1] = XPath.newInstance("//username").valueOf(document.getRootElement());
				retour[2] = XPath.newInstance("//password").valueOf(document.getRootElement());
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retour;
	}
	
	/**
	 * METHODE POUR RENDRE UN CODE DE 10 CARACTERES
	 * @return
	 */
	public static String genCode() {
		long date = new Date().getTime();
		String s = String.valueOf(date);
		s = s.substring(3, 13);
		return s;
	}
	
	/**
	 * METHODE POUR CONVERTIR UNE RESULTSET DE DtoVelo EN LISTE DE DtoVelo
	 * @param r
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * METHODE POUR CONVERTIR UNE RESULTSET DE DtoClient EN LISTE DE DtoClient
	 * @param r
	 * @return
	 * @throws SQLException
	 */
	public static List<DtoClient> clientResultSetToList(ResultSet r) throws SQLException{
		DtoClient client;
		List<DtoClient> listClient = new ArrayList<DtoClient>();
		while(null != r && r.next()){
			client = new DtoClient();
			client.setCodeClient(r.getString("COD_CLIENT"));
			client.setNom(r.getString("NOM"));
			client.setPrenom(r.getString("PRENOM"));
			listClient.add(client);
		}
		return listClient;
	}
}
