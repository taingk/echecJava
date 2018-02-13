public class Deplacement {
    private String name;
    private Integer team;
    
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
        System.out.print("Veuillez saisir la pièce à déplacer sous forme A8 (Lettre majuscule et chiffre) :");
        String deplacement = input.getInput();

        // Check si la commande rentrée est une string de 2 caractères
        if (deplacement.length() == 2) {
            String oldL = deplacement.substring(0, 1);
            String oldN = deplacement.substring(1, 2);

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
        System.out.print("Veuillez saisir la nouvelle position :");
        String deplacement = input.getInput();

        if (deplacement.length() == 2) {
        	
            String newL = deplacement.substring(0, 1);
            String newN = deplacement.substring(1, 2);
            
            if (p.xMap().containsKey(newL) && p.yMap().containsKey(newN)) {
                switch (name) {
                    case "Pion":
                        p.getPlateau()[p.yMap().get(newN)][p.xMap().get(newL)].setPiece(new Pion(team));
                        break;
                    case "Tour":
                        p.getPlateau()[p.yMap().get(newN)][p.xMap().get(newL)].setPiece(new Tour(team));
                        break;
                    case "Cavalier":
                        p.getPlateau()[p.yMap().get(newN)][p.xMap().get(newL)].setPiece(new Cavalier(team));
                        break;
                    case "Fou":
                        p.getPlateau()[p.yMap().get(newN)][p.xMap().get(newL)].setPiece(new Fou(team));
                        break;
                    case "Reine":
                        p.getPlateau()[p.yMap().get(newN)][p.xMap().get(newL)].setPiece(new Reine(team));
                        break;
                    case "Roi":
                        p.getPlateau()[p.yMap().get(newN)][p.xMap().get(newL)].setPiece(new Roi(team));
                        break;
                    default:
                        break;
                }
                return;
            }
        }
        System.out.println("Mauvaise commande");
        newDeplacement(p);
    }
}