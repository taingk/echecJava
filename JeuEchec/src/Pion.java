public class Pion extends Piece {

	public Pion(int team) {
		super("Pion", team);
	}

	@Override
	public boolean checkAround(Plateau p, Integer row, Integer col) {
		
		if (this.getTeam().equals(0)) {			
			if (p.getPiece(row + 1, col) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (p.getPiece(row - 1, col) != null) {
				return true;
			} else {
				return false;
			}
		}
	}
}
