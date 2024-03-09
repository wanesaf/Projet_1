public class Generate {
    public static String  genererIDLivre (int numLivre,int numbercategorie)
    {
        String id = "";
        id = id.concat("L");
        id = id.concat(String.valueOf(numLivre));
        id = id.concat("C");
        id = id.concat(String.valueOf(numbercategorie));
        return id;
    }

    public static String  genererIDexemplaire(int numExamplaire,String numLivre)
    {
        String id = "";
        id = id.concat("E");
        id = id.concat(String.valueOf(numExamplaire));
        id = id.concat(numLivre);
        return id;
    }
}
