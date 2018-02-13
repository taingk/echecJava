public class Deplacement {
    private String name;
    private Integer team;
    private String oldLetter;
    private String oldNumber;
    
    public void collision(Plateau p, String oldN, String oldL) {
        Integer l = p.xMap().get(oldL);
        Integer n = p.yMap().get(oldN);

//        if (collisionAround(p, n, l)) {
//            System.out.println("Je suis entouré");
//        }
    }

//    public boolean collisionAround(Plateau p, Integer n, Integer l) {
//        if (p.getPlateau()[ n - 1 ][l].getPiece() != null)
//        //        &&
//          //      p.getPlateau()[ n + 1 ][l].getPiece() != null &&
//            //    p.getPlateau()[ n ][l - 1].getPiece() != null &&
//              //  p.getPlateau()[ n ][l + 1].getPiece() != null)
//        {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    public void oldDeplacement(Plateau p) {
    	Input input = new Input();
        String deplacement = input.getInput("Veuillez saisir la pièce à déplacer sous forme A8 (Lettre majuscule et chiffre) :");

        // Check si la commande rentrée est une string de 2 caractères
        if (deplacement.length() == 2) {
            String oldL = deplacement.substring(0, 1);
            String oldN = deplacement.substring(1, 2);
            oldLetter = oldL;
            oldNumber = oldN;
            
            if (p.xMap().containsKey(oldL) && p.yMap().containsKey(oldN)) {
                if (p.getPlateau()[p.yMap().get(oldN)][p.xMap().get(oldL)].getPiece() != null && p.getPlateau()[p.yMap().get(oldN)][p.xMap().get(oldL)].getPiece() != null) {
                    name = p.getPlateau()[p.yMap().get(oldN)][p.xMap().get(oldL)].getPiece().getName();
                    team = p.getPlateau()[p.yMap().get(oldN)][p.xMap().get(oldL)].getPiece().getTeam();

                    collision(p, oldN, oldL);
                    p.getPlateau()[p.yMap().get(oldN)][p.xMap().get(oldL)].setPiece(null);
                    return;
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

            	if (p.xMap().containsKey(newL) && p.yMap().containsKey(newN)) {
            		Integer oldN = p.yMap().get(oldNumber);
            		Integer oldL = p.xMap().get(oldLetter);

            		if (p.getPlateau()[oldN][oldL].getPiece() != null) {
            			
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
