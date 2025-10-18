import java.io.Serializable;

public class Livre extends Media implements Empruntable {

    private String auteur;
    private int nbPages;

    public Livre(String titre, int anneePublication, String auteur, int nbPages) {
        super(titre, anneePublication);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public String getDescription() {
   return "livre de "+ auteur + "Nombres de pages : " + nbPages;
    }

    @Override
    public void emprunter(Membre membre) {
        membre.emprunterMedia(this);
    }

}
