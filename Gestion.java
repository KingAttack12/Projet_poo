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

    public void traiterRetour(String id_Scooter) {
        Scooter s = monParc.chercherScooter(id_Scooter);
        if (s != null && !s.isEstDisponible()) {
            s.retour();
            System.out.println("Le scooter " + id_Scooter + " a été retourné. Il est de nouveau disponible.");
        } else {
            System.out.println("Ce scooter n'est pas en cours de location.");
        }
    }

    public void afficherEtatScooter(String id_scooter) {
        // on affiche le statut du parc (de la classe Parc)
        Scooter s = monParc.chercherScooter(id_scooter);
        if(s != null){
            String etat = s.isEstDisponible() ? "Disponible" : "InDisponible";
            System.out.println("Le scooter d'identification : "+ s.getId()+" a parcouru"+ s.getKilometrage()+ "km et a pour etat :"+ etat);
        }
        else {
            System.out.println("Scooter introuvable")        
        }
    }

    public void afficherParc() {
        
    }
    public void TraiterLocation (){
        //exemple
        Client client1 = new Client("Fisson", "Sylvain", 001);
        Scooter scoot1 = s1.Parc(); 
        Tarification tarif1 = new Tarification(10);
        Contrat C1 = new Contrat("C001", client1, scoot1, tarif1);
    }
    
}