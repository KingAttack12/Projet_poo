import java.util.Date;

public class Contrat { // permet d'obtenir les données du contrat
    private String idContrat;
    private Date dateDebut;
    private Date dateFinPrevue;
    private Date dateFinReelle;
    private double montantTotal;
    private double joursDeRetard;
    private double penaliteParJour;
    
    // Les liaisons UML
    private Client client; // vient de la classe client
    private Scooter scooter; // vient de la classe scooter
    private Tarification tarification; // vient de la classe tarification

    //Constructeur pouvant crée un contrat
    public Contrat(String idContrat, Client client, Scooter scooter, Tarification tarif, Date dateFinPrevue) {
        this.idContrat = idContrat;
        this.client = client;
        this.scooter = scooter;
        this.tarification = tarif;
        this.dateFinPrevue = dateFinPrevue;
        this.dateDebut = new Date();
    }

    public double calculerPrixEstime() {
        if (this.dateDebut == null || this.dateFinPrevue == null) {
            return 0.0; 
        }
        // on calcule la différence de temps en milisecondes
        long differenceEnMillisecondes = this.dateFinPrevue.getTime() - this.dateDebut.getTime();

        // on convertit les milisecondes en jours (arrondir vers le haut)
        int nombreDeJours = (int) Math.ceil(differenceEnMillisecondes / (1000.0 * 60 * 60 * 24));

        if (nombreDeJours == 0) {
            nombreDeJours = 1;
        } // minimum un jour de facturé
        //reduc de 20% sur les VIP
        double Prixfinal = this.tarification.calculerTarifBase(nombreDeJours);
        if(this.client.getHabitude() != null && this.client.getHabitude().toString().equals("VIP")){ //si le client a des habitudes et que c'est un VIP
            Prixfinal = Prixfinal * 0.80;
        }
        return Prixfinal; // on retourne les résultats des calculs
    }

    public void cloturerContrat(double kmAjoutes) {
        //defini la date de fin comme la date à l'instant de la cloture
        this.dateFinReelle = new Date();
        // Calcul des jours de retard
        double diff = this.dateFinReelle.getTime() - this.dateFinPrevue.getTime();
        this.joursDeRetard = (diff / (1000L * 60 * 60 * 24)); // converti en jours
        if (this.joursDeRetard < 0) this.joursDeRetard = 0; // si on le rend plus tot que prevu, aucune penalité ne sera prise en compte
        this.penaliteParJour = 10.0; // initialialise le montant de la pénalité
        // Calcul du montant total
        this.montantTotal = calculerPrixEstime() + calculerMontantPenalite(); //prix de base + montant de la pénalité
        this.scooter.retour(kmAjoutes); // retourner le scooter et incrementer le nombre de km parcouru
    }
    
    public double calculerMontantPenalite() {
        return this.joursDeRetard * this.penaliteParJour;
    }

    public String editerFacture() { // on fait un texte récapitulatif
        return "Facture pour le contrat " + idContrat + "\n- Montant : " + String.format("%.2f", montantTotal) + " euro" + "\nPour :" + client.getInfosClient() + "\nDate de fin réelle : " + dateFinReelle;
    }
    public Scooter getScooter(){
        return scooter;
    }

    public Date getDateFinReelle(){
        return dateFinReelle;
    }
}