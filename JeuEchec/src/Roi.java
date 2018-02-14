public class Roi extends Piece {
    public Roi(int team) {
        super("Roi", team);
    }
    
    @Override
    public boolean checkCollision(Plateau p, Integer row, Integer col) {
        		
    	if (checkAround(p, row, col)) {
			System.out.println("Vous avez rencontre un obsctacle");
			return true;
		} else {
			return false;
		}
		    		
    }

	@Override
	public boolean checkAround(Plateau p, Integer row, Integer col) {
		
//		p.getPos(row + 1, col); // en bas
//		p.getPiece(row - 1, col); // en haut
//		p.getPiece(row, col + 1); // a droite
//		p.getPos(row, col - 1) // a gauche
//		p.getPiece(row + 1, col + 1); // bas droite
//		p.getPiece(row + 1, col - 1); // bas gauche
//		p.getPiece(row - 1, col + 1); // haut droite
//		p.getPiece(row - 1, col - 1); // haut gauche

		
		// En haut a gauche
		if (col - 1 < 0 && row - 1 < 0) {
			if (p.getPiece(row + 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row + 1, col + 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// En haut a droite
		if (col + 1 > 7 && row - 1 < 0) {
			if (p.getPiece(row + 1, col) != null &&
				p.getPiece(row, col - 1) != null &&
				p.getPiece(row + 1, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// En bas a gauche
		if (col - 1 < 0 && row + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row - 1, col + 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// En bas a droite
		if (col + 1 > 7 && row + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col - 1) != null &&
				p.getPiece(row - 1, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Gauche
		if (col - 1 < 0) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row + 1, col) != null && 
				p.getPiece(row - 1, col + 1) != null &&
				p.getPiece(row + 1, col + 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Droite 
		if (col + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col - 1) != null &&
				p.getPiece(row + 1, col) != null &&
				p.getPiece(row - 1, col - 1) != null &&
				p.getPiece(row + 1, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Haut
		if (row - 1 < 0) {
			if (p.getPiece(row + 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row, col - 1) != null &&
				p.getPiece(row + 1, col + 1) != null &&
				p.getPiece(row + 1, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Bas
		if (row + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row, col - 1) != null && 
				p.getPiece(row - 1, col + 1) != null &&
				p.getPiece(row - 1, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}

    
}
