import java.util.*;

public class Tour extends Piece {
	private Integer finalPos;

	public Tour(int team) {
		super("Tour", team);
	}
	
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
	    HashMap<String, String> hDirection = new HashMap<>();
		Integer nbDestination;
		String destination;
		
		if (!col.equals(oldCol)) {
			if (col > oldCol) {
				nbDestination = col - oldCol;
				hDirection.put("col", "droite");
			} else {
				nbDestination = oldCol - col;
				hDirection.put("col", "gauche");
			}
			destination = "col";
		} else {

			if (row > oldRow) {
				nbDestination = row - oldRow;
				hDirection.put("row", "bas");
			} else {
				nbDestination = oldRow - row;
				hDirection.put("row", "haut");
			}
			destination = "row";
		}

		//Check si obstacle dans la trajectoire
		if (this.checkTrajectoire(p, oldRow, oldCol, nbDestination, hDirection)) {

			if (destination.equals("row") && col.equals(oldCol)) {

				if (p.getPiece(finalPos, col) == null) {
					// Deplacement sur case vide
					return true;
				} else {
					// Mange l'ennemie
					if (p.getPiece(finalPos, col) != null && p.getPiece(finalPos, col).getTeam().equals( this.getTeam().equals(0) ? 1 : 0 )) {
							return true;
					}
					// Bloque devant lui
					System.out.println("Vous avez rencontre un obstacle");
				}				
			} else if (destination.equals("col") && row.equals(oldRow)) {

				if (p.getPiece(row, finalPos) == null) {
					// Deplacement sur case vide
					return true;
				} else {
					// Mange l'ennemie
					if (p.getPiece(row, finalPos) != null && p.getPiece(row, finalPos).getTeam().equals( this.getTeam().equals(0) ? 1 : 0 )) {
							return true;
					}
					// Bloque devant lui

					System.out.println("Vous avez rencontre un obstacle");
				}
			}
			
		} 
		
		System.out.println("Collision");
		return false;
	}

	public boolean checkTrajectoire(Plateau p, Integer oldRow, Integer oldCol, Integer nbDestination, HashMap<String, String> hDirection) {

		if (hDirection.containsKey("col")) {
			if (hDirection.get("col") == "droite") {
				finalPos = oldCol + nbDestination;				
			} else {
				finalPos = oldCol - nbDestination;
			}
			
			if (hDirection.get("col") == "droite") {
				for (int i = oldCol + 1; i < finalPos; i++) {
					if (p.getPiece(oldRow, i) != null) {
						return false;
					}
				}			
			} else {
				for (int i = oldCol - 1; i > finalPos; i--) {
					if (p.getPiece(oldRow, i) != null) {
						return false;
					}
				}
			}

		} else {
			if (hDirection.get("row") == "bas") {
				finalPos = oldRow + nbDestination;
			} else {
				finalPos = oldRow - nbDestination;
				System.out.print(oldRow + " " + nbDestination);
			}
			
			if (hDirection.get("row") == "bas") {
				for (int i = oldRow + 1; i < finalPos; i++) {
					if (p.getPiece(i, oldCol) != null) {
						return false;
					}
				}			
			} else {
				for (int i = oldRow - 1; i > finalPos; i--) {
					if (p.getPiece(i, oldCol) != null) {
						return false;
					}
				}
			}

		}

		return true;
	}


}