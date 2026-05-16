
import java.util.ArrayList;
import java.util.Date;
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
        initialiserParc(); // on mets des scooters définis par défaut dans le parc à scooter
        initialiserClientsDeTest(); // on ajoute des clients par défaut
    }

    private void initialiserParc() {
        if (monParc.chercherScooter("S001") == null) { // si le scooter S001 n'existe pas, alors on le crée
            Modele mod = new Modele("Yamaha", "100ch", "Tmax", "Europe");//création d'un nouveau modèle
            Scooter s1 = new Scooter("S001", 1500.5, mod);//création d'un nouveau scooter
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
        HabitudeClient hab1 = new HabitudeClient(12, 1500.0);//création d'une habitude client
        Client client1 = new Client("Fisson", "Sylvain", 1, "012345678", "sylvain.fisson@mail.com", hab1);//création d'un client
        listeClients.add(client1);//ajouter le client à la liste

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
    // Point 5 : saisir les scooters dans le parc
    public void saisirParc(String id_scooter, double km_init, String nomModele, String moteur, String marque, String pays){
        if(monParc.chercherScooter(id_scooter) == null){ //si le scooter n'existe pas déjà
            Modele mod = new Modele(nomModele, moteur, marque, pays);//crée un modèle à partir du constructeur
            Scooter newScooter = new Scooter(id_scooter, km_init, mod);//crée un scooter à partir du constructeur
            monParc.ajouterScooter(newScooter);//ajouter le scooter au parc
            System.out.println(">> Scooter " + id_scooter + " ajouté au parc!");
        }else{// sinon
            System.out.println(">> Erreur: scooter " + id_scooter + " existe déjà!");
        }
    }

    // Point 9 : saisir de nouveau client
    public void saisirClient(String nom, String prenom, int id_client, String telephone, String e_mail) {
        for (Client client : listeClients) {//chercher dans la liste de client
            if (client.getId_client() == id_client) {// si l'id du client saisi correspond déjà à un client existant
                System.out.println(">> Erreur: client " + id_client + " existe déjà!");//message erreur
                return;//retourne rien 
            }
        }//sinon
        HabitudeClient habitude = new HabitudeClient(0, 0.0);// création d'une habitude par défaut
        Client nouveauClient = new Client(nom, prenom, id_client, telephone, e_mail, habitude);// création du client en fonction de la saisi
        listeClients.add(nouveauClient);// ajoute le client à la liste
        System.out.println(">> Client " + prenom + " " + nom + " ajouté!");
    }
    //Point 2 : retourner le scooter et cloturer le contrat
    public void traiterRetour(String id_Scooter, double kmParcourus) {
        Scooter s = monParc.chercherScooter(id_Scooter); // recuperer le scooter en fonction de son ID
        if (s != null && !s.isEstDisponible()) {// si le scooter existe et il est occupé
            s.retour(kmParcourus);// enclancher le retour et incrémenter les km parcourus
            Contrat Contratactif = null; //initialiser le contrat à null
            for( Contrat c : listeContrats){// chercher dans les contrats en cours
                if(c.getScooter().getId().equals(id_Scooter) && c.getDateFinReelle()==null){//si l'ID scooter du contrat est égal au scooter du parc et qu'im n'y a pas de date de fin réel (contrat en cours)
                    Contratactif = c;//mettre le contrat dans la variable contratactif
                    break;
                }
            }
            System.out.println(">> Scooter " + id_Scooter + " retourné. Kilométrage: " + s.getKilometrage() + " km");
            if(Contratactif != null){// verifier si le contrat est pas vide
                System.out.println("=== FACTURE ===");// mise en place de la facture
                Contratactif.cloturerContrat(kmParcourus);// calculer le prix final 
                Contratactif.getScooter();//recuperer les données du scooter
                System.out.println(Contratactif.editerFacture());// mettre en place la facture
                System.out.println("===============");
            }
        } else {
            System.out.println(">> Erreur: scooter introuvable ou non loué");
        }
    }

    //Point 3 : afficher l'état et les informations d'un scooter en particulier
    public void afficherEtatScooter(String id_scooter) {
        Scooter s = monParc.chercherScooter(id_scooter);// recupéré le scooter du parc grâce à son ID
        if(s != null){ // si le scooter existe
            String etat = s.isEstDisponible() ? "Disponible" : "Indisponible"; // si isEstDisponible() return true : l'etat est disponible sinon Indisponible
            System.out.println("=== FICHE SCOOTER " + s.getId() + " ===");
            Modele m = s.getModele();// recupérer le modèle du scooter en question
            System.out.println("Kilométrage : " + s.getKilometrage() + " km");
            System.out.println("Modèle      : " + m.getNom_modele());
            System.out.println("Marque      : " + m.getNom_marque());
            System.out.println("Motorisation: " + m.getMotorisation());
            System.out.println("Origine     : " + m.getPaysOrigine());
            System.out.println("État        : " + etat);
            System.out.println("==========================");
        }
        else {
            System.out.println(">> Erreur: scooter introuvable");
        }
    }

    //Point 4 : afficher l'état de tous les scooters du parc
    public void afficherParc() {
        List<Scooter> liste = monParc.getListeScooters(); // récupérer la liste des scooters du parc
        int total = liste.size(); // calculer le nombre total de scooters dans la liste
        int libre = 0; // initialiser le compteur de scooters disponibles
        for (Scooter s : liste) { // parcourir la liste
            if(s.isEstDisponible()){ // si le scooter est disponible
                libre ++; // incrémenter le compteur
            }
        }
        System.out.println("Total: " + total + " | Disponibles: " + libre + " | Loués: " + (total - libre)); // afficher la disponiblilité
        System.out.println("--------------------");
        for (Scooter s : monParc.getListeScooters()) { // recupère tous les scooter du parc
            String etat = s.isEstDisponible() ? "[DISPO]" : "[LOUÉ]"; // déterminer l'état de chaque scooter du parc
            System.out.println(etat + " " + s.getId() + " - " + s.getKilometrage() + " km"); // afficher les informations de chaque scooter du parc
        }
    }

    //Point 1 : créer une nouvelle location de scooter
    public void traiterLocation (String id_scooter, int id_client, int nombreJours){
        Scooter s = monParc.chercherScooter(id_scooter); // récupérer le scooter en fonction de son ID
        Client c = null; // initialiser le client à null
        for(Client clientTempo : listeClients){ // chercher le client dans la liste
            if(clientTempo.getId_client()== id_client){ // si l'ID du client correspond
                c = clientTempo; // assigner le client trouvé
            }
        }
            if(s != null && s.isEstDisponible()){ // si le scooter existe et est disponible
                s.louer(); // marquer le scooter comme loué
                Tarification tarif = this.tarificationBase; // appliquer le tarif de base
                String idContrat = "CRT-" + listeContrats.size() + 1; // générer un ID de contrat unique
                java.util.Date finPrevu = new Date (System.currentTimeMillis()+(nombreJours * 86400000)); // calculer la date de fin prévue : nombre de jours de la location * nombre de seconde dans 1j
                Contrat nouveauContrat = new Contrat(idContrat, c, s, tarif, finPrevu); // créer le contrat
                listeContrats.add(nouveauContrat); // ajouter le contrat à la liste contrat
                c.getHabitude().incrementerLocations(); // mettre à jour les habitudes du client
                System.out.println(">> Contrat " + idContrat + " créé!");
                System.out.println(">> Scooter " + id_scooter + " loué pour " + nombreJours + " jour(s) jusqu'au: " + finPrevu);
            }else{ // sinon
                System.out.println(">> Erreur: scooter introuvable ou déjà loué");
            }
    }

    // retourner le parc de scooters
    public Parc getMonParc() {
        return monParc;
    }

    // retourner la liste de clients
    public List<Client> getListeClients() {
        return listeClients;
    }

    // Point 8 : modifier le prix de base de la tarification journalière
    public void modifierPrixBase(double nouveauPrix) {
        if (nouveauPrix > 0) { // vérifier que le prix est positif
            this.tarificationBase.modifierPrixBase(nouveauPrix); // appliquer le nouveau tarif
            System.out.println(">> Nouveau tarif: " + nouveauPrix + "euro/jour");
        } else { // sinon
            System.out.println(">> Erreur: le tarif doit être positif");
        }
    }
}