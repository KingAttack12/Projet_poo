public class HabitudeClient {
    private int nbLocationsTotales;
    private double totalDepense;
    private String categorieClient;

    public HabitudeClient(int nblocation, double total) {
        this.nbLocationsTotales = nblocation;
        this.totalDepense = total;
        actualiserCategorie();
    }

    public void incrementerLocations() {
        this.nbLocationsTotales++; // on augmente de nombre de location du client à chaque contrat signé par lui 
        actualiserCategorie();
    }

    public void ajouterDepense(double montant) {
        if (montant > 0) {
            this.totalDepense += montant;
            actualiserCategorie();
        }
    }

    private void actualiserCategorie() {
        if (nbLocationsTotales > 10 || totalDepense > 1000) this.categorieClient = "VIP";
        // si le nombre de locations du client est supérieur à dix ou que le montant dépensé est supérieur à mille euros, alors le client est catégorisé comme VIP
        else this.categorieClient = "Standard";
        // sinon, il est considéré comme un client standard
    }

    public int getNbLocationsTotales() {
        return nbLocationsTotales;
    }

    public double getTotalDepense() {
        return totalDepense;
    }

    public String toString() {
        return categorieClient; 
    }
}