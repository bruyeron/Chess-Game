public class Fou extends Piece {

    public Fou(CouleurPiece couleur) {
        super(TypePiece.FOU, couleur);
    }

    @Override
    public boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY) {
        return Math.abs(departX - arriveeX) == Math.abs(departY - arriveeY);
    }
}
