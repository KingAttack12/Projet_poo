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
        for (Scooter s : listeScooters) {
            if (s.getId().equals(id)) {
                return s; // Scooter trouvé
            }
        }
        return null; // Scooter non trouvé
    }

    public List<Scooter> getListeScooters() {
        return listeScooters;
    }
}