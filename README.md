# TP-GENERICITE

Auteur : John DINH

## Description
Projet Java pour gérer des **médias** (Livres et CD) et des **membres** qui peuvent les emprunter.  
Il permet de gérer une petite **bibliothèque** contenant des **médias** (Livres et CD) et des **membres** pouvant les emprunter.  
Le programme illustre des concepts importants comme les **collections génériques**, l’**héritage**, le **polymorphisme**, les **interfaces**, et les **comparateurs**.

## Fonctionnalités
- Classes `Media`, `Livre`, `CD` avec héritage et méthodes comme `getDescription()`
- Classe `Membre` pour gérer les emprunts
- Interface `Empruntable` implémentée par `Livre` et `CD` pour permettre leur emprunt
  
- Stockage :
  - `List<Media>` pour les médias disponibles
  - `Set<Membre>` pour éviter les doublons
  - `Map<Membre, List<Media>>` pour les emprunts
  
- Méthodes génériques :
  - `afficherListe()` pour afficher une collection
  - `filtrer()` pour filtrer selon un critère
  - `copierCollection()` pour copier une collection
    
- Tri avec `Comparator` pour les médias et les livres

- Utilisation:
Cloner le dépôt :
git clone https://github.com/Johnboyke445/TP-GENERICITE.git

Ouvrir le projet dans un IDE Java (IntelliJ IDEA recommandé)

Exécuter la classe Main pour tester toutes les fonctionnalités.
