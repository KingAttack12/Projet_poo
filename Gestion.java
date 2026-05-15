
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
        initialiserParc(); // on mets des scooters dans le parc à scooter
        initialiserClientsDeTest(); // on crée les clients
        //initialiserContrat(); // on crée une location
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
    // Point 5
    public void saisirParc(String id_scooter, double km_init, String nomModele, String moteur, String marque, String pays){
        if(monParc.chercherScooter(id_scooter) == null){
            Modele mod = new Modele(nomModele, moteur, marque, pays);
            Scooter newScooter = new Scooter(id_scooter, km_init, mod);
            monParc.ajouterScooter(newScooter);
            System.out.println(">> Scooter " + id_scooter + " ajouté au parc!");
        }else{
            System.out.println(">> Erreur: scooter " + id_scooter + " existe déjà!");
        }
    }

    // Point 9
    public void saisirClient(String nom, String prenom, int id_client, String telephone, String e_mail) {
        for (Client client : listeClients) {
            if (client.getId_client() == id_client) {
                System.out.println(">> Erreur: client " + id_client + " existe déjà!");
                return;
            }
        }
        HabitudeClient habitude = new HabitudeClient(0, 0.0);
        Client nouveauClient = new Client(nom, prenom, id_client, telephone, e_mail, habitude);
        listeClients.add(nouveauClient);
        System.out.println(">> Client " + prenom + " " + nom + " ajouté!");
    }
    //Point 2
    public void traiterRetour(String id_Scooter, double kmParcourus) {
        Scooter s = monParc.chercherScooter(id_Scooter);
        if (s != null && !s.isEstDisponible()) {
            s.retour(kmParcourus);
            Contrat Contratactif = null;
            for( Contrat c : listeContrats){
                if(c.getScooter().getId().equals(id_Scooter) && c.getDateFinReelle()==null){
                    Contratactif = c;
                    break;
                }
            }
            System.out.println(">> Scooter " + id_Scooter + " retourné. Kilométrage: " + s.getKilometrage() + " km");
            if(Contratactif != null){
                System.out.println("=== FACTURE ===");
                Contratactif.cloturerContrat(kmParcourus);
                Contratactif.getScooter();
                System.out.println(Contratactif.editerFacture());
                System.out.println("===============");
            }
        } else {
            System.out.println(">> Erreur: scooter introuvable ou non loué");
        }
    }

    //Point 3
    public void afficherEtatScooter(String id_scooter) {
        Scooter s = monParc.chercherScooter(id_scooter);
        if(s != null){
            String etat = s.isEstDisponible() ? "Disponible" : "Indisponible";
            System.out.println("=== FICHE SCOOTER " + s.getId() + " ===");
            Modele m = s.getModele();
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

    //Point 4
    public void afficherParc() {
        List<Scooter> liste = monParc.getListeScooters();
        int total = liste.size();
        int libre = 0;
        for (Scooter s : liste) {
            if(s.isEstDisponible()){
                libre ++;
            }
        }
        System.out.println("Total: " + total + " | Disponibles: " + libre + " | Loués: " + (total - libre));
        System.out.println("--------------------");
        for (Scooter s : monParc.getListeScooters()) {
            String etat = s.isEstDisponible() ? "[DISPO]" : "[LOUÉ]";
            System.out.println(etat + " " + s.getId() + " - " + s.getKilometrage() + " km");
        }
    }

    //Point 1
    public void traiterLocation (String id_scooter, int id_client, int nombreJours){
        Scooter s = monParc.chercherScooter(id_scooter);
        Client c = null;
        for(Client clientTempo : listeClients){
            if(clientTempo.getId_client()== id_client){
                c = clientTempo;
            }
        }
            if(s != null && s.isEstDisponible()){
                s.louer();
                Tarification tarif = this.tarificationBase;
                String idContrat = "CRT-" + listeContrats.size() + 1;
                java.util.Date finPrevu = new Date (System.currentTimeMillis()+(nombreJours * 86400000));
                Contrat nouveauContrat = new Contrat(idContrat, c, s, tarif, finPrevu);
                listeContrats.add(nouveauContrat);
                c.getHabitude().incrementerLocations();
                System.out.println(">> Contrat " + idContrat + " créé!");
                System.out.println(">> Scooter " + id_scooter + " loué pour " + nombreJours + " jour(s) jusqu'au: " + finPrevu);
            }else{
                System.out.println(">> Erreur: scooter introuvable ou déjà loué");
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
            System.out.println(">> Nouveau tarif: " + nouveauPrix + "euro/jour");
        } else {
            System.out.println(">> Erreur: le tarif doit être positif");
        }
    }
}