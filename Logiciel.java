import java.util.Scanner;

public class Logiciel {
    private Gestion gestionnaire;

    public Logiciel() {
        this.gestionnaire = new Gestion();
    }

    public void afficherMenu() {
        System.out.println("\n----- SCOOT -----");
        System.out.println("1. Louer un scooter");
        System.out.println("2. Retour d'un scooter");
        System.out.println("3. État d'un scooter");
        System.out.println("4. Affichage de l'état du parc de scooters");
        System.out.println("5. Saisie du parc des scooters");
        System.out.println("6. Quitter le programme");
        System.out.print("Votre choix : ");
    }
}