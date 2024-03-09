import java.util.Vector;
public class Exemplaire {
    private String idex;
    private boolean statut ;
    static int numero ;
    public Exemplaire(boolean statut,String numlivre) {
        numero ++ ;
        this.statut = statut;
      idex =Generate.genererIDexemplaire(numero,numlivre);
    }
    public String getIdex() {
        return idex;
    }
    public boolean getStatut() {
        return statut;
    }
    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public static void initialiser ()
    {
        numero = 0 ;
    }
    @Override
    public String toString ()
    {
        if (statut)
        return idex+","+"disponible";
        else
        {
            return idex+","+"non disponible";
        }
    }
}
