/**
 * 
 */
package fr.norsys.formation.locationvelos.dto;

/**
 * @author technomaker09
 *
 */
public class DtoVelo {
	private String codeVelo;
	private String marque;
	private double prix;
	private DtoClient client;
	
	public DtoVelo() {
		super();
	}
	public String getCodeVelo() {
		return codeVelo;
	}
	public void setCodeVelo(String codeVelo) {
		this.codeVelo = codeVelo;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public DtoClient getClient() {
		return client;
	}
	public void setClient(DtoClient client) {
		this.client = client;
	}
}
