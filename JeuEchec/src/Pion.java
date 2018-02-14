public class Pion extends Piece {

	public Pion(int team) {
		super("Pion", team);
	}

	@Override
	public boolean checkCollision(Plateau p, Integer n, Integer l) {
		
		if (n + 1 > p.getPlateau().length && // vérifie les côter si n'est pas en dehors du tableau
	    		l + 1 > p.getPlateau().length &&
	    		n - 1 > p.getPlateau().length &&
	    		l - 1 > p.getPlateau().length ){
	    		return false;
		}
		else if (p.getPlateau()[n + 1][l].getPiece() != null) // si devant n'est pas null
		{
			System.out.println("Vous avez rencontré un obsctacle");
			return true;
		} 
		else {
			return false;
		}
	}

}
