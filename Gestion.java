import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    private Parc monParc;
    private List<Client> listeClients;
    private List<Contrat> listeContrats;

    public Gestion() {
        this.monParc = new Parc();
        this.listeClients = new ArrayList<>();
        this.listeContrats = new ArrayList<>();
    }

    public void saisirParc() {
        // Exemple
        Modele mod = new Modele("Yamaha", "100ch", "Tmax", "Europe");
        Scooter s1 = new Scooter("S001", 1500.5, mod);
        monParc.ajouterScooter(s1);
        System.out.println("Scooter ajouté avec succès.");
    }

    public void traiterLocation() {

    }

    public void traiterRetour() {

    }

    public void afficherEtatScooter() {

    }

    public void afficherParc() {
        
    }
}