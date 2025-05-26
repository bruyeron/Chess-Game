public class Tour extends Piece {

    public Tour(CouleurPiece couleur) {
        super(TypePiece.TOUR, couleur);
    }

    @Override
    public boolean estDeplacementValide(Echiquier echiquier, int departX, int departY, int arriveeX, int arriveeY) {
        // La Tour se déplace en ligne droite : soit horizontalement, soit verticalement
        return departX == arriveeX || departY == arriveeY;
    }
}
