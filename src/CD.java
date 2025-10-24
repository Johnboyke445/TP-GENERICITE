public class CD extends Media implements Empruntable{

    private String artiste;
    private int duree;

    public CD (String titre, int anneePublication, String artiste, int duree) {
        super (titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree( int duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return "CD de "+ artiste + "durée : " + duree + "min";
    }

    @Override
    public void emprunter(Membre membre) {
        membre.emprunterMedia(this);
    }
}
