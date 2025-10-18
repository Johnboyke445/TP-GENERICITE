import java.util.*;
import java.util.function.Predicate;

public class Main {

    // Affiche chaque élément (en utilisant toString()).
    public static <T> void afficherListe(List<T> liste){
        for (T element :  liste){   // parcourir tous les éléments
            System.out.println(element);
        }
    }
   // Renvoie une nouvelle liste filtrée selon le prédicat.
    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critère) {
        List<T> resultat = new ArrayList<>();   // liste vide pour les éléments filtrés
        for (T element : liste){
            if (critère.test(element)){          // tester le prédicat
                resultat.add(element);
            }
        }
        return resultat;
    }

    // Copie les éléments sans perdre le type.
    public static <T> void copierCollection(Collection<T> source, Collection<T> destination){
        for (T element : source){   // Parcourir tous les éléments
            destination.add(element); // Ajouter dans la collection destination
        }
    }

    public static void main(String[] args) {

        // Crée une list pour stocker les médias
        List<Media> mediasDisponibles = new ArrayList<>();


        Livre livre1 = new Livre("1984", 1949, "George Orwell", 328);
        Livre livre2 = new Livre("Le Petit Prince", 2010, "Antoine de Saint-Exupéry", 96);
        Livre livre3 = new Livre("Harry Potter à l'école des sorciers", 1997, "J.K. Rowling", 320);
        Livre livre4 = new Livre("L'Étranger", 1942, "Albert Camus", 185);
        Livre livre5 = new Livre("La Peste", 1947, "Albert Camus", 295);


        CD cd1 = new CD("Thriller", 1982, "Michael Jackson", "42min");
        CD cd2 = new CD("Back in Black", 2021, "AC/DC", "41min");
        CD cd3 = new CD("Random Access Memories", 2013, "Daft Punk", "74min");
        CD cd4 = new CD("Divide", 2017, "Ed Sheeran", "59min");
        CD cd5 = new CD("Abbey Road", 1969, "The Beatles", "47min");

        mediasDisponibles.add(livre1);
        mediasDisponibles.add(livre2);
        mediasDisponibles.add(livre3);
        mediasDisponibles.add(livre4);
        mediasDisponibles.add(livre5);
        mediasDisponibles.add(cd1);
        mediasDisponibles.add(cd2);
        mediasDisponibles.add(cd3);
        mediasDisponibles.add(cd4);
        mediasDisponibles.add(cd5);

        // Crée un set pour stocker les membres
        Set<Membre> membres = new HashSet<>();

        Membre membre1 = new Membre("Alice", 1);
        Membre membre2 = new Membre("Bob", 2);
        Membre membre3 = new Membre("Codi", 3);
        Membre membre4 = new Membre("Anna", 4);
        Membre membre5 = new Membre("David", 5);

        membres.add(membre1);
        membres.add(membre2);
        membres.add(membre3);
        membres.add(membre4);
        membres.add(membre5);


        // Map pour associer chaque membre à sa liste de médias empruntés
        Map<Membre, List<Media>> emprunts = new HashMap<>();

        // on initialise la liste vide pour chaque membre
        emprunts.put(membre1, new ArrayList<>());
        emprunts.put(membre2, new ArrayList<>());

        emprunts.get(membre1).add(livre1);
        emprunts.get(membre2).add(livre2);

        emprunts.get(membre1).add(cd1);
        emprunts.get(membre2).add(cd2);

        Set<Media> Medias = new HashSet<>();
        for (List<Media> liste : emprunts.values()) { // Parcours chaque liste et récupère toutes les listes des médias de chaque membre.
            copierCollection(liste, Medias);  // Copie tous les médias empruntés dans le Set
        }

        // Extraire uniquement les livres de la liste principale
        List<Livre> livres = new ArrayList<>();
        for (Media m : mediasDisponibles) {
            if (m instanceof Livre) { // Si m est un Livre, on entre dans le bloc.
                livres.add((Livre) m);
            }
        }

        System.out.println("--Affichage de toutes les médias--");
        afficherListe(mediasDisponibles);
        System.out.println("-------------------------------------------------------------");
        System.out.println("--Affichage de toutes les membres--");
        afficherListe(new ArrayList<>(membres));

        System.out.println("-------------------------------------------------------------");

        // Filtrer les Media publiés après 2010.
        List<Media> mediasRecents = filtrer(mediasDisponibles, m -> m.getAnneePublication() > 2010);
        System.out.println("--Année superieur à 2010--");
        afficherListe(mediasRecents );

        // Filtrer les Membre dont le nom commence par “A”.
        List<Membre> membresA = filtrer(new ArrayList<>(membres), m -> m.getNom().startsWith("A"));
        System.out.println("--Nom filtrés en A--");
        afficherListe(membresA);

        System.out.println("-------------------------------------------------------------");

        // Comparateur
        Comparator<Media> comparateurMedia = Comparator
                .comparing(Media::getAnneePublication).reversed()   // tri décroissant
                .thenComparing(Media::getTitre);                    // si même année → par titre

        //Trie la liste de médias selon le comparateur défini
        mediasDisponibles.sort(comparateurMedia);
        System.out.println("--Médias triés par annéeePublication et titre si meme année--");
        afficherListe(mediasDisponibles);

        System.out.println("-------------------------------------------------------------");

        Comparator<Livre> comparateurLivre = Comparator
                .comparing(Livre::getAuteur)// tri croissant
                .thenComparing(Livre::getTitre); // si même auteur → par titre

        //Trie la liste de livres selon le comparateur défini
        livres.sort(comparateurLivre);
        System.out.println("--Livres triés par auteur puis titre--");
        for (Livre l : livres) {
            System.out.println(l.getAuteur() + " - " + l.getTitre());
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("--Médias empruntés sans doublons--");
        afficherListe(new ArrayList<>(Medias));

        System.out.println("-------------------------------------------------------------");

        // Filtrer polymorphe.
        List<Media> livre = filtrer(mediasDisponibles, m -> m instanceof Livre);
        System.out.println("--Filtrage pour obtenir uniquement les objets de type Livre--");
        afficherListe(livre);

        System.out.println("-------------------------------------------------------------");
        System.out.println("--Testez le polymorphisme en appelant afficherDetails() sur une liste de Media.--");
        for (Media m : mediasDisponibles) {
            m.afficherDetails(); // Affiche la description correcte selon le type
        }

    }
}