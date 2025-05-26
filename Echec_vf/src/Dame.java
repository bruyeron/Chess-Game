public class Dame extends Piece {

    public Dame(CouleurPiece couleur) {
        super(TypePiece.DAME, couleur);
    }

    @Override
    public boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY) {
        int dx = Math.abs(departX - arriveeX);
        int dy = Math.abs(departY - arriveeY);
        return departX == arriveeX || departY == arriveeY || dx == dy;
    }
}
