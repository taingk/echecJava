import java.util.HashMap;

public class Plateau {

    private Case[][] plateau = new Case[8][8];
    private String[] xLetters = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private String[] yNum = {"8", "7", "6", "5", "4", "3", "2", "1"};
    private HashMap<String, Integer> xPos = new HashMap<>();
    private HashMap<String, Integer> yPos = new HashMap<>();

    public HashMap<String, Integer> yMap() {
    	return yPos;
    }
    
    public HashMap<String, Integer> xMap() {
    	return xPos;
    }
    
    public String[] getxLetters() {
        return xLetters;
    }

    public String[] getyNum() {
        return yNum;
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public Plateau() {
        initPlateau();
    }

    public void initMap() {
        for (Integer i = 0; i < xLetters.length; i++) {
            xPos.put(xLetters[i], i);
        }
        for (Integer j = 0; j < yNum.length; j++) {
            yPos.put(yNum[j], j);
        }
    }
    
    public void initPlateau() {
        // Initialise le plateau de jeu, 8x8 objet Case
        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau.length; j++) {
                plateau[i][j] = new Case();
            }
        }

        // Place les pions sur le plateau[1] et [6]
        for (int i = 0; i < plateau.length; i++) {
            plateau[1][i].setPiece(new Pion(0));
            plateau[2][i].setPiece(new Pion(0));
            plateau[6][i].setPiece(new Pion(1));
        }

        // Place les autres pions selon l'ordre de la team 0
        plateau[0][0].setPiece(new Tour(0));
        plateau[0][1].setPiece(new Cavalier(0));
        plateau[0][2].setPiece(new Fou(0));
        plateau[0][3].setPiece(new Reine(0));
        plateau[0][4].setPiece(new Roi(0));
        plateau[0][5].setPiece(new Fou(0));
        plateau[0][6].setPiece(new Cavalier(0));
        plateau[0][7].setPiece(new Tour(0));

        // Place les autres pions selon l'ordre de la team 1
        plateau[7][0].setPiece(new Tour(1));
        plateau[7][1].setPiece(new Cavalier(1));
        plateau[7][2].setPiece(new Fou(1));
        plateau[7][3].setPiece(new Reine(1));
        plateau[7][4].setPiece(new Roi(1));
        plateau[7][5].setPiece(new Fou(1));
        plateau[7][6].setPiece(new Cavalier(1));
        plateau[7][7].setPiece(new Tour(1));
    }

    public void displayPlateau() {
        String sign;

        System.out.println();
        // Boucle qui affiche les cases
        for(Integer i = 0; i < plateau.length; i++)
        {
            // Affiche les nums par lignes
            System.out.printf("%s ", yNum[i]);

            // Affiche les pièces
            for(Integer j = 0; j < plateau.length; j++)
            {
                if (plateau[i][j].getPiece() != null) {
                    sign = plateau[i][j].getPiece().getName().substring(0, 3);
                    System.out.printf("[%s]", sign);
                } else {
                    System.out.print("[   ]");
                }
            }
            System.out.println();

            // Affiche les lettres par colonnes
            if (i.equals(7)) {
                System.out.print("  ");
                for (int k = 0; k < xLetters.length; k++) {
                    System.out.printf("  %s  ", xLetters[k]);
                }
            }
        }
        System.out.println();
    }
    
    public void createPiece(String name, Integer team, String newN, String newL) {
		switch (name) {
		case "Pion":
			getPlateau()[yMap().get(newN)][xMap().get(newL)].setPiece(new Pion(team));
			break;
		case "Tour":
			getPlateau()[yMap().get(newN)][xMap().get(newL)].setPiece(new Tour(team));
			break;
		case "Cavalier":
			getPlateau()[yMap().get(newN)][xMap().get(newL)].setPiece(new Cavalier(team));
			break;
		case "Fou":
			getPlateau()[yMap().get(newN)][xMap().get(newL)].setPiece(new Fou(team));
			break;
		case "Reine":
			getPlateau()[yMap().get(newN)][xMap().get(newL)].setPiece(new Reine(team));
			break;
		case "Roi":
			getPlateau()[yMap().get(newN)][xMap().get(newL)].setPiece(new Roi(team));
			break;
		default:
			break;
		}

    }

}
