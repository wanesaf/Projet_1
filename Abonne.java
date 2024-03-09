import java.util.Vector;

public  class Abonne extends Personne {
    private  String id ;
    private int jour_retour ; // le jour de retourner les livres
    private int jour_retard;
    private boolean VIP ; // vrai si l'utilisateur est un vip , faux sinon
    private int max_livres_emp;
    public Abonne(String nom, String prenom, String id,boolean VIP) {
        super(nom, prenom);
        this.id = id;
        this.VIP = VIP ;
        this.max_livres_emp = 0 ;
    }
    public String getId() {
        return id;
    }

    public boolean getVIP() {
        return VIP;
    }
    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public int getMax_livres_emp() {
        return max_livres_emp;
    }

    public void setMax_livres_emp(int max_livres_emp) {
        this.max_livres_emp = max_livres_emp;
    }

    @Override
    public String toString ()
    {
        if (VIP)
        {
            return nom+","+prenom+","+id+","+"VIP";
        }
        else
        {
            return nom+","+prenom+","+id+","+"Regulier";
        }
    }


    public int getJour_retour() {
        return jour_retour;
    }

    public void setJour_retour(int jour_retour) {
        this.jour_retour = jour_retour;
    }

    public int getJour_retard() {
        return jour_retard;
    }

    public void setJour_retard(int jour_retard) {
        this.jour_retard = jour_retard;
    }

}
