import java.util.Scanner;

public class Logiciel {
    private Statistiques gestionnaire;

    public Logiciel() {
        this.gestionnaire = new Statistiques();
    }

    public void afficherMenu() {
        System.out.println("\n========== SCOOT ==========");
        System.out.println("1. Louer un scooter");
        System.out.println("2. Retour d'un scooter");
        System.out.println("3. État d'un scooter");
        System.out.println("4. Affichage de l'état du parc");
        System.out.println("5. Saisie du parc des scooters");
        System.out.println("6. Statistiques");
        System.out.println("7. Modifier le prix de base");
        System.out.println("8. Saisie de clients");
        System.out.println("9. Quitter le programme");
        System.out.println("============================");
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
                    System.out.println("\n--- LOCATION ---");
                    System.out.print("ID du scooter (ex: S001) : ");
                    String idloc = scanner.nextLine();
                    System.out.print("ID du client : ");
                    int idcli = scanner.nextInt();
                    System.out.print("Durée de la location (en jours) : ");
                    int nombreJours = scanner.nextInt();
                    scanner.nextLine();
                    gestionnaire.traiterLocation(idloc, idcli, nombreJours);
                    System.out.println(">> Location effectuée!");
                    break;
                case 2:
                    System.out.println("\n--- RETOUR ---");
                    System.out.print("ID du scooter : ");
                    String idRetour = scanner.nextLine();
                    System.out.print("Kilomètres parcourus : ");
                    double kmFaits = scanner.nextDouble();
                    scanner.nextLine();
                    gestionnaire.traiterRetour(idRetour, kmFaits);
                    System.out.println(">> Retour enregistré!");
                    break;
                case 3:
                    System.out.println("\n--- ÉTAT DU SCOOTER ---");
                    System.out.print("ID du scooter : ");
                    gestionnaire.afficherEtatScooter(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("\n=== ÉTAT DU PARC ===");
                    gestionnaire.afficherParc();
                    break;
                case 5:
                    System.out.println("\n--- CRÉATION SCOOTERS ---");
                    System.out.print("Nombre de scooters : ");
                    int nb = scanner.nextInt();
                    scanner.nextLine();
                    for(int i=0; i<nb; i++){
                        System.out.println("\nScooter " + (i+1) + "/" + nb + " :");
                        System.out.print("ID (ex: S001) : ");
                        String id = scanner.nextLine();
                        System.out.print("Kilométrage : ");
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
                    System.out.println(">> " + nb + " scooter(s) créé(s)!");
                    break;
                case 6:
                    System.out.println("\n=== STATISTIQUES ===");
                    Client meilleurClient = gestionnaire.TopClient(gestionnaire.getListeClients());
                    if (meilleurClient == null) {
                        System.out.println("Aucun client disponible.");
                    } else {
                        System.out.println("Meilleur client : " + meilleurClient.getInfosClient());
                        System.out.println("Dépense totale : " + meilleurClient.getHabitude().getTotalDepense() + "euro");
                    }
                    System.out.println("-------------------");
                    Double ChiffreAffaire = gestionnaire.calculerChiffreAffaireTotal(gestionnaire.getListeClients());
                    System.out.println("Chiffre d'affaires : " + ChiffreAffaire + "euro");
                    break;
                case 9:
                    System.out.println("\n=== AU REVOIR ===");
                    System.out.println("Merci d'avoir utilisé SCOOT!");
                    break;
                case 7:
                    System.out.println("\n--- MODIFICATION TARIF ---");
                    System.out.print("Nouveau tarif (euro) : ");
                    double tarif = scanner.nextDouble();
                    scanner.nextLine();
                    gestionnaire.modifierPrixBase(tarif);
                    break;
                case 8:
                    System.out.println("\n--- CRÉATION CLIENTS ---");
                    System.out.print("Nombre de clients : ");
                    int cb = scanner.nextInt();
                    scanner.nextLine();
                    for(int i=0; i<cb; i++){
                        System.out.println("\nClient " + (i+1) + "/" + cb + " :");
                        System.out.print("ID : ");
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
                    System.out.println(">> " + cb + " client(s) créé(s)!");
                    break;
                default:
                    System.out.println(">> Choix invalide!");
                    break;
            
            }
        }while(choix != 9);
            scanner.close();
        
    }

    public static void main(String[] args){
        System.out.println("\n===== SCOOT - Gestion de Location =====");
        Logiciel appl = new Logiciel();
        appl.lancer();
    }
}
