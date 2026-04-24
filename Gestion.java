import java.util.ArrayList;
import java.util.List;

public class Gestion {
    private Parc monParc; // tous les scooters du parc
    private List<Client> listeClients; // liste de tous les clients
    private List<Contrat> listeContrats; // historique des contrats et des locations
    private Tarification tarificationBase; // le prix journalier par défaut

    public Gestion() {
        this.monParc = new Parc(); // on crée un parc vide
        this.listeClients = new ArrayList<>(); // on crée une liste de clients vide
        this.listeContrats = new ArrayList<>();// on crée une liste de contrats vide
        this.tarificationBase = new Tarification(25.0); // on fixe le prix de base
        initialiserParc(); // on mets des scooters dans le parc à scooter
        initialiserClientsDeTest(); // on crée les clients
        initialiserContrat(); // on crée une location
    }

    private void initialiserParc() {
        if (monParc.chercherScooter("S001") == null) { // si le scooter S001 n'existe pas, alors on le crée
            Modele mod = new Modele("Yamaha", "100ch", "Tmax", "Europe");
            Scooter s1 = new Scooter("S001", 1500.5, mod);
            monParc.ajouterScooter(s1); // on l'ajoute dans le parc
            
        }
        if (monParc.chercherScooter("S002") == null) {
            Modele mod2 = new Modele("Piaggio", "125cc", "Liberty", "Europe");
            Scooter s2 = new Scooter("S002", 800.0, mod2);
            monParc.ajouterScooter(s2);
        }
        if (monParc.chercherScooter("S003") == null) {
            Modele mod3 = new Modele("Honda", "150cc", "PCX", "Asie");
            Scooter s3 = new Scooter("S003", 2200.0, mod3);
            monParc.ajouterScooter(s3);
        }
        if (monParc.chercherScooter("S004") == null) {
            Modele mod4 = new Modele("Kymco", "125cc", "People S", "Asie");
            Scooter s4 = new Scooter("S004", 1500.0, mod4);
            monParc.ajouterScooter(s4);
        }
    }

    private void initialiserClientsDeTest() {
        HabitudeClient hab1 = new HabitudeClient(12, 1500.0);
        Client client1 = new Client("Fisson", "Sylvain", 1, "012345678", "sylvain.fisson@mail.com", hab1);
        listeClients.add(client1);

        HabitudeClient hab2 = new HabitudeClient(4, 450.0);
        Client client2 = new Client("Potter", "Harry", 2, "07777777777", "harry.potter@mail.com", hab2);
        listeClients.add(client2);

        HabitudeClient hab3 = new HabitudeClient(0, 0);
        Client client3 = new Client("Tonton", "Kim", 3, "01010101010", "attack.moi@mail.com", hab3);
        listeClients.add(client3);

        HabitudeClient hab4 = new HabitudeClient(2, 28);
        Client client4 = new Client("Sarah", "Croche", 4, "18112682", "sarah.croche@mail.com", hab4);
        listeClients.add(client4);

        HabitudeClient hab5 = new HabitudeClient(6, 320.0);
        Client client5 = new Client("Dupont", "Jean", 5, "0600000001", "jean.dupont@mail.com", hab5);
        listeClients.add(client5);

        HabitudeClient hab6 = new HabitudeClient(15, 2100.0);
        Client client6 = new Client("Martin", "Sophie", 6, "0600000002", "sophie.martin@mail.com", hab6);
        listeClients.add(client6);

        HabitudeClient hab7 = new HabitudeClient(1, 50.0);
        Client client7 = new Client("Bernard", "Lucas", 7, "0600000003", "lucas.bernard@mail.com", hab7);
        listeClients.add(client7);
    }

    private void initialiserContrat() {
        if (!listeClients.isEmpty()) {
            Client client = listeClients.get(0);
            Scooter s1 = monParc.chercherScooter("S001");
            if (s1 != null && s1.isEstDisponible()) {
                s1.louer();
                String idContrat = "CRT-" + (listeContrats.size() + 1);
                java.util.Date dateFinPrevue = new java.util.Date(System.currentTimeMillis() + 24L * 60 * 60 * 1000);
                Contrat c1 = new Contrat(idContrat, client, s1, tarificationBase, dateFinPrevue);
                listeContrats.add(c1);
            }
        }
    }

    // Point 5
    public void saisirParc2(String id_scooter, double km_init, String nomModele, String moteur, String marque, String pays){
        if(monParc.chercherScooter(id_scooter) == null){ // vérifie si l'id est libre
            Modele mod = new Modele(nomModele, moteur, marque, pays);
            Scooter newScooter = new Scooter(id_scooter, km_init, mod);
            monParc.ajouterScooter(newScooter);
            System.out.println("\nLe scooter " + id_scooter + " a été ajouté au parc avec succès !");
        }else{
            System.out.println("\nUn scooter avec l'ID " + id_scooter + " existe déjà dans le parc.");
        }
    }

    // Point 9
    public void saisirClient(String nom, String prenom, int id_client, String telephone, String e_mail) {
        for (Client client : listeClients) {
            if (client.getId_client() == id_client) {
                System.out.println("\nUn client avec l'ID " + id_client + " existe déjà."); // stoppe si l'id client existe déjà 
                return;
            }
        }
        HabitudeClient habitude = new HabitudeClient(0, 0.0); // un nouveau client représente zéro dépense
        Client nouveauClient = new Client(nom, prenom, id_client, telephone, e_mail, habitude);
        listeClients.add(nouveauClient);
        System.out.println("\nLe client " + prenom + " " + nom + " a été ajouté avec succès !");
    }
    //Point 2
    public void traiterRetour(String id_Scooter, double kmParcourus) {
        Scooter s = monParc.chercherScooter(id_Scooter); // cerche le scooter 
        if (s != null && !s.isEstDisponible()) { // s'il existe déjà et qu'il est loué
            s.retour(kmParcourus); // on le libère et on ajoute les kilomètres
            Contrat Contratactif = null;
            for( Contrat c : listeContrats){ // on cherche le contrat correspondant
                if(c.getScooter().getId().equals(id_Scooter) && c.getDateFinReelle()==null){
                    Contratactif = c;
                    break;
                }
            }
            System.out.println("Le scooter " + id_Scooter + " a été retourné. Il est de nouveau disponible.");
            System.out.println("Son nouveau kilométrage est de : " + s.getKilometrage() + " km.");
            if(Contratactif != null){
                System.out.println("-----Facture------");
                Contratactif.cloturerContrat(kmParcourus); // on calcule le prix final
                Contratactif.getScooter();
                System.out.println(Contratactif.editerFacture()); // on affiche la facture
                System.out.println("-------------------");
            }
        } else {
            System.out.println("Ce scooter n'est pas en cours de location ou introuvable");
        }
    }

    //Point 3
    public void afficherEtatScooter(String id_scooter) {
        // on affiche le statut du parc (de la classe Parc)g
        Scooter s = monParc.chercherScooter(id_scooter);
        if(s != null){
            String etat = s.isEstDisponible() ? "Disponible" : "Indisponible";
            System.out.println("\n--- Fiche technique du scooter "+ s.getId()+"---");
            Modele m = s.getModele();
            System.out.println("\nScooter ID : " + s.getId() + "\n- Nombre de km : "+ s.getKilometrage() +"\n- Modele : "+ m.getNom_modele() +"\n- Marque : "+ m.getNom_marque()+"\n- Motorisation : "+ m.getMotorisation() + "\n- Pays origine : " + m.getPaysOrigine() + "\nETAT : "+ etat);
        }
        else {
            System.out.println("Scooter introuvable");       
        }
    }

    //Point 4
    public void afficherParc() {
        System.out.println("--- État du Parc --- ");
        List<Scooter> liste = monParc.getListeScooters();
        int total = liste.size();
        int libre = 0;
        for (Scooter s : liste) {
            if(s.isEstDisponible()){
                libre ++; // compte les scooters disponibles
            }
        }
        System.out.print("Total : "+ total + "; Libre : "+ libre);
        System.out.println("\n--- liste des véhicule ---");
        for (Scooter s : monParc.getListeScooters()) {
            String etat = s.isEstDisponible() ? "Dispo" : "Loué";
            System.out.println("["+ etat + "] Scooter n° "+ s.getId()+"("+ s.getKilometrage() + "km )"); // créer une boucle pour savoir si le scooter est libre ou loué
        }
    }

    //Point 1
    public void traiterLocation (String id_scooter, int id_client){
        Scooter s = monParc.chercherScooter(id_scooter); // on trouve le scooter
        Client c = null;
        for(Client clientTempo : listeClients){ // on trouve le client par son id
            if(clientTempo.getId_client()== id_client){
                c = clientTempo;
            }
        }
            if(s != null && s.isEstDisponible()){
                s.louer(); // on marque le scooter comme loué
                Tarification tarif = this.tarificationBase;
                String idContrat = "CRT-" + listeContrats.size() + 1;
                java.util.Date finPrevu = new java.util.Date (System.currentTimeMillis() + (1000+60+60+24));
                Contrat nouveauContrat = new Contrat(idContrat, c, s, tarif, finPrevu);
                listeContrats.add(nouveauContrat); // ajoute à la liste des contrats
                c.getHabitude().incrementerLocations(); // +1 locations pour l'habitude de ce client
                System.out.println("\nLe contrat est n°"+ idContrat + " a été crée !");
                System.out.println("\nLe scooter " + id_scooter + " a été loué et doit être retourner le : "+finPrevu);
            }else{
                System.out.println("\nLe scooter est introuvable ou déja en location");
            }
    }

    public Parc getMonParc() {
        return monParc;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    // Point 8
    public void modifierPrixBase(double nouveauPrix) {
        if (nouveauPrix > 0) {
            this.tarificationBase.modifierPrixBase(nouveauPrix);
        } else {
            System.out.println("Le nouveau tarif doit être supérieur à 0.");
        }
    }
}