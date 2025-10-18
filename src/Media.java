public abstract class Media {

    private  String titre;
    private int anneePublication;

    public Media() {this ( "inconnu", 0);}

    public Media(String titre, int anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
    }

    public String getTitre(){
        return this.titre;
    }

    public int getAnneePublication() {
        return this.anneePublication;
    }

    public abstract String getDescription();

    public void afficherDetails(){
        System.out.println(getDescription());
    }

    @Override
    public String toString() {
        return titre + " (" + anneePublication + ")";
    }


}

