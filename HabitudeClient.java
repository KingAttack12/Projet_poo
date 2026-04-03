public class HabitudeClient {
    private int nbLocationsTotales;
    private double totalDepense;
    private String categorieClient;

    public void incrementerLocations() {
        this.nbLocationsTotales++; // on regarde 
    }

    public void actualiserCategorie() {
        if (nbLocationsTotales > 10) this.categorieClient = "VIP";
        else this.categorieClient = "Standard";
    }

}
