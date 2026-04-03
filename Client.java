public class Client {
	private String nom;
    	private String prenom;
    	private int id_client;
    	private int telephone;
    	private String e_mail;
    
    	// Associations
    	private Login login;
    	private HabitudeClient habitude;

    	public Client(String nom, String prenom, int id_client) {
        	this.nom = nom;
        	this.prenom = prenom;
        	this.id_client = id_client;
    	}

    	public String getInfosClient() {
        	return "Client N°" + id_client + " : " + nom + " " + prenom;
    	}

    	public void modifierContact(int tel, String email) {
        	this.telephone = tel;
        	this.e_mail = email;
    	}
}
	