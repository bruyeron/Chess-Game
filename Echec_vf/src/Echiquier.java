public class Echiquier {
    private Piece[][] plateau;

    // Constructeur : crée un échiquier vide
    public Echiquier() {
        plateau = new Piece[8][8];
    }

    // Méthode pour poser une pièce sur une case
    public void poserPiece(Piece piece, String coord) {
        int x = coord.charAt(0) - 'a';
        int y = coord.charAt(1) - '1';
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Coordonnées invalides : " + coord);
        }
        plateau[x][y] = piece;
    }

    // Méthode pour déplacer une pièce d'une case à une autre
    public void deplacerPiece(String depart, String arrivee) {
        int xDepart = depart.charAt(0) - 'a';
        int yDepart = depart.charAt(1) - '1';
        int xArrivee = arrivee.charAt(0) - 'a';
        int yArrivee = arrivee.charAt(1) - '1';

        if (plateau[xDepart][yDepart] == null) {
            throw new IllegalArgumentException("Pas de pièce à déplacer en " + depart);
        }

        // Déplacement : si une pièce est à l'arrivée, elle est remplacée
        plateau[xArrivee][yArrivee] = plateau[xDepart][yDepart];
        plateau[xDepart][yDepart] = null;
    }

    public void prendrePiece(String depart, String arrivee) {
        int[] coordDep = coordonneesExternesVersInternes(depart);
        int[] coordArr = coordonneesExternesVersInternes(arrivee);

        // Vérifie qu'il y a une pièce à déplacer
        if (plateau[coordDep[0]][coordDep[1]] == null) {
            throw new IllegalArgumentException("Pas de pièce en " + depart);
        }

        // Effectue la prise (écrase la pièce d'arrivée si elle existe)
        plateau[coordArr[0]][coordArr[1]] = plateau[coordDep[0]][coordDep[1]];
        plateau[coordDep[0]][coordDep[1]] = null;

        System.out.println("Prise effectuée de " + depart + " à " + arrivee);
    }

    public Piece getPiece(String coord) {
        int[] coords = coordonneesExternesVersInternes(coord);
        int x = coords[0];
        int y = coords[1];
        if (x < 0 || x > 7 || y < 0 || y > 7) return null;
        return plateau[x][y];
    }


    public void initialiserEchiquier() {
        // Pièces blanches
        this.poserPiece(new Piece(TypePiece.TOUR, CouleurPiece.BLANC), "a1");
        this.poserPiece(new Piece(TypePiece.CAVALIER, CouleurPiece.BLANC), "b1");
        this.poserPiece(new Piece(TypePiece.FOU, CouleurPiece.BLANC), "c1");
        this.poserPiece(new Piece(TypePiece.DAME, CouleurPiece.BLANC), "d1");
        this.poserPiece(new Piece(TypePiece.ROI, CouleurPiece.BLANC), "e1");
        this.poserPiece(new Piece(TypePiece.FOU, CouleurPiece.BLANC), "f1");
        this.poserPiece(new Piece(TypePiece.CAVALIER, CouleurPiece.BLANC), "g1");
        this.poserPiece(new Piece(TypePiece.TOUR, CouleurPiece.BLANC), "h1");

        // Pions blancs
        for (char colonne = 'a'; colonne <= 'h'; colonne++) {
            this.poserPiece(new Piece(TypePiece.PION, CouleurPiece.BLANC), colonne + "2");
        }

        // Pièces noires
        this.poserPiece(new Piece(TypePiece.TOUR, CouleurPiece.NOIR), "a8");
        this.poserPiece(new Piece(TypePiece.CAVALIER, CouleurPiece.NOIR), "b8");
        this.poserPiece(new Piece(TypePiece.FOU, CouleurPiece.NOIR), "c8");
        this.poserPiece(new Piece(TypePiece.DAME, CouleurPiece.NOIR), "d8");
        this.poserPiece(new Piece(TypePiece.ROI, CouleurPiece.NOIR), "e8");
        this.poserPiece(new Piece(TypePiece.FOU, CouleurPiece.NOIR), "f8");
        this.poserPiece(new Piece(TypePiece.CAVALIER, CouleurPiece.NOIR), "g8");
        this.poserPiece(new Piece(TypePiece.TOUR, CouleurPiece.NOIR), "h8");

        // Pions noirs
        for (char colonne = 'a'; colonne <= 'h'; colonne++) {
            this.poserPiece(new Piece(TypePiece.PION, CouleurPiece.NOIR), colonne + "7");
        }
    }


    // Méthode pour afficher l’échiquier
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  abcdefgh\n");
        for (int ligne = 7; ligne >= 0; ligne--) { // On commence par la ligne 8
            sb.append(ligne + 1).append(" ");
            for (int colonne = 0; colonne < 8; colonne++) {
                Piece piece = plateau[colonne][ligne];
                if (piece != null) {
                    sb.append(piece.toString());
                } else {
                    sb.append(" ");
                }
            }
            sb.append(" ").append(ligne + 1).append("\n");
        }
        sb.append("  abcdefgh");
        return sb.toString();
    }

    // Méthode pour convertir coordonnées internes vers externes
    public static String coordonneesInternesVersExternes(int x, int y) {
        return "" + (char) (x + 'a') + (y + 1);
    }

    // Méthode pour convertir coordonnées externes vers internes
    public static int[] coordonneesExternesVersInternes(String coord) {
        int x = coord.charAt(0) - 'a';
        int y = coord.charAt(1) - '1';
        return new int[]{x, y};
    }
}
