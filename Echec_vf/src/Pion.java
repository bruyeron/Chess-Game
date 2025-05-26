public class Pion extends Piece {

    public Pion(CouleurPiece couleur) {
        super(TypePiece.PION, couleur);
    }

    @Override
    public boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY) {
        // Exemple très simple : le pion avance d'une case vers le haut ou le bas
        if (getCouleur() == CouleurPiece.BLANC) {
            return arriveeY == departY + 1 && departX == arriveeX;
        } else {
            return arriveeY == departY - 1 && departX == arriveeX;
        }
    }
}
