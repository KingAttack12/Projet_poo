import java.util.ArrayList;
import java.util.List;

public class Gestion {
    private Parc monParc;
    private List<Client> listeClients;
    private List<Contrat> listeContrats;
    private Tarification tarificationBase;

    public Gestion() {
        this.monParc = new Parc();
        this.listeClients = new ArrayList<>();
        this.listeContrats = new ArrayList<>();
        this.tarificationBase = new Tarification(25.0);
        initialiserParc();
        initialiserClientsDeTest();
        initialiserContrat();
    }

    private void initialiserParc() {
        if (monParc.chercherScooter("S001") == null) {
            Modele mod = new Modele("Yamaha", "100ch", "Tmax", "Europe");
            Scooter s1 = new Scooter("S001", 1500.5, mod);
            monParc.ajouterScooter(s1);
            
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
        listeClients.add
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
        if(monParc.chercherScooter(id_scooter) == null){
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
                System.out.println("\nUn client avec l'ID " + id_client + " existe déjà.");
                return;
            }
        }
        HabitudeClient habitude = new HabitudeClient(0, 0.0);
        Client nouveauClient = new Client(nom, prenom, id_client, telephone, e_mail, habitude);
        listeClients.add(nouveauClient);
        System.out.println("\nLe client " + prenom + " " + nom + " a été ajouté avec succès !");
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
            System.out.println("Le scooter " + id_Scooter + " a été retourné. Il est de nouveau disponible.");
            System.out.println("Son nouveau kilométrage est de : " + s.getKilometrage() + " km.");
            if(Contratactif != null){
                System.out.println("-----Facture------");
                Contratactif.cloturerContrat(kmParcourus);
                Contratactif.getScooter();
                System.out.println(Contratactif.editerFacture());
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
                libre ++;
            }
        }
        System.out.print("Total : "+ total + "; Libre : "+ libre);
        System.out.println("\n--- liste des véhicule ---");
        for (Scooter s : monParc.getListeScooters()) {
            String etat = s.isEstDisponible() ? "Dispo" : "Loué";
            System.out.println("["+ etat + "] Scooter n° "+ s.getId()+"("+ s.getKilometrage() + "km )");
        }
    }

    //Point 1
    public void traiterLocation (String id_scooter, int id_client){
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
                java.util.Date finPrevu = new java.util.Date (System.currentTimeMillis() + (1000+60+60+24));
                Contrat nouveauContrat = new Contrat(idContrat, c, s, tarif, finPrevu);
                listeContrats.add(nouveauContrat);
                c.getHabitude().incrementerLocations();
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