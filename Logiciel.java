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

    public void lancer(){
        Scanner scanner = new Scanner(System.in);
        int choix;
        do{
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch(choix){
                case 1: 
                    System.out.println("Donner l'ID du scooter à louer :");
                    gestionnaire.TraiterLocation(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Donner l'ID du scooter à retourner :")
                    gestionnaire.traiterRetour(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Donner l'ID du scooter :");
                    gestionnaire.afficherEtatScooter(scanner.nextLine());
                    break;
                case 4:
                    gestionnaire.afficherParc();
                    break;
                case 5:
                    gestionnaire.saisirParc();
                    break;
                case 6:
                    System.out.println("Fermeture du programme !");
            
            }
        }while(choix != 6);
            scanner.close();
        
    }

    public static void main(String[] args){
        Logiciel appl = new Logiciel();
        appl.lancer();
    }
}