import java.util.Scanner;
import java.util.Vector;

public class Bibliotheque {
    Vector<Abonne> abonnes = new Vector<Abonne>();
    Vector<Administrateur> admins = new Vector<Administrateur>();
    Vector<Agent> agents = new Vector<Agent>();
    Vector<Livre> livres = new Vector<Livre>();
    Vector<Abonne> Fileattente = new Vector<Abonne>();
    Scanner scanner = new Scanner(System.in);

    public int rechercherlivre() {
        System.out.println("Comment vous voulez rechercher le livre (categorie/titre) ? ");
        String R = scanner.next();
        switch (R) {
            case "categorie":
                System.out.println("Donner la categorie : ");
                R = scanner.next();
                for (int i = 0; i < livres.size(); i++) {
                    if (livres.get(i).getCategorie().equalsIgnoreCase(R)) {
                        System.out.println("il existe un livre avec la categorie que vous avez mentionner dans le " + (i + 1) + " etagere");
                        return i;
                    }
                }
                System.out.println("la categorie que vous avez mentionne n'existe pas dans la bibliotheque");
                break;
            case "titre":
                System.out.println("Donner le titre : ");
                R = scanner.next();
                for (int i = 0; i < livres.size(); i++) {
                    if (livres.get(i).getTitre().equalsIgnoreCase(R)) {
                        System.out.println("le titre existe dans le " + (i + 1) + " etagere");
                        return i;
                    }
                }
                System.out.println("le titre de livre n'existe pas dans la bibliotheque ");
                break;
            default:
                System.out.println("l'option de recherche n'existe pas ");
                break;
        }
        return -1;
    }

    public void emprunt(Abonne abonne, Agent agent) {
        System.out.println("Monsieur " + abonne.getNom() + abonne.getPrenom() + " donnez le nombre de livres que voulez emprunté : ");
        int p = scanner.nextInt();
        Vector<Integer> indices = new Vector<Integer>();
        for (int i = 0; i < p; i++) {
            int k = this.rechercherlivre();
            if (k!=-1)
            {
                indices.add(i);
            }
             }
            abonne.setMax_livres_emp(p);
            boolean t = agent.traiterdemande(abonne,indices,livres);
        }
    }
