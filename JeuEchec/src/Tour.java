import java.util.*;

public class Tour extends Piece {
	public Tour(int team) {
		super("Tour", team);
	}

	@Override
	public boolean checkAround(Plateau p, Integer row, Integer col) {
		// Check seulement c�t�
		
		// En haut a gauche
		if (col - 1 < 0 && row - 1 < 0) {
			if (p.getPiece(row + 1, col) != null &&
				p.getPiece(row, col + 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// En haut a droite
		if (col + 1 > 7 && row - 1 < 0) {
			if (p.getPiece(row + 1, col) != null &&
				p.getPiece(row, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// En bas a gauche
		if (col - 1 < 0 && row + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col + 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// En bas a droite
		if (col + 1 > 7 && row + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Gauche
		if (col - 1 < 0) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row + 1, col) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Droite 
		if (col + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col - 1) != null &&
				p.getPiece(row + 1, col) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Haut
		if (row - 1 < 0) {
			if (p.getPiece(row + 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		// Bas
		if (row + 1 > 7) {
			if (p.getPiece(row - 1, col) != null &&
				p.getPiece(row, col + 1) != null &&
				p.getPiece(row, col - 1) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
}