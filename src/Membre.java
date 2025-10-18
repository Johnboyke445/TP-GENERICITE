import java.util.ArrayList;
import java.util.List;

public class Membre {

    private String nom;
    private int id;
    private List<Media> mediasEmpruntes;

    public Membre(String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.mediasEmpruntes = new ArrayList<>(); // initialisation de la liste
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // EmprunterMedia(Media media) → ajoute à la liste.
    public void emprunterMedia(Media media){
        this.mediasEmpruntes.add(media);
    }

    @Override
    public String toString() {
        return "Membre {" + nom + ", " + id + "}";
    }
}
