import java.util.HashMap;

public class Fou extends Piece {

    public Fou(int team) {
        super("Fou", team);
    }
   
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		if (row.equals(oldRow) && !col.equals(oldCol)) {
			return false;
		} else if (!row.equals(oldRow) && col.equals(oldCol)) {
			return false;
		}

		String direction;
		Integer nbDestination;

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
		} else {
			if (!(row - oldRow  == oldCol - col)) {
				return false;
			}
			nbDestination = row - oldRow;
			direction = "bas gauche";
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
				System.out.println("C'est un alli�");
			}
		}
		
		System.out.println("Collision");
		return false;
	}

	public boolean checkTrajectoire(Plateau p, Integer oldRow, Integer oldCol, Integer nbDestination, String direction) {
		if (nbDestination.equals(1)) {
			return true;
		}
		
		if (direction.equals("bas droite")) {
			for (int i = oldRow + 1, j = oldCol + 1, compteur = 0; compteur < nbDestination - 1; i++, j++, compteur++) {
				if (p.getPiece(i, j) != null) {
					return false;
				}
			}	
		}

		if (direction.equals("haut gauche")) {
			for (int i = oldRow - 1, j = oldCol - 1, compteur = 0; compteur < nbDestination - 1; i--, j--, compteur++) {
				if (p.getPiece(i, j) != null) {
					return false;
				}
			}	
		}
		
		if (direction.equals("haut droite")) {
			for (int i = oldRow - 1, j = oldCol + 1, compteur = 0; compteur < nbDestination - 1; i--, j++, compteur++) {
				if (p.getPiece(i, j) != null) {
					return false;
				}
			}	
		}

		if (direction.equals("bas gauche")) {
			for (int i = oldRow + 1, j = oldCol - 1, compteur = 0; compteur < nbDestination - 1; i++, j--, compteur++) {
				if (p.getPiece(i, j) != null) {
					return false;
				}
			}	
		}

		return true;
	}
    
}
