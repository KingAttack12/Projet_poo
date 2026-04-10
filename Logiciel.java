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
                    gestionnaire.traiterLocation(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Donner l'ID du scooter à retourner :");;
                    String idRetour = scanner.nextLine();
                    System.out.println("Combien de kilomètres a-t-il parcouru pendant la location ? :");
                    double kmFaits = scanner.nextDouble();
                    scanner.nextLine();
                    gestionnaire.traiterRetour(idRetour, kmFaits);
                    break;
                case 3:
                    System.out.println("Donner l'ID du scooter :");
                    gestionnaire.afficherEtatScooter(scanner.nextLine());
                    break;
                case 4:
                    gestionnaire.afficherParc();
                    break;
                case 5:
                    System.out.println("--- Création d'un nouveau scooter ---");
                    System.out.println("ID du scooter : ");
                    String id = scanner.nextLine();
                    System.out.println("Kilométrage de départ : ");
                    double KM_init = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Modèle : ");
                    String modele = scanner.nextLine();
                    System.out.print("Motorisation : ");
                    String moteur = scanner.nextLine();
                    System.out.println("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.println("Pays d'origine : ");
                    String pays = scanner.nextLine();
                    gestionnaire.saisirParc2(id, KM_init, modele, moteur, marque, pays);
                    break;
                case 6:
                    System.out.println("Fermeture du programme !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            
            }
        }while(choix != 6);
            scanner.close();
        
    }

    public static void main(String[] args){
        Logiciel appl = new Logiciel();
        appl.lancer();
    }
}