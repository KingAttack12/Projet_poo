public class Tarification {
    private double prixJournalierBase; // variable qui stocke le prix
    
    // Constructeur pour définir le prix de départ
    public Tarification(double prixInitial) { // on reçoit un prix de départ
        this.prixJournalierBase = prixInitial; // on enregistre ce prix 
    }
    
    public void modifierPrixBase(double nouveauPrix) { // on reçoit un nouveau prix
        this.prixJournalierBase = nouveauPrix; // on remplace l'ancien prix par le nouveau prix
        System.out.println("Le nouveau prix de base est de : " + this.prixJournalierBase + " euro"); // on l'affiche à l'écran
    }

    // Méthode pour calculer le prix selon la durée (utilisée par le Contrat)
    public double calculerTarifBase(int nbJours) { // on a un nombre de jours
        return this.prixJournalierBase * nbJours; // on fait la multiplication et on donne le résultat
    }

    // Méthode pour lire le prix
    public double getPrixJournalierBase() { // on demande le prix actuel
        return prixJournalierBase; // on répond la valeur qui est stockée en mémoire
    }
}