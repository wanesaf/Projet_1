import java.util.Vector;

public class Livre  {
    String id ;
    static int numerolivre ;

    static int numerocategorie ;
    private String titre;
    private Vector<String> auteurs;
    private String categorie ;
    private Vector<Exemplaire> exemplaires ;
    public Livre(String titre, Vector<String> auteurs,Vector<Exemplaire> exemplaires,String categorie) {
        numerolivre ++ ;
        int numcategorie = switch (categorie)
        {
            case "Fiction" -> 1;
            case "Caricature" -> 2;
            case "Biomimo" -> 3;
            case "Religion" -> 4;
            case "Art_photographique" -> 5;
            case "Sante" -> 6;
            case "Histoire" -> 7;
            case "Roman" -> 8;
            default -> 0; // comme il y 'a 8 categories dans la forme est L/numlivre/C/numcategorie<=8
        };
        this.id=Generate.genererIDLivre(numerolivre,numcategorie);
        this.categorie = categorie ;
        this.titre = titre;
        this.auteurs = auteurs;
        this.exemplaires = exemplaires ;
    }
    public Vector<Exemplaire> getExemplaires() {
        return exemplaires;
    }
    public void setExemplaires(Vector<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Vector<String> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(Vector<String> auteurs) {
        this.auteurs = auteurs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString ()
    {
        return id+","+titre+","+auteurs.toString();
    }
}
