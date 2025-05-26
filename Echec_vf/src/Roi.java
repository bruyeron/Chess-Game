public class Roi extends Piece {

    public Roi(CouleurPiece couleur) {
        super(TypePiece.ROI, couleur);
    }

    @Override
    public boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY) {
        int dx = Math.abs(departX - arriveeX);
        int dy = Math.abs(departY - arriveeY);
        return dx <= 1 && dy <= 1;
    }
}
