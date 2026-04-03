public class HabitudeClient {
    private int nbLocationsTotales;
    private double totalDepense;
    private String categorieClient;

    public void incrementerLocations() {
        this.nbLocationsTotales++; // on augmente de nombre de location du client à chaque contrat signé par lui 
    }

    public void actualiserCategorie() {
        if (nbLocationsTotales > 10 || totalDepense > 1000) this.categorieClient = "VIP";
        // si le nombre de locations du client est supérieur à dix, alors le client est catégorisé comme VIP
        else this.categorieClient = "Standard";
        // sinon, il est considéré comme un client standard
    }

}
