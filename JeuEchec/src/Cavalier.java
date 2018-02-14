public class Cavalier extends Piece {
    public Cavalier (int team) {
        super("Cavalier", team);
    }
    
    @Override
    public boolean checkCollision(Plateau p, Integer row, Integer col){ 
	    	
    	if (checkAround(p, row, col)) {
			System.out.println("Vous avez rencontre un obsctacle");
			return true;
		} else {
			return false;
		}
    	
    }
    
	@Override
	public boolean checkAround(Plateau p, Integer row, Integer col) {
		
//		p.getPlateau()[ row + 2 ][col + 1].getPiece() != null && // si devant à droite n'est pas null
//        		p.getPlateau()[ row + 2 ][col - 1].getPiece() != null && // si devant à gauche n'est pas null
//        		p.getPlateau()[ row - 2 ][col + 1].getPiece() != null && // si derriere à droite n'est pas null
//        		p.getPlateau()[ row - 2 ][col - 1].getPiece() != null && // si derriere à gauche n'est pas null
//        		p.getPlateau()[ row + 1 ][col + 2].getPiece() != null && // si devant côter à droite n'est pas null
//        		p.getPlateau()[ row + 1 ][col - 2].getPiece() != null && // si devant côter à gauche n'est pas null
//        		p.getPlateau()[ row - 1 ][col + 2].getPiece() != null && // si derriere côter à droite n'est pas null
//        		p.getPlateau()[ row - 1 ][col - 2].getPiece() != null) // si derriere côter à gauche n'est pas null
		
//		p.getPos(row + 1, col); // en bas
//		p.getPiece(row - 1, col); // en haut
//		p.getPiece(row, col + 1); // a droite
//		p.getPos(row, col - 1) // a gauche
//		p.getPiece(row + 1, col + 1); // bas droite
//		p.getPiece(row + 1, col - 1); // bas gauche
//		p.getPiece(row - 1, col + 1); // haut droite
//		p.getPiece(row - 1, col - 1); // haut gauche

		System.out.print(col);
		if (row == 0 || row == 1 && col > 1 ) {
			System.out.print("salut");
		}
		if (row == 6 || row == 7) {
//			System.out.print("salut");
		}
		if (col == 0 || col == 1) {
//			System.out.print("salut");
		}
		if (col == 6 || col == 7) {
//			System.out.print("salut");
		}
		
		return false;
	}

}
