public class Modele {
    private String nom_modele;
    private String motorisation;
    private String nom_marque;
    private String paysOrigine;

    public Modele(String nom_modele, String motorisation, String nom_marque, String paysOrigine) {
        this.nom_modele = nom_modele;
        this.motorisation = motorisation;
        this.nom_marque = nom_marque;
        this.paysOrigine = paysOrigine;
    }

    public String getNom_modele() {
        return nom_modele;
    }

    public String getMotorisation() {
        return motorisation;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }
}