public class Pion extends Piece {

	public Pion(int team, Integer nbCase) {
		super("Pion", team, nbCase);

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

	@Override
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		System.out.println("1");
		int newRow = row - oldRow;

		if (this.getTeam().equals(0)) {
			if (newRow <= this.getNbCase()) {
				System.out.println("test");
				if (p.getPiece(row + 1, col) != null) {
					return false;
				} else {
					return true;
				}
			}

		} else {
			System.out.println("Votre nombre de case est limité");
		}
		return false;
	}
}
