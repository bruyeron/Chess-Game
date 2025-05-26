public class Cavalier extends Piece {

    public Cavalier(CouleurPiece couleur) {
        super(TypePiece.CAVALIER, couleur);
    }

    @Override
    public boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY) {
        int dx = Math.abs(departX - arriveeX);
        int dy = Math.abs(departY - arriveeY);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
