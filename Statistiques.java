public class Statistiques extends Gestion {

    public double calculerChiffreAffaireMois() {
        return 0.0;
    }

    public double TauxOccupation() {
        return 0.0;
    }

    public Client topClient(List<Client> listeClients){
        Client meilleurClient = null;
    for (Client c : listeClients) {
        if (c.isVIP() && c.getotalDepenses() > 10000) {
            if (meilleurClient == null || c.gettotalDepenses() > meilleurClient.gettotalDepenses()) {
                meilleurClient = c;
            }
        }
    }
    return meilleurClient; 
}
}