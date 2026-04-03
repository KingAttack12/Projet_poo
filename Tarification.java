public class Tarification {
    private double prixJournalierBase;
    
    // Constructeur pour définir le prix de départ
    public Tarification(double prixInitial) {
        this.prixJournalierBase = prixInitial;
    }
    
    public void modifierPrixBase(double nouveauPrix) {
        this.prixJournalierBase = nouveauPrix;
        System.out.println("Le nouveau prix de base est de : " + this.prixJournalierBase + "€");
    }

    // Méthode pour calculer le prix selon la durée (utilisée par le Contrat)
    public double calculerTarifBase(int nbJours) {
        return this.prixJournalierBase * nbJours;
    }

    public double getPrixJournalierBase() {
        return prixJournalierBase;
    }
}