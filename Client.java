public class Client { // donne les données personnelles du client
    private String nom;
    private String prenom;
    private int id_client;
    private String telephone;
    private String e_mail;
    
    // Associations
    private HabitudeClient habitude; // il s'agit d'un objet qui contient l'historique du client

    // on enregistre un nouveau client
    public Client(String nom, String prenom, int id_client, String telephone, String e_mail, HabitudeClient habitude) { // on initialise les données
        this.nom = nom;
        this.prenom = prenom;
        this.id_client = id_client;
        this.telephone = telephone;
        this.e_mail = e_mail;
        this.habitude = habitude;
    }

    public String getInfosClient() { // retourne une fiche client
        return "\n\nClient N°" + id_client + " : " + nom + " " + prenom + "\n- numéro : " + telephone + "\n- email : " + e_mail + "\n- Habitude : " + habitude;
    }

    public HabitudeClient getHabitude() { // permet d'accéder aux statistiques du client
        return habitude; // retourne les habitudes du client
    }

    public void modifierContact(String tel, String email) { // permet de mettre à jour les différentes informations du contact
        this.telephone = tel; // remplace l'ancien numéro de téléphone
        this.e_mail = email; // remplace l'ancien email
    }

    public int getId_client(){ // permet de récupérer l'id du client
        return id_client;
    }
}
	