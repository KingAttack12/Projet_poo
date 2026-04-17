import java.util.List;

public class Statistiques extends Gestion {

    public double calculerChiffreAffaireTotal(List<Client> listeClients) {
        if (listeClients == null || listeClients.isEmpty()) {
            return 0;
        }
        double resultat=0;
        for(Client c : listeClients){
            resultat+= c.getHabitude().getTotalDepense();
        }
        return resultat;
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
