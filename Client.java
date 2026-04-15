public class Client {
    private String nom;
    private String prenom;
    private int id_client;
    private String telephone;
    private String e_mail;
    
    // Associations
    private HabitudeClient habitude;

    public Client(String nom, String prenom, int id_client, String telephone, String e_mail, HabitudeClient habitude) {
        this.nom = nom;
        this.prenom = prenom;
        this.id_client = id_client;
        this.telephone = telephone;
        this.e_mail = e_mail;
        this.habitude = habitude;
    }

    public String getInfosClient() {
        return "\n\nClient N°" + id_client + " : " + nom + " " + prenom + "\n- numéro : " + telephone + "\n- email : " + e_mail + "\n- Habitude : " + habitude;
    }

    public HabitudeClient getHabitude() {
        return habitude;
    }

    public void modifierContact(String tel, String email) {
        this.telephone = tel;
        this.e_mail = email;
    }

    public int getId_client(){
        return id_client;
    }
}
	