public class Cavalier extends Piece {
    public Cavalier (int team) {
        super("Cavalier", team);
    }
    
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		if (row.equals(oldRow) && !col.equals(oldCol)) {
			return false;
		} else if (!row.equals(oldRow) && col.equals(oldCol)) {
			return false;
		}
		
		String direction = null;
		Integer nbDestination = null;

		if (oldRow + 2 == row) {
			if (oldCol + 1 == col) {
				direction = "bas droite";
			} else if (oldCol - 1 == col) {
				direction = "bas gauche";
			}
		}

		if (oldRow - 2 == row) {
			if (oldCol + 1 == col) {
				direction = "haut droite";
			} else if (oldCol - 1 == col) {
				direction = "haut gauche";
			}
		}
		
		if (oldCol - 2 == col) {
			if (oldRow + 1 == row) {
				direction = "gauche bas";
			} else if (oldRow - 1 == row) {
				direction = "gauche haut";
			}
		}
		
		if (oldCol + 2 == col) {
			if (oldRow + 1 == row) {
				direction = "gauche bas";
			} else if (oldRow - 1 == row) {
				direction = "gauche haut";
			}
		}
		
		//Check si obstacle dans la trajectoire
		if (!direction.equals(null)) {
			if (p.getPiece(row, col) == null) {
				// Deplacement sur case vide
				return true;
			} else {
				// Mange l'ennemie
				if (p.getPiece(row, col) != null && p.getPiece(row, col).getTeam().equals( this.getTeam().equals(0) ? 1 : 0 )) {
					return true;
				}
				System.out.println("C'est un allié");
			}
		}
				
		return false;
	}

}
