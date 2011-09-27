/**
 * 
 */
package fr.norsys.formation.locationvelos.dto;

/**
 * @author technomaker09
 *
 */
public class DtoClient {
	private String codeClient;
	private String nom;
	private String prenom;
	
	public DtoClient() {
		super();
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
