public class Client {
    private String nom;
    private String prenom;
    private int id_client;
    private String telephone;
    private String e_mail;
    
    // Associations
    private Login login;
    private HabitudeClient habitude;

    public Client(String nom, String prenom, int id_client, String telephone, String e_mail, Login login, HabitudeClient habitude) {
        this.nom = nom;
        this.prenom = prenom;
        this.id_client = id_client;
        this.telephone = telephone;
        this.e_mail = e_mail;
        this.login = login;
        this.habitude = habitude;

    }

    public String getInfosClient() {
        return "Client N°" + id_client + " : " + nom + " " + prenom + " " + telephone + " " + e_mail + " " + habitude + " " + login;
    }

    public void modifierContact(String tel, String email) {
        this.telephone = tel;
        this.e_mail = email;
    }
}
	