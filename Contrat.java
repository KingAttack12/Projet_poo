import java.util.Date;

public class Contrat { // permet d'obtenir les données du contrat
    private String idContrat;
    private Date dateDebut;
    private Date dateFinPrevue;
    private Date dateFinReelle;
    private double montantTotal;
    private int joursDeRetard;
    private double penaliteParJour;
    
    // Les liaisons UML
    private Client client; // vient de la classe client
    private Scooter scooter; // vient de la classe scooter
    private Tarification tarification; // vient de la classe tarification

    public Contrat(String idContrat, Client client, Scooter scooter, Tarification tarif, Date dateFinPrevue) {
        this.idContrat = idContrat;
        this.client = client;
        this.scooter = scooter;
        this.tarification = tarif;
        this.dateFinPrevue = dateFinPrevue;
        this.dateDebut = new Date(); // Date du jour enregistrée
    }

    public double calculerPrixEstime() {
        if (this.dateDebut == null || this.dateFinPrevue == null) {
            return 0.0; 
        }
        // on calcule la différence de temps en milisecondes
        long differenceEnMillisecondes = this.dateFinPrevue.getTime() - this.dateDebut.getTime();

        // on convertit les milisecondes en jours
        int nombreDeJours = (int) (differenceEnMillisecondes / (1000 * 60 * 60 * 24));

        if (nombreDeJours == 0) {
            nombreDeJours = 1;
        } // minimum un jour de facturé
        //reduc de 20% sur les VIP
        double Prixfinal = this.tarification.calculerTarifBase(nombreDeJours);
        if(this.client.getHabitude() != null && this.client.getHabitude().toString().equals("VIP")){
            Prixfinal = Prixfinal * 0.80;
        }
        return Prixfinal; // on retourne les résultats des calculs
    }

    public void cloturerContrat(double kmAjoutes) {
        this.dateFinReelle = new Date(); // on note la date de retour
        this.montantTotal = calculerPrixEstime() + calculerMontantPenalite();
        this.scooter.retour(kmAjoutes); // On libère le scooter et on met à jour son compteur
    }
    
    public double calculerMontantPenalite() {
        return this.joursDeRetard * this.penaliteParJour;
    }

    public String editerFacture() { // on fait un texte récapitulatif
        return "Facture pour le contrat " + idContrat + "\n- Montant : " + montantTotal + " euro" + "\nPour :" + client.getInfosClient() + "\nDate de fin réelle : " + dateFinReelle;
    }
    public Scooter getScooter(){
        return scooter;
    }

    public Date getDateFinReelle(){
        return dateFinReelle;
    }
}