package application;

import java.io.*;

public class CreerPattern implements Serializable{
    /**
    * Pattern du niveau un
    */
    private char[][] pattern1;

    /**
    * Pattern du niveau un
    */
    private char[][] pattern2;

    /**
    * Pattern du niveau un
    */
    private char[][] pattern3;

    /**
    * Constructeur prenant 3 tableau de characteres, un par niveau
    * @param p1 premier pattern
    * @param p2 deuxieme pattern
    * @param p3 troisieme pattern
    */
    public CreerPattern(char[][] p1,char[][] p2,char[][] p3){
        this.pattern1=p1;
        this.pattern2=p2;
        this.pattern3=p3;
    }

    /**
    * Stocke les tableau dans des fichiers texte
    */
    public void genererPattern() throws FileNotFoundException,IOException{
        ObjectOutputStream fich1=new ObjectOutputStream(new FileOutputStream("p1.txt"));
        fich1.writeObject(pattern1);
        fich1.close();

        ObjectOutputStream fich2=new ObjectOutputStream(new FileOutputStream("p2.txt"));
        fich2.writeObject(pattern1);
        fich2.close();

        ObjectOutputStream fich3=new ObjectOutputStream(new FileOutputStream("p3.txt"));
        fich3.writeObject(pattern1);
        fich3.close();
    }

    /**
    * Methode principale, lance genererPattern a partir d'un objet cree
    */
    public static void main(String[] args) throws FileNotFoundException,IOException{
        char[][] c1={
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'},
											{'m','s','f','s','m','s','s','s','s','m','m','s','p','s','m'},
											{'m','p','s','s','s','s','s','m','s','s','m','s','m','s','m'},
											{'m','m','m','m','m','s','m','m','m','s','p','s','m','s','m'},
											{'m','m','s','s','s','s','s','m','m','s','s','s','m','s','m'},
											{'m','s','s','s','m','m','s','s','m','m','s','m','m','s','m'},
											{'m','s','m','m','m','s','s','s','s','m','s','p','m','s','m'},
											{'m','s','s','m','m','f','m','m','s','s','s','m','m','s','m'},
											{'m','m','s','s','m','s','m','s','s','m','m','m','s','s','m'},
											{'m','s','s','m','m','s','s','s','s','m','m','s','s','f','m'},
											{'m','s','m','m','m','m','s','s','m','m','m','s','m','m','m'},
											{'m','s','s','m','m','s','s','m','m','f','m','s','m','m','m'},
											{'m','p','s','s','m','s','s','m','m','s','s','s','m','m','m'},
											{'m','s','m','s','s','s','m','m','m','m','s','s','m','m','m'},
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'}
											};

        char[][] c2={
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'},
											{'m','s','m','m','m','m','m','m','m','s','s','s','p','s','m'},
											{'m','s','s','s','s','s','s','s','s','s','m','s','m','s','m'},
											{'m','s','m','m','m','p','m','m','m','s','p','s','m','s','m'},
											{'m','s','s','s','s','s','s','m','s','s','p','s','s','s','m'},
											{'m','m','p','m','m','m','s','m','m','m','s','m','m','s','m'},
											{'m','m','s','m','m','s','s','s','s','m','s','p','m','s','m'},
											{'m','s','s','m','m','f','m','m','s','s','s','m','m','s','m'},
											{'m','p','m','m','s','s','m','s','s','m','m','m','s','s','m'},
											{'m','s','s','s','s','s','s','s','s','m','p','s','s','f','m'},
											{'m','m','m','m','m','m','s','s','m','m','m','s','m','s','m'},
											{'m','f','m','p','m','m','s','m','m','f','s','s','s','s','m'},
											{'m','s','m','s','m','s','s','s','s','s','s','p','m','m','m'},
											{'m','s','s','s','s','s','m','m','m','m','s','s','s','s','m'},
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'}
											};

        char[][] c3={
        									{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'},
											{'m','s','s','s','s','m','m','m','m','p','s','s','s','m','m'},
											{'m','s','m','m','s','s','s','f','s','s','m','m','s','m','m'},
											{'m','s','m','m','m','p','m','m','m','s','m','m','s','m','m'},
											{'m','s','s','m','m','s','s','s','s','s','s','s','s','s','m'},
											{'m','m','s','m','m','m','m','m','m','m','m','m','m','s','m'},
											{'m','s','s','m','m','s','s','s','s','m','s','p','s','s','m'},
											{'m','s','m','m','m','f','m','m','p','s','s','m','m','s','m'},
											{'m','s','m','m','m','s','m','s','s','m','m','m','m','s','m'},
											{'m','s','s','m','s','s','s','s','s','s','m','p','s','s','m'},
											{'m','m','s','m','m','m','p','s','m','s','m','s','m','s','m'},
											{'m','s','s','p','s','m','p','m','m','s','s','s','m','f','m'},
											{'m','s','m','m','s','s','s','m','s','s','m','s','m','s','m'},
											{'m','s','s','f','s','s','m','m','m','m','m','s','s','s','m'},
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'}
											};
        CreerPattern c=new CreerPattern(c1,c2,c3);

        c.genererPattern();
    }
}

