public class Scooter {
    	private String id;
    	private double kilometrage;
    	private boolean estDisponible;
    	private Modele modele; 
    
    	public Scooter(String id, double kilometrage, Modele modele) {
        	this.id = id;
        	this.kilometrage = kilometrage;
        	this.estDisponible = true; // disponible par défaut
        	this.modele = modele;
    	}
    
    	public void louer() {
        	this.estDisponible = false;
    	}
    
    	public void retour(double kmParcourus) {
        	this.estDisponible = true;
        	this.kilometrage += kmParcourus;
    	}

    	public String getId() {
        	return id;
    	}

    	public double getKilometrage() {
        	return kilometrage;
    	}

    	public boolean isEstDisponible() {
        	return estDisponible;
    	}

    	public Modele getModele() {
        	return modele;
    	}
}