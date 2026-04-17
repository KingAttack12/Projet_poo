import java.util.Scanner;

public class Logiciel {
    private Statistiques gestionnaire;

    public Logiciel() {
        this.gestionnaire = new Statistiques();
    }

    public void afficherMenu() {
        System.out.println("\n----- SCOOT -----");
        System.out.println("1. Louer un scooter");
        System.out.println("2. Retour d'un scooter");
        System.out.println("3. État d'un scooter");
        System.out.println("4. Affichage de l'état du parc de scooters");
        System.out.println("5. Saisie du parc des scooters");
        System.out.println("6. Statistiques");
        System.out.println("7. Quitter le programme");
        System.out.println("8. Modifier le prix de base");
        System.out.println("9. Saisie de clients");
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
                    System.out.print("Donner l'ID du scooter à louer :");
                    String idloc = scanner.nextLine();
                    System.out.print("Donner l'id du client : ");
                    int idcli = scanner.nextInt();
                    scanner.nextLine();
                    gestionnaire.traiterLocation(idloc, idcli);
                    break;
                case 2:
                    System.out.print("Donner l'ID du scooter à retourner : ");;
                    String idRetour = scanner.nextLine();
                    System.out.println("Combien de kilomètres a-t-il parcouru pendant la location ? :");
                    double kmFaits = scanner.nextDouble();
                    scanner.nextLine();
                    gestionnaire.traiterRetour(idRetour, kmFaits);
                    break;
                case 3:
                    System.out.print("Donner l'ID du scooter :");
                    gestionnaire.afficherEtatScooter(scanner.nextLine());
                    break;
                case 4:
                    gestionnaire.afficherParc();
                    break;
                case 5:
                    System.out.print("Combien de scooter voulez vous créer ? : ");
                    int nb = scanner.nextInt();
                    scanner.nextLine(); // consomme le retour à la ligne après l'entier
                    for(int i=0; i<nb; i++){
                        System.out.println("--- Création d'un nouveau scooter ---");
                        System.out.print("\nID du scooter : ");
                        String id = scanner.nextLine();
                        System.out.print("\nKilométrage de départ : ");
                        double KM_init = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Modèle : ");
                        String modele = scanner.nextLine();
                        System.out.print("Motorisation : ");
                        String moteur = scanner.nextLine();
                        System.out.print("Marque : ");
                        String marque = scanner.nextLine();
                        System.out.print("Pays d'origine : ");
                        String pays = scanner.nextLine();
                        gestionnaire.saisirParc2(id, KM_init, modele, moteur, marque, pays);
                    }
                    break;
                case 6:
                    System.out.println("--------------- Statistiques -------------");
                    Client meilleurClient = gestionnaire.TopClient(gestionnaire.getListeClients());
                    if (meilleurClient == null) {
                        System.out.println("Aucun client disponible pour afficher des statistiques.");
                    } else {
                        System.out.println("Meilleur client : " + meilleurClient.getInfosClient());
                        System.out.println("Dépense totale : " + meilleurClient.getHabitude().getTotalDepense() + "euro");
                    }
                    System.out.println("-----------------");
                    Double ChiffreAffaire = gestionnaire.calculerChiffreAffaireTotal(gestionnaire.getListeClients());
                    System.out.println("Chiffre d'affaire global : " + ChiffreAffaire);
                    break;
                case 7:
                    System.out.println("Fermeture du programme !");
                    break;
                case 8:
                    System.out.println("----- Modification tarif -----");
                    System.out.print("Entrer le nouveau tarif : ");
                    double tarif = scanner.nextDouble();
                    scanner.nextLine();
                    gestionnaire.modifierPrixBase(tarif);
                    break;
                case 9:
                    System.out.print("Combien de client voulez vous rentrer ? : ");
                    int cb = scanner.nextInt();
                    scanner.nextLine(); // consomme le retour à la ligne après l'entier
                    for(int i=0; i<cb; i++){
                        System.out.println("--- Saisie du client n°"+(i+1)+" ---");
                        System.out.print("\nID du client : ");
                        int idClient = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nom : ");
                        String nomClient = scanner.nextLine();
                        System.out.print("Prénom : ");
                        String prenomClient = scanner.nextLine();
                        System.out.print("Téléphone : ");
                        String telephone = scanner.nextLine();
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        gestionnaire.saisirClient(nomClient, prenomClient, idClient, telephone, email);
                    }
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            
            }
        }while(choix != 7);
            scanner.close();
        
    }

    public static void main(String[] args){
        Logiciel appl = new Logiciel();
        appl.lancer();
    }
}