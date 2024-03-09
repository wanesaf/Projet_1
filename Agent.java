import java.util.Vector;

public class Agent extends Personnel {
    public final int Fine_delay_regular_user = 300;
    public final int Fine_delay_VIP_user = 600;

    public Agent(String nom, String prenom, String id) {
        super(nom, prenom, id);
    }

    public boolean traiterdemande(Abonne abonne, Vector<Integer> indices, Vector<Livre> livres) {
        System.out.println("traite de la demande de l'emprunt en cours....");
        if (abonne.getVIP()) {
            if (abonne.getJour_retour() <= 30 && abonne.getMax_livres_emp() <= 5) {
                System.out.println("Vous pouvez emprunté les livres");
                for (int k : indices) {
                    livres.get(k).getExemplaires().get(1).setStatut(false);
                }
                return true;
            } else if (abonne.getJour_retour() > 30) {
                System.out.println("échec de l'emprunt,période d'emprunt expiré , payez l'amende aprés faire une autre demande d'emprunt");
                return false;
            } else {
                System.out.print("échec de l'emprunt,le plan VIP offre seulement 5 livres par mois");
                return false;
            }
        } else {
            if (abonne.getJour_retour() <= 14 && abonne.getMax_livres_emp() <= 2) {
                System.out.println("Vous pouvez emprunté les livres");
                for (int k : indices) {
                    livres.get(k).getExemplaires().get(0).setStatut(false);
                }
                return true;
            } else if (abonne.getJour_retour() > 14) {
                System.out.println("échec de l'emprunt,période d'emprunt expiré,payez l'amende aprés faire une autre demande d'emprunt");
                return false;
            } else {
                System.out.print("échec de l'emprunt,le plan régulier offre seulement 2 livres par 2 semaines");
                return false;
            }
        }

    }

    public void calculjourretard(Abonne abonne) {
        int k;
        if (abonne.getVIP()) {
            if (abonne.getJour_retour() > 30) {
                k = abonne.getJour_retour() - 30;
                abonne.setJour_retard(k);
            } else {
                abonne.setJour_retour(0);
            }
        } else {
            if (abonne.getJour_retour() > 14) {
                k = abonne.getJour_retour() - 14;
                abonne.setJour_retard(k);
            } else {
                abonne.setJour_retour(0);
            }
        }
    }

    public int calculamende(Abonne abonne) {
        if (abonne.getJour_retard() > 0) {
            if (abonne.getVIP()) {
                return abonne.getJour_retard() * Fine_delay_VIP_user;
            } else {
                return abonne.getJour_retard() * Fine_delay_regular_user;
            }
        }
        return 0;
    }

    public void add_utilisateur(Abonne abonne, Vector<Abonne> abonnes) {
        for (Abonne value : abonnes) {
            if (value.getId().equals(abonne.getId())) {
                System.out.println("Impossible d'ajouter l'utilisateur , il existe deja");
                return;
            }
        }
        abonnes.add(abonne);
        System.out.println("l'utilisateur est ajouté avec succés");
    }

    public void ajouterFIleattente(Abonne abonne, Vector<Abonne> Fileattente) {
        add_utilisateur(abonne, Fileattente);
    }
    public void traiterFIleattente(Vector<Abonne> Fileattente, Bibliotheque bibliotheque) {
        for (Abonne abonne : Fileattente) {
            bibliotheque.emprunt(abonne, this);
        }
    }
    public void AffichageAmendeFinJournee(Vector<Abonne> FileAttente) {
        System.out.println("************AFFICHAGE AMENDES POUR LES RETARDATAIRES***********\n");
        for (Abonne abonne : FileAttente) {
            this.calculjourretard(abonne);
            if (abonne.getJour_retard() > 0) {
                System.out.println("l'amende que " + abonne.getNom() + abonne.getPrenom() + " doit payer égale a " + this.calculamende(abonne));
            }
        }
    }

}

