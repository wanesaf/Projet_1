import java.util.Vector;
import java.util.Scanner;

public class Main {
    static int jour_actuel = 1;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //Creation de la bibliotheque
        Bibliotheque bibliotheque = new Bibliotheque();
        //Creation des abonnes
        Abonne abonne1 = new Abonne("Souhil", "Safwane", "25121231", false);
        Abonne abonne2 = new Abonne("Ahmed", "Ahmed", "31651651651", true);
        Abonne abonne3 = new Abonne("Sami", "karim", "487946131", true);
        Abonne abonne4 = new Abonne("riyad", "kadiri", "787894865", true);
        Abonne abonne5 = new Abonne("wassim", "zakari", "48985220", false);
       // Abonne abonne6 = new Abonne("dela3a","pin","54566",true);
        

        //Creation des agents
        Agent agent1 = new Agent("Hamidi", "Hamid", "100000");
        //Creation d'un admin
        Administrateur admin = new Administrateur("Bayazid", "karim", "000005");
        //l'ajout d'agent a la base de donnes de la bibliotheque
        admin.add_agent(agent1, bibliotheque.agents);
        //l'ajout des utilisateur a la base de données de la bibliotheque
        agent1.add_utilisateur(abonne1, bibliotheque.abonnes);
        agent1.add_utilisateur(abonne1, bibliotheque.abonnes);//pour vérifier si on peut ajouter le meme utilisateur deux fois

        agent1.add_utilisateur(abonne2, bibliotheque.abonnes);
        agent1.add_utilisateur(abonne3, bibliotheque.abonnes);
        agent1.add_utilisateur(abonne4, bibliotheque.abonnes);
        agent1.add_utilisateur(abonne5, bibliotheque.abonnes);

        //Creation des livres
        System.out.println("Donner le nombre de livres que vous voulez créer :");
        int nblivres = sc.nextInt();
        for (int i = 0; i < nblivres; i++) {
            System.out.println("Donner le titre de livre : ");
            String titre = sc.next();
            System.out.println("Donner la categorie de livre (Respectez le format de mot trouvé dans le fichier enum Categorie svp) :");
            String categorie = sc.next();
            System.out.println("Donner le nombre d'exemplaires de livres");
            int nbexemplaire = sc.nextInt();
            Vector<Exemplaire> exemplaires = new Vector<Exemplaire>();
            for (int j = 0; j < nbexemplaire; j++) {
                //logiquement qu'on on crée un exemplaire il va etre disponible donc je vais faire true pour le statut(existe)
                Exemplaire exemplaire = new Exemplaire(true, titre);
                exemplaires.add(exemplaire);
            }
            Exemplaire.initialiser();
            Vector<String> auteurs = new Vector<String>();
            System.out.println("Donner le nombre d'auteurs");
            int nbauteurs = sc.nextInt();
            for (int k = 0; k < nbauteurs; k++) {
                System.out.println("Donner le nom complet de l'auteur");
                String nom = sc.next();
                auteurs.add(nom);
            }
            Livre livre = new Livre(titre, auteurs, exemplaires, categorie);
            bibliotheque.livres.add(livre);
        }
        //l'affichage de livres disponblies dans la bibliotheque avec ses exemplaires
        for (int i = 0; i < bibliotheque.livres.size(); i++) {
            System.out.println();
            System.out.println("le " + (i + 1) + " livre disponible dans la bibliotheque: \n" + bibliotheque.livres.get(i).toString());
            for (int j = 0; j < bibliotheque.livres.get(i).getExemplaires().size(); j++) {
                System.out.println(bibliotheque.livres.get(i).getExemplaires().get(j).toString());
            }
        }
        //la fonction rechercher
        //par titre
        bibliotheque.rechercherlivre();
        //par catégorie
        bibliotheque.rechercherlivre();

        agent1.ajouterFIleattente(abonne1, bibliotheque.Fileattente);
        agent1.ajouterFIleattente(abonne2, bibliotheque.Fileattente);
        agent1.ajouterFIleattente(abonne3, bibliotheque.Fileattente);
        agent1.ajouterFIleattente(abonne4, bibliotheque.Fileattente);
        agent1.ajouterFIleattente(abonne5, bibliotheque.Fileattente);

        // Supposon que les abonnes ont retourné les livres dans la fois passé aprés ces jours
        abonne1.setJour_retour(16);
        abonne2.setJour_retour(31);
        abonne3.setJour_retour(25);
        abonne4.setJour_retour(11);
        abonne5.setJour_retour(37);
        agent1.traiterFIleattente(bibliotheque.Fileattente, bibliotheque);

        //l'affichage des exemplaires aprés l'emprunt (les  exemplaires empruntés seront indisponibles)
        for (int i = 0; i < bibliotheque.livres.size(); i++) {
            System.out.println();
            System.out.println("le " + (i + 1) + " livre disponible dans la bibliotheque: \n" + bibliotheque.livres.get(i).toString());
            for (int j = 0; j < bibliotheque.livres.get(i).getExemplaires().size(); j++) {
                System.out.println(bibliotheque.livres.get(i).getExemplaires().get(j).toString());
            }
        }
        agent1.AffichageAmendeFinJournee(bibliotheque.Fileattente);
        System.out.println("C'est la fin de la journée");
        jour_actuel++;
    }
}
