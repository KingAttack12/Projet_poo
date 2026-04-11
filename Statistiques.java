import java.util.List;

public class Statistiques extends Gestion {

    public double calculerChiffreAffaireMois() {
        return 0.0;
    }

    public double TauxOccupation() {
        return 0.0;
    }

    public Client TopClient(List<Client> listeClients) {
        if (listeClients == null || listeClients.isEmpty()) {
            return null;
        }
        Client meilleurClient = null;
        for (Client c : listeClients) {
            if (c == null || c.getHabitude() == null) {
                continue;
            }

            if (meilleurClient == null || c.getHabitude().getTotalDepense() > meilleurClient.getHabitude().getTotalDepense()) {
                meilleurClient = c;
            }
        }
        return meilleurClient;
    }
}
