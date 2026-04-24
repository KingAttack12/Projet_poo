public class HabitudeClient {
    private int nbLocationsTotales; // compteur du nombre de locations
    private double totalDepense; // somme totale dépensée par le client
    private String categorieClient; // statut du client

    public HabitudeClient(int nblocation, double total) {
        this.nbLocationsTotales = nblocation; // on définit le nombre de locations au départ
        this.totalDepense = total; // on définit le montant déjà dépensé par le client
        actualiserCategorie(); // on n'impose pas une catégorie mais on vérifie si le client répond aux conditions
    }

    public void incrementerLocations() {
        this.nbLocationsTotales++; // on augmente de nombre de location du client à chaque contrat signé par lui 
        actualiserCategorie(); // on fait +1 au compteur de locations et on vérifie si ce +1 le fait passer en VIP
    }

    public void ajouterDepense(double montant) {
        if (montant > 0) { // on ne peut ajouter que des montants positifs
            this.totalDepense += montant; // on ajoute la somme totale
            actualiserCategorie(); // on regarde si le nouveau total fait passer le client en VIP
        }
    }

    private void actualiserCategorie() {
        if (nbLocationsTotales > 10 || totalDepense > 1000) this.categorieClient = "VIP";
        // si le nombre de locations du client est supérieur à dix ou que le montant dépensé est supérieur à mille euros, alors le client est catégorisé comme VIP
        else this.categorieClient = "Standard";
        // sinon, il est considéré comme un client standard
    }

    public int getNbLocationsTotales() {
        return nbLocationsTotales; // connaître le nombre de locations
    }

    public double getTotalDepense() {
        return totalDepense; // connaître le montant raporté par le client
    }

    public String toString() {
        return categorieClient; // affiche la catégorie du client
    }
}