public class Pion extends Piece {
	Integer finalPos;

	public Pion(int team, Integer nbCase) {
		super("Pion", team, nbCase);

	}

	@Override
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		Integer nbDestination;
		
		if (this.getTeam().equals(0)) {
		
			if (row > oldRow) {
				nbDestination = row - oldRow;
				
				if (nbDestination <= this.getNbCase()) {
					//Check si obstacle dans la trajectoire
					if (this.checkTrajectoire(p, this.getTeam(), oldRow, oldCol, nbDestination)) {
						
						if (p.getPiece(oldRow + nbDestination, oldCol) == null && col.equals(oldCol)) {
							// Deplacement sur case vide
							return true;
						} else {
							// Mange en diagonale l'ennemie
							if (p.getPiece(oldRow + nbDestination, col) != null && p.getPiece(oldRow + nbDestination, col).getTeam().equals(1) && !(col).equals(oldCol)) {
									return true;
							}
							// Bloque devant lui
							System.out.println("Collision en face");
							return false;
						}
					} else {
						System.out.println("Collision");
						return false;
					}
				} else {
					System.out.println("Votre nombre de case est limite");				
					return false;
				}	
			}
		} else {
			// team 1
			if (row < oldRow) {
				nbDestination = oldRow - row;
				
				if (nbDestination <= this.getNbCase()) {
					if (this.checkTrajectoire(p, this.getTeam(), oldRow, oldCol, nbDestination)) {
						
						if (p.getPiece(oldRow - nbDestination, oldCol) == null && col.equals(oldCol)) {
							return true;
						} else {
							// Mange en diagonale l'ennemie
							if (p.getPiece(oldRow - nbDestination, col) != null && p.getPiece(oldRow - nbDestination, col).getTeam().equals(0) && !(col).equals(oldCol)) {
								return true;
							}
							// Bloque devant lui
							System.out.println("Collision en face");
							return false;
						}
					} else {
						System.out.println("Collision");
						return false;
					}
				} else {
					System.out.println("Votre nombre de case est limite");				
					return false;
				}
			}
		}
		System.out.println("Deplacement impossible");
		return false;
	}
	
	@Override
	public boolean checkTrajectoire(Plateau p, Integer team, Integer oldRow, Integer oldCol, Integer nbDestination) {
		if (nbDestination.equals(1)) {
			return true;
		}
		
		if (team.equals(0)) {
			finalPos = oldRow + nbDestination;
			for (int i = oldRow + 1; i < finalPos; i++) {
				if (p.getPiece(i, oldCol) != null) {
					return false;
				}
			}
		} else {
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
