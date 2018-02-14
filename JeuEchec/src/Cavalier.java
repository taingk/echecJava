public class Cavalier extends Piece {
    public Cavalier (int team) {
        super("Cavalier", team);
    }
    
    @Override
    public boolean checkCollision(Plateau p, Integer n, Integer l){ 
        if (	p.getPlateau()[ n + 2 ][l + 1].getPiece() != null && // si devant à droite n'est pas null
        		p.getPlateau()[ n + 2 ][l - 1].getPiece() != null && // si devant à gauche n'est pas null
        		p.getPlateau()[ n - 2 ][l + 1].getPiece() != null && // si derriere à droite n'est pas null
        		p.getPlateau()[ n - 2 ][l - 1].getPiece() != null && // si derriere à gauche n'est pas null
        		p.getPlateau()[ n + 1 ][l + 2].getPiece() != null && // si devant côter à droite n'est pas null
        		p.getPlateau()[ n + 1 ][l - 2].getPiece() != null && // si devant côter à gauche n'est pas null
        		p.getPlateau()[ n - 1 ][l + 2].getPiece() != null && // si derriere côter à droite n'est pas null
        		p.getPlateau()[ n - 1 ][l - 2].getPiece() != null) // si derriere côter à gauche n'est pas null
        {
        		System.out.println("Vous avez rencontré un obsctacle");
            return true;
        }
        else {
            return false;
        }
    }
}
