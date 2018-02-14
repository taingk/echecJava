public class Deplacement {
    private String name;
    private Integer team;
    private String oldLetter;
    private String oldNumber;
    
    public boolean collision(Plateau p, String oldN, String oldL) {
        Integer l = p.getxPos().get(oldL);
        Integer n = p.getyPos().get(oldN);

        if (p.getPlateau()[n][l].getPiece().checkCollision(p, n, l)) {
            return true;
        }
        else {
        	return false;
        }
    }

    public void oldDeplacement(Plateau p) {
    	Input input = new Input();
        String deplacement = input.getInput("Veuillez saisir la pièce à déplacer sous forme A8 (Lettre majuscule et chiffre) :");

        // Check si la commande rentrée est une string de 2 caractères
        if (deplacement.length() == 2) {
            String oldL = deplacement.substring(0, 1);
            String oldN = deplacement.substring(1, 2);
            oldLetter = oldL;
            oldNumber = oldN;
            
            if (p.getxPos().containsKey(oldL) && p.getyPos().containsKey(oldN)) {
                if (p.getPlateau()[p.getyPos().get(oldN)][p.getxPos().get(oldL)].getPiece() != null && p.getPlateau()[p.getyPos().get(oldN)][p.getxPos().get(oldL)].getPiece() != null) {
                    name = p.getPlateau()[p.getyPos().get(oldN)][p.getxPos().get(oldL)].getPiece().getName();
                    team = p.getPlateau()[p.getyPos().get(oldN)][p.getxPos().get(oldL)].getPiece().getTeam();

                    if (collision(p, oldN, oldL)) {
                    	oldDeplacement(p);
                    } else {
                    	p.getPlateau()[p.getyPos().get(oldN)][p.getxPos().get(oldL)].setPiece(null);
                    	return;
                    }
                }
            }
        }
        System.out.println("Mauvaise commande");
        oldDeplacement(p);
    }

    public void newDeplacement(Plateau p) {
    	Input input = new Input();
        String deplacement = input.getInput("Veuillez saisir la nouvelle position :");

        if (deplacement.length() == 2) {
        	
            String newL = deplacement.substring(0, 1);
            String newN = deplacement.substring(1, 2);

            if (!oldLetter.equals(newL) || !oldNumber.equals(newN)) {

            	if (p.getxPos().containsKey(newL) && p.getyPos().containsKey(newN)) {
            		Integer row = p.getyPos().get(newN);
            		Integer col = p.getxPos().get(newL);

            		System.out.print(row + " " + col);
            		
            		if (p.getPlateau()[row][col].getPiece() != null) {
            			
            		}
            		
            		p.createPiece(name, team, newN, newL);
            		return;
            	}            	
            }
        }
        System.out.println("Mauvaise commande");
        newDeplacement(p);
    }
}
