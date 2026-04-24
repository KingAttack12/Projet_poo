import java.util.ArrayList;
import java.util.List;

public class Parc {
    // Le losange d'agrégation de l'UML se traduit par une Liste
    private List<Scooter> listeScooters; // cest la liste de tous les scooters


    public Parc() {
        this.listeScooters = new ArrayList<>(); // on initialise une liste vide 
    }

    public void ajouterScooter(Scooter s) { // on reçoit un objet scooter
        this.listeScooters.add(s); // on l'ajoute dans la liste
    }

    public Scooter chercherScooter(String id) { // on reçoit l'identifiant à chercher 
        for (Scooter s : listeScooters) { // on met une boucle pour chaque scooter de la liste
            if (s.getId().equals(id)) { // si son id est identique à celui recherché
                return s; // on arrête la recherche, on a trouvé le scooter et on le donne 
            }
        }
        return null; // si à la fin de la boucle, on n'a trouvé aucun scooter, on renvoie une valeur nulle
    }

    public List<Scooter> getListeScooters() {
        return listeScooters; // on renvoie les données de tous les scooters
    }
}