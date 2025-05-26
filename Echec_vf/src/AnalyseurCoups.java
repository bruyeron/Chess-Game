import java.util.regex.*;

public class AnalyseurCoups {
    private static final Pattern PATTERN_COUP =
            Pattern.compile("([CTFDR]?)([a-h][1-8])([-x])([a-h][1-8])");

    public static boolean estValide(String coup) {
        return PATTERN_COUP.matcher(coup).matches();
    }

    public static String[] decouperCoup(String coup) {
        Matcher matcher = PATTERN_COUP.matcher(coup);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Coup invalide : " + coup);
        }
        return new String[]{matcher.group(2), matcher.group(4)};
    }

    public static void jouerCoup(Echiquier echiquier, String coup, CouleurPiece couleur) {
        if (!estValide(coup)) {
            System.out.println("Coup invalide : " + coup);
            return;
        }

        String[] deplacement = decouperCoup(coup);
        String depart = deplacement[0];
        String arrivee = deplacement[1];

            if (coup.contains("x")) {
                echiquier.prendrePiece(depart, arrivee);
            } else {
                echiquier.deplacerPiece(depart, arrivee);
            }
            System.out.println("▶ " + couleur + " joue : " + coup);
            System.out.println(echiquier);
    }
}