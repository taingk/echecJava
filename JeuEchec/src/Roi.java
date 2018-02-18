public class Roi extends Piece {
    public Roi(int team) {
        super("Roi", team);
    }
    
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		String direction = null;
		Integer nbDestination = null;

		if (oldRow < row && oldCol < col) {
			if (!(row - oldRow == col - oldCol)) {
				return false;
			}
			nbDestination = row - oldRow;
			direction = "bas droite";
		} else if (oldRow > row && oldCol > col) {
			if (!(row + oldRow == col + oldCol)) {
				return false;
			}
			nbDestination = oldRow - row;
			direction = "haut gauche";
		} else if (oldRow > row && oldCol < col) {
			if (!(oldRow - row  == col - oldCol)) {
				return false;
			}
			nbDestination = oldRow - row;
			direction = "haut droite";
		} else if (oldRow < row && oldCol > col) {
			if (!(row - oldRow  == oldCol - col)) {
				return false;
			}
			nbDestination = row - oldRow;
			direction = "bas gauche";
		} else if (!col.equals(oldCol)) {
			if (col > oldCol) {
				nbDestination = col - oldCol;
				direction = "droite";
			} else {
				nbDestination = oldCol - col;
				direction = "gauche";
			}
		} else {
			if (row > oldRow) {
				nbDestination = row - oldRow;
				direction = "bas";
			} else {
				nbDestination = oldRow - row;
				direction = "haut";
			}
		}
		
		if (nbDestination > 1) {
			return false;
		}

		//Check si obstacle dans la trajectoire
		if (this.checkTrajectoire(p, oldRow, oldCol, nbDestination, direction)) {
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
				
		System.out.println("Collision");
		return false;
	}    
}
