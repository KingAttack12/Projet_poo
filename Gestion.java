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

    public void traiterRetour() {
        // on cloture le contrat (de la classe Contrat)
    }

    public void afficherEtatScooter() {
        // on affiche le statut du parc (de la classe Parc)
    }

    public void afficherParc() {
        // on affiche la liste des scooters disponible ou non 
    }
    public void TraiterLocation (){
        //exemple
        Client client1 = new Client("Fisson", "Sylvain", 001);
        Scooter scoot1 = s1.Parc();
        Tarification tarif1 = new Tarification(10);
        Contrat C1 = new Contrat("C001", client1, scoot1, tarif1);
    }

}