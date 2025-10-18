public class CD extends Media implements Empruntable{

    private String artiste;
    private String duree;

    public CD (String titre, int anneePublication, String artiste, String duree) {
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

    public String getDuree() {
        return duree;
    }
    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return "CD de "+ artiste + "durée : " + duree;
    }

    @Override
    public void emprunter(Membre membre) {
        membre.emprunterMedia(this);
    }
}
