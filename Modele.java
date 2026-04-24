public class Modele {
    private String nom_modele;
    private String motorisation;
    private String nom_marque;
    private String paysOrigine;

    // on fait la "fiche technique" du scooter
    // on enregistre les différentes informations
    public Modele(String nom_modele, String motorisation, String nom_marque, String paysOrigine) {
        this.nom_modele = nom_modele;
        this.motorisation = motorisation;
        this.nom_marque = nom_marque;
        this.paysOrigine = paysOrigine;
    }

    public String getNom_modele() {
        return nom_modele; // donne le nom du modèle
    }

    public String getMotorisation() {
        return motorisation; // donne le type de moteur
    }

    public String getNom_marque() {
        return nom_marque; // donne le nom de la marque 
    }

    public String getPaysOrigine() {
        return paysOrigine; // donne le pays d'origine
    }
}