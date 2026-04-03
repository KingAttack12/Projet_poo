public class Login {
    private String nomUtilisateur;
    private String mot_de_passe;
    
    public Login(String id, String mdp) {
        this.nomUtilisateur = id;
        this.mot_de_passe = mdp;
    }

    public boolean verifierConnexion(String id, String mdp) {
        // si le mot de passe et l'identifié donné sont correct, alors l'accès est autorisé
        // sinon, le système refuse l'accès et reviens au départ
        if (this.id.equals(id) && this.mdp.equals(mdp)) {
            System.out.print("Accès autorisé");
            return true;
        }
        else {
            System.out.print("Accès non autorisé");
            return false;
        }
        }
    }

    public void changerMotDePasse(String nouveauMdp) {
        // on change le mot de passe pour un nouveau
        this.mot_de_passe = nouveauMdp;
        System.out.print("Le mot de passe a été modifié");
    }
}