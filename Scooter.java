public class Scooter {
    private String id;
    private double kilometrage;
    private boolean estDisponible;
    private Modele modele; // référence à la classe modèle
    
    
    // Méthode pour créer un nouveau scooter 
    public Scooter(String id, double kilometrage, Modele modele) {
        this.id = id; // on enregristre les différente données
        this.kilometrage = kilometrage;
        this.estDisponible = true; // disponible par défaut
        this.modele = modele;
    }
    
    public void louer() { // quand on loue le scooter
        this.estDisponible = false; // il n'est plus disponible
    }
    
    public void retour(double kmParcourus) { // quand on a de nouveau le scooter
        this.estDisponible = true; // il redevient disponible
        this.kilometrage += kmParcourus; // on rajoute les kilomètres parcourus
    }

    public String getId() {
        return id; // donne l'id du scooter
    }

    public double getKilometrage() {
        return kilometrage; // donne le kilométrage actuel
    }

    public boolean isEstDisponible() {
        return estDisponible; // donne si le scooter est libre
    }

    public Modele getModele() {
        return modele; // donne les détails du modèle
    }
}