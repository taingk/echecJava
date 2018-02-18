import java.util.*;

public class Tour extends Piece {

	public Tour(int team) {
		super("Tour", team);
	}
	
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		if (!row.equals(oldRow) && !col.equals(oldCol)) {
			return false;
		}
		
		String direction;
		Integer nbDestination;
		
		if (!col.equals(oldCol)) {
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

	public boolean checkTrajectoire(Plateau p, Integer oldRow, Integer oldCol, Integer nbDestination, String direction) {
		Integer finalPos;

		if (direction.equals("droite")) {
			finalPos = oldCol + nbDestination;				
			for (int i = oldCol + 1; i < finalPos; i++) {
				if (p.getPiece(oldRow, i) != null) {
					return false;
				}
			}			
		} 
		
		if (direction.equals("gauche")) {
			finalPos = oldCol - nbDestination;
			for (int i = oldCol - 1; i > finalPos; i--) {
				if (p.getPiece(oldRow, i) != null) {
					return false;
				}
			}
		} 
		
		if (direction.equals("bas")) {
			finalPos = oldRow + nbDestination;
			for (int i = oldRow + 1; i < finalPos; i++) {
				if (p.getPiece(i, oldCol) != null) {
					return false;
				}
			}
		} 
		
		if (direction.equals("haut")) {
			finalPos = oldRow - nbDestination;
			for (int i = oldRow - 1; i > finalPos; i--) {
				if (p.getPiece(i, oldCol) != null) {
					return false;
				}
			}
		}
		
		return true;
	}


}