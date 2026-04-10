import java.util.ArrayList;
import java.util.List;

public class Parc {
    // Le losange d'agrégation de l'UML se traduit par une Liste
    private List<Scooter> listeScooters;


    public Parc() {
        this.listeScooters = new ArrayList<>();
    }

    public String compterscooter(List<Scooter> listeScooters){
        System.out.println("Total : "+ listeScooters.size());
        int compteur = 0;
        for (Scooter s : listeScooters) {
            if(s.isEstDisponible()){
                compteur += 1;
            }
        }
        System.out.print("Libre : " + compteur);
    }

    public void ajouterScooter(Scooter s) {
        this.listeScooters.add(s);
    }

    public Scooter chercherScooter(String id) {
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