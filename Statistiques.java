import java.util.List;

public class Statistiques extends Gestion {

    // Méthode pour calculer la somme totale du chiffre d'affaire
    public double calculerChiffreAffaireTotal(List<Client> listeClients) { // on prend une liste de clients
        if (listeClients == null || listeClients.isEmpty()) { // si la liste n'existe pas ou est vide
            return 0; // on renvoie une valeur nulle
        }
        double resultat=0; // on a un compteur qui commence à zéro
        for(Client c : listeClients){ // pour chaque client présent dans la liste
            resultat+= c.getHabitude().getTotalDepense(); // on ajoute les dépenses de chaque client au compteur total
        }
        return resultat; // on obtient la somme de toutes les dépenses
    }

    // Méthode pour trouver le meilleur client
    public Client TopClient(List<Client> listeClients) { // on renvoie un objet client
        if (listeClients == null || listeClients.isEmpty()) { // si la liste est vide
            return null; // on renvoie une valeur nulle
        }
        Client meilleurClient = null; // on créer une classe vide pour pouvoir stocker le gagnant
        for (Client c : listeClients) { // on regarde chaque client de la liste
            if (c == null || c.getHabitude() == null) { // si certaines données du client manquent
                continue; // on passe au client suivant
            }

            // si on n'a pas encore de gagant, ou que le client actuel a dépensé plus que le gagant actuel
            if (meilleurClient == null || c.getHabitude().getTotalDepense() > meilleurClient.getHabitude().getTotalDepense()) {
                meilleurClient = c; // le client actuel devient le meilleur client (le gagant)
            }
        }
        return meilleurClient; // on renvoie le client qui a dépensé le plus d'argent 
    }
    //public Scooter Topkmscooter(List<Scooter> listeScooters){
        //if (listeScooters == null || listeScooters.isEmpty()) { // si la liste est vide
            //return null; // on renvoie une valeur nulle
        //}
        //Scooter topScooter = null;
        //for (Scooter s : listeScooters) {
            //s.getKilometrage()
        //}
    //}
}
