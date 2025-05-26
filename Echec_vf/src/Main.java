import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Echiquier echiquier = new Echiquier();
        echiquier.initialiserEchiquier(); // Méthode d'initialisation

        System.out.println("=== Début de la partie ===");
        System.out.println(echiquier);

        try (Scanner scanner = new Scanner(new File("parties/anderssen-kieseritzky.txt"))) {
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine().trim();
                if (ligne.isEmpty()) continue;

                String[] coups = ligne.split("\\s+");

                // Coup des Blancs
                if (coups.length > 1) {
                    jouerEtAfficher(echiquier, coups[1], CouleurPiece.BLANC);
                }

                // Coup des Noirs
                if (coups.length > 2) {
                    jouerEtAfficher(echiquier, coups[2], CouleurPiece.NOIR);
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    private static void jouerEtAfficher(Echiquier echiquier, String coup, CouleurPiece couleur) {
        System.out.println("\n> " + couleur + " joue : " + coup);
        AnalyseurCoups.jouerCoup(echiquier, coup, couleur);

        try {
            Thread.sleep(2000); // Pause de 2 secondes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}