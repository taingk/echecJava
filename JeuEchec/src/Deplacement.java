public class Deplacement {
    private String name;
    private Integer team;
    private String oldPosCol;
    private String oldPosRow;
    private boolean checkDeplacement = false;
    
    public void oldPosition(Plateau p) {
    	Input input = new Input();
        String deplacement = input.getInput("Veuillez saisir la piece deplacer sous forme A8 (Lettre majuscule et chiffre) :");
        
        // Check si la commande rentrée est une string de 2 caractères
        if (deplacement.length() == 2) {
    		String colInput = deplacement.substring(0, 1);
    		String rowInput = deplacement.substring(1, 2);
    		oldPosRow = rowInput;
    		oldPosCol = colInput;
    		
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

            if (!oldPosCol.equals(colInput) || !oldPosRow.equals(rowInput)) {

            	if (p.getHCol().containsKey(colInput) && p.getHRow().containsKey(rowInput)) {
            		Integer col = p.getHCol().get(colInput);
            		Integer row = p.getHRow().get(rowInput);
           		            		
            		// Check si il mange / deplace possible sur cette position
            		p.createPiece(name, team, row, col);
					checkDeplacement = true;
            		return;
            	}            	
            }
        }
        
        if (!checkDeplacement) {
	        System.out.println("Mauvaise commande");
	        newPosition(p);
        }
    }
}
