public class Statistiques extends Gestion {

    public double calculerChiffreAffaireMois() {
        return 0.0;
    }

    public double TauxOccupation() {
        return 0.0;
    }

    public Client TopClient(List<Client> listeClients) {
        Client meilleurClient = null;
        if (c.isVIP() && c.gettotalDepenses() > 10000) {
            if (meilleurClient == null || c.getDepenses() > meilleurClient.getDepenses()) {
                meilleurClient = c;
            }
        }
        return meilleurClient;
    }
}
