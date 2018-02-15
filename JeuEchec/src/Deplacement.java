public class Deplacement {
	private String name;
	private Integer team;
	private String oldPosCol;
	private String oldPosRow;
	private boolean checkDeplacement = false;

	public void oldPosition(Plateau p) {
		Input input = new Input();
		String deplacement = input
				.getInput("Veuillez saisir la piece deplacer sous forme A8 (Lettre majuscule et chiffre) :");

		// Check si la commande rentrée est une string de 2 caractères
		if (deplacement.length() == 2) {
			String colInput = deplacement.substring(0, 1);
			String rowInput = deplacement.substring(1, 2);
			oldPosCol = colInput;
			oldPosRow = rowInput;

			if (p.getHCol().containsKey(colInput) && p.getHRow().containsKey(rowInput)) {
				Integer row = p.getHRow().get(rowInput);
				Integer col = p.getHCol().get(colInput);

				if (p.getPiece(row, col) != null) {
					name = p.getPiece(row, col).getName();
					team = p.getPiece(row, col).getTeam();

					if (p.getPiece(row, col).checkAround(p, row, col)) {
						System.out.println("Vous avez rencontre un obsctacle");
						oldPosition(p);
					} else {
						p.setPiece(row, col, null);
						checkDeplacement = true;
						return;
					}
				}
			}
		}

		if (!checkDeplacement) {
			System.out.println("Mauvaise commande");
			oldPosition(p);
		}

	}

	public void newPosition(Plateau p) {
		Input input = new Input();
		String deplacement = input.getInput("Veuillez saisir la nouvelle position :");

		if (deplacement.length() == 2) {
			String colInput = deplacement.substring(0, 1);
			String rowInput = deplacement.substring(1, 2);

			if (!colInput.equals(oldPosCol) || !rowInput.equals(oldPosRow)) {

				if (p.getHCol().containsKey(colInput) && p.getHRow().containsKey(rowInput)) {
					Integer col = p.getHCol().get(colInput);
					Integer row = p.getHRow().get(rowInput);
					Integer oldRow = p.getHRow().get(oldPosRow);
					Integer oldCol = p.getHCol().get(oldPosCol);

					// if(p.getPiece(row, col).checkValidDeplacement(row, col, p, team, null) ==
					// true) {
					// newPosition(p);
					// }else {
					// return;1
					
					// }
						
					p.getPiece(row, col).checkValidDeplacement(p, row, col, oldRow, oldCol);
//					if (p.getPiece(row, col).checkValidDeplacement(p, row, col, oldRow, oldCol)) {
//						p.createPiece(name, team, row, col);
//						return;
//					} else {
//						newPosition(p);
//					}
					
					// Check si il mange / deplace possible sur cette position

				}
			}
		}
		System.out.println("Mauvaise commande");
		newPosition(p);
	}
}
