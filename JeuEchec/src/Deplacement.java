public class Deplacement {
	
	public void deplacement(Plateau p, Integer player) {
		boolean checkDeplacement = false;
		Input input = new Input();
		
		while (!checkDeplacement) {
			String deplacement = input.getInput("Veuillez saisir la piece deplacer sous forme A8 (Lettre majuscule et chiffre) :", player);
			
			// Check si la commande rentree est une string de 2 caracteres
			if (deplacement.length() == 2) {
				String colInput = deplacement.substring(0, 1);
				String rowInput = deplacement.substring(1, 2);
				
				if (p.getHCol().containsKey(colInput) && p.getHRow().containsKey(rowInput)) {
					Integer oldCol = p.getHCol().get(colInput);
					Integer oldRow = p.getHRow().get(rowInput);
					
					if (p.getPiece(oldRow, oldCol) != null && p.getPiece(oldRow, oldCol).getTeam().equals(player)) {
						deplacement = input.getInput("Veuillez saisir la nouvelle position sous forme A8 (Lettre majuscule et chiffre) :", player);
						
						if (deplacement.length() == 2) {
							colInput = deplacement.substring(0, 1);
							rowInput = deplacement.substring(1, 2);
							
							if (p.getHCol().containsKey(colInput) && p.getHRow().containsKey(rowInput)) {
								Integer col = p.getHCol().get(colInput);
								Integer row = p.getHRow().get(rowInput);
								
								if (!col.equals(oldCol) || !row.equals(oldRow)) {
									
									if (p.getPiece(oldRow, oldCol).checkValidDeplacement(p, row, col, oldRow, oldCol)) {
										
										checkDeplacement = true;
										p.createPiece(p.getPiece(oldRow, oldCol).getName(), p.getPiece(oldRow, oldCol).getTeam(), row, col);
										p.setPiece(oldRow, oldCol, null);
										break;
										
									}
								}
							}
						}
					}
				}
			}
			
			System.out.println("Mauvaise commande");
		}
	}
}
