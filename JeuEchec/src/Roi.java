public class Roi extends Piece {
    public Roi(int team) {
        super("Roi", team);
    }
    
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		Integer nbDestination = null;

		if (oldRow < row && oldCol < col) {
			if (!(row - oldRow == col - oldCol)) {
				return false;
			}
			nbDestination = row - oldRow;
		} else if (oldRow > row && oldCol > col) {
			if (!(row + oldRow == col + oldCol)) {
				return false;
			}
			nbDestination = oldRow - row;
		} else if (oldRow > row && oldCol < col) {
			if (!(oldRow - row  == col - oldCol)) {
				return false;
			}
			nbDestination = oldRow - row;
		} else if (oldRow < row && oldCol > col) {
			if (!(row - oldRow  == oldCol - col)) {
				return false;
			}
			nbDestination = row - oldRow;
		} else if (!col.equals(oldCol)) {
			if (col > oldCol) {
				nbDestination = col - oldCol;
			} else {
				nbDestination = oldCol - col;
			}
		} else {
			if (row > oldRow) {
				nbDestination = row - oldRow;
			} else {
				nbDestination = oldRow - row;
			}
		}
		
		if (nbDestination > 1) {
			return false;
		}

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
				
		return false;
	}    
}
