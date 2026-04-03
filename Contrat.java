import java.util.Date;

public class Contrat {
    private String idContrat;
    private Date dateDebut;
    private Date dateFinPrevue;
    private Date dateFinReelle;
    private double montantTotal;
    private int joursDeRetard;
    private double penaliteParJour;
    
    // Les liaisons UML
    private Client client;
    private Scooter scooter;
    private Tarification tarification;

    public Contrat(String idContrat, Client client, Scooter scooter, Tarification tarif, Date dateFinReelle) {
        this.idContrat = idContrat;
        this.client = client;
        this.scooter = scooter;
        this.tarification = tarif;
        this.dateDebut = new Date(); // Date du jour
        this.dateFinReelle = new Date();
    }

    public double calculerPrixEstime() {
        if (this.dateDebut == null || this.dateFinPrevue == null) {
            return 0.0; 
        }

        long differenceEnMillisecondes = this.dateFinPrevue.getTime() - this.dateDebut.getTime();


        int nombreDeJours = (int) (differenceEnMillisecondes / (1000 * 60 * 60 * 24));

        if (nombreDeJours == 0) {
            nombreDeJours = 1;
        }

        return this.tarification.calculerTarifBase(nombreDeJours);
    }

    public void cloturerContrat(double kmAjoutes) {
        this.dateFinReelle = new Date();
        this.scooter.retour(kmAjoutes); // On libère le scooter et on met à jour son compteur !
    }
    
    public double calculerMontantPenalite() {
        return this.joursDeRetard * this.penaliteParJour;
    }

    public String editerFacture() {
        return "Facture pour le contrat " + idContrat + " - Montant : " + montantTotal + "€" + "Pour" + client + "Date de fin réelle" + dateFinReelle;
    }
}