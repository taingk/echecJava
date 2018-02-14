public class Reine extends Piece {
    public Reine (int team) {
        super("Reine", team);
    }
    
    @Override
    public boolean checkCollision(Plateau p, Integer n, Integer l){ 
	    	
	    	if (n + 1 > p.getPlateau().length && // vérifie les côter si n'est pas en dehors du tableau
	    		l + 1 > p.getPlateau().length &&
	    		n - 1 > p.getPlateau().length &&
	    		l - 1 > p.getPlateau().length ){
	        		return false;
	    	}
    		else if (p.getPlateau()[ n ][l + 1].getPiece() != null &&// si devant n'est pas null
        		p.getPlateau()[ n ][l - 1].getPiece() != null && // si derriere n'est pas null
        		p.getPlateau()[ n + 1 ][l].getPiece() != null &&  // si a droite n'est pas null
        		p.getPlateau()[ n - 1 ][l].getPiece() != null && // si a gauche n'est pas null
        		p.getPlateau()[ n + 1 ][l + 1].getPiece() != null && // si en diagonal haut droite n'est pas null
        		p.getPlateau()[ n - 1][l + 1].getPiece() != null && // si en diagonal haut gauche n'est pas null
        		p.getPlateau()[ n + 1][l - 1].getPiece() != null && // si en diagonal bas droite n'est pas null
        		p.getPlateau()[ n - 1 ][l - 1].getPiece() != null) // si en diagonal bas gauche n'est pas null
        {
        		System.out.println("Vous êtes entouré");
            return true;
        }
        else {
            return false;
        }
    }
}
