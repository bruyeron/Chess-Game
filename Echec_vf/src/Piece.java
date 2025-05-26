public abstract class Piece {

    private TypePiece type;
    private CouleurPiece couleur;

    public Piece(TypePiece type, CouleurPiece couleur) {
        if (type == null || couleur == null) {
            throw new IllegalArgumentException("Le type et la couleur ne doivent pas être null");
        }

        this.type = type;
        this.couleur = couleur;
    }

    public TypePiece getType() {
        return type;
    }

    public CouleurPiece getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        char symbole;

        switch (type) {
            case ROI -> symbole = 'r' ;
            case DAME -> symbole = 'd';
            case TOUR -> symbole = 't';
            case CAVALIER -> symbole = 'c';
            case FOU -> symbole = 'f';
            case PION -> symbole = 'p';
            default -> throw new IllegalArgumentException("Type de pièce inconnu: " + type);
        }

        if (couleur == CouleurPiece.BLANC) {
            symbole = Character.toUpperCase(symbole);
        }

        return String.valueOf(symbole);
    }

    public abstract boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY);
}
