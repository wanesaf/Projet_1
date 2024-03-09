public   abstract class   Personnel extends Personne {
    protected String id;

    public Personnel(String nom, String prenom, String id) {
        super(nom, prenom);
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}

