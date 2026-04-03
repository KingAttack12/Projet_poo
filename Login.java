public class Login {
    private String nomUtilisateur;
    private String mot_de_passe;
    
    public Login(String id, String mdp) {
        this.nomUtilisateur = id;
        this.mot_de_passe = mdp;
    }

    public boolean verifierConnexion(String id, String mdp) {
        if (this.id.equals(id) && this.mdp.equals(mdp)) {
            System.out.print("Accès autorisé");
            return true;
        }
    }

    public void changerMotDePasse() {
        
    }
}