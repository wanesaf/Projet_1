import java.util.Vector;

public class Administrateur extends Personnel {
    public Administrateur(String nom, String prenom, String id) {
        super(nom, prenom, id);
    }

    public void add_agent (Agent agent, Vector<Agent> agents)
    {
        for (int i=0;i<agents.size();i++)
        {
            if (agents.get(i).getId().equals(agent.getId()))//l'ajout se fait par ID car il est unique
            {
                System.out.println("Impossible d'ajouter l'agent , il existe deja");
                return;
            }
        }
        agents.add(agent);
        System.out.println("l'agent est ajouté avec succés");
    }
}
