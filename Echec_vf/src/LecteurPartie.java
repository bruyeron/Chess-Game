import java.io.File;
import java.util.Scanner;

public class LecteurPartie {
    public static void main(String[] args) {
        Echiquier echiquier = new Echiquier();
        System.out.println(" Début de la partie !\n" + echiquier);

        try {
            Scanner fichier = new Scanner(new File("parties/partie1.txt"));

            while (fichier.hasNextLine()) {
                String ligne = fichier.nextLine().trim();
                if (ligne.isEmpty()) continue;  // Ignore les lignes vides

                String[] coups = ligne.split("\\s+");  // Sépare la ligne en mots

                // Coup des Blancs (ex: "e2-e4")
                jouerUnCoup(echiquier, coups[1], "Blancs");

                // Coup des Noirs s'il existe (ex: "Cg8-f6")
                if (coups.length >= 3) {
                    jouerUnCoup(echiquier, coups[2], "Noirs");
                }
            }
            fichier.close();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    static void jouerUnCoup(Echiquier e, String coup, String joueur) {
        if (!AnalyseurCoups.estValide(coup)) {
            System.out.println("Coup invalide : " + coup);
            return;
        }

        String[] deplacement = AnalyseurCoups.decouperCoup(coup);
        String depart = deplacement[0];
        String arrivee = deplacement[1];

        e.deplacerPiece(depart, arrivee);  // Utilise la méthode du TP1
        System.out.println("▶ " + joueur + " joue : " + coup);
        System.out.println(e);  // Affiche l'échiquier

        // Pause de 2 secondes
        try { Thread.sleep(2000); }
        catch (InterruptedException ex) {}
    }
}