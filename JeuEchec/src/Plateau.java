import java.util.HashMap;

public class Plateau {

    private Case[][] plateau = new Case[8][8];
    private String[] xLetters = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private String[] yNum = {"8", "7", "6", "5", "4", "3", "2", "1"};
    private HashMap<String, Integer> xPos = new HashMap<>();
    private HashMap<String, Integer> yPos = new HashMap<>();

    public HashMap<String, Integer> getyPos() {
    	return yPos;
    }
    
    public HashMap<String, Integer> getxPos() {
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
    
    public void initPlateau() {
        // Initialise le plateau de jeu, 8x8 objet Case
        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau.length; j++) {
                plateau[i][j] = new Case();
            }
        }

        // Place les pions sur le plateau ligne 1 et 6 pour les team 0 et 1
        for (int i = 0; i < plateau.length; i++) {
            plateau[1][i].setPiece(new Pion(0));
            plateau[2][i].setPiece(new Pion(0));
            plateau[6][i].setPiece(new Pion(1));
        }

        // Place les pièces restantes pour les teams 0 et 1
        for (int i = 0, j = 0; i < 2; i++, j = j + 7) {
            plateau[j][0].setPiece(new Tour(i));
            plateau[j][1].setPiece(new Cavalier(i));
            plateau[j][2].setPiece(new Fou(i));
            plateau[j][3].setPiece(new Reine(i));
            plateau[j][4].setPiece(new Roi(i));
            plateau[j][5].setPiece(new Fou(i));
            plateau[j][6].setPiece(new Cavalier(i));
            plateau[j][7].setPiece(new Tour(i));
        }
        
        // Initialise hashmap, les lettres et numéros du plateau sont liés 
        // aux positions "code". A8 devient plateau[0][0]
        for (Integer i = 0; i < xLetters.length; i++) {
            xPos.put(xLetters[i], i);
        }
        for (Integer j = 0; j < yNum.length; j++) {
            yPos.put(yNum[j], j);
        }
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
			getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Pion(team));
			break;
		case "Tour":
			getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Tour(team));
			break;
		case "Cavalier":
			getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Cavalier(team));
			break;
		case "Fou":
			getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Fou(team));
			break;
		case "Reine":
			getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Reine(team));
			break;
		case "Roi":
			getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Roi(team));
			break;
		default:
			break;
		}

    }

}
