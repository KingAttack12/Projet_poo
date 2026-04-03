import java.util.Date;

public class Retard {
    private int joursDeRetard;
    private double penaliteParJour;

    public float calculerMontantPenalite() {
        return joursDeRetard * penaliteParJour;
    }
}
