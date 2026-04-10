import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    Scanner scanner = new Scanner(System.in);
    private Parc monParc;
    private List<Client> listeClients;
    private List<Contrat> listeContrats;

    public Gestion() {
        this.monParc = new Parc();
        this.listeClients = new ArrayList<>();
        this.listeContrats = new ArrayList<>();
        initialiserParc();
    }

    private void initialiserParc() {
        if (monParc.chercherScooter("S001") == null) {
            Modele mod = new Modele("Yamaha", "100ch", "Tmax", "Europe");
            Scooter s1 = new Scooter("S001", 1500.5, mod);
            monParc.ajouterScooter(s1);
        }
    }

    // Point 5
    public void saisirParc() {
        if (monParc.chercherScooter("S001") == null) {
            Modele mod = new Modele("Yamaha", "100ch", "Tmax", "Europe");
            Scooter s1 = new Scooter("S001", 1500.5, mod);
            monParc.ajouterScooter(s1);
            System.out.println("Scooter ajouté avec succès.");
        } else {
            System.out.println("Le parc est déjà initialisé. Aucun nouveau scooter n'est ajouté.");
        }
    }

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
    //Point 2
    public void traiterRetour(String id_Scooter, double kmParcourus) {
        Scooter s = monParc.chercherScooter(id_Scooter);
        if (s != null && !s.isEstDisponible()) {
            s.retour(kmParcourus);
            System.out.println("Le scooter " + id_Scooter + " a été retourné. Il est de nouveau disponible.");
            System.out.println("Son nouveau kilométrage est de : " + s.getKilometrage() + " km.");
        } else {
            System.out.println("Ce scooter n'est pas en cours de location.");
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
    public void traiterLocation (String id_scooter){
        Scooter s = monParc.chercherScooter(id_scooter);
            if(s != null && s.isEstDisponible()){
                s.louer();
                System.out.println("\nLe scooter " + id_scooter + " a été loué.");
            }else{
                System.out.println("\nLe scooter est introuvable ou déja en location");
            }
    }

    public Parc getMonParc() {
        return monParc;
    }
    
}