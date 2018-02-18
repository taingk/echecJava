import java.util.HashMap;

public class Plateau {

    private Case[][] plateau = new Case[8][8];
    private String[] aCol = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private String[] aRow = {"8", "7", "6", "5", "4", "3", "2", "1"};
    private HashMap<String, Integer> hCol = new HashMap<>();
    private HashMap<String, Integer> hRow = new HashMap<>();

    public HashMap<String, Integer> getHRow() {
    	return hRow;
    }
    
    public HashMap<String, Integer> getHCol() {
    	return hCol;
    }
    
    public String[] getACol() {
        return aCol;
    }

    public String[] getARow() {
        return aRow;
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public Plateau() {
        initPlateau();
    }
    
    public Piece getPiece(Integer row, Integer col) {
    	return getPlateau()[row][col].getPiece();
    }
    
    public void setPiece(Integer row, Integer col, Piece piece) {
    	getPlateau()[row][col].setPiece(piece);
    }
    
    public Case getPos(Integer row, Integer col) {
    	return getPlateau()[row][col];
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
            plateau[1][i].setPiece(new Pion(0, 2));
            plateau[6][i].setPiece(new Pion(1, 2));
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
        for (Integer i = 0; i < aCol.length; i++) {
            hCol.put(aCol[i], i);
        }
        for (Integer j = 0; j < aRow.length; j++) {
            hRow.put(aRow[j], j);
        }
    }

    public void displayPlateau() {
        String sign;

        System.out.println();
        // Boucle qui affiche les cases
        for(Integer i = 0; i < plateau.length; i++)
        {
            // Affiche les nums par lignes
            System.out.printf("%s ", aRow[i]);

            // Affiche les pieces
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
                for (int k = 0; k < aCol.length; k++) {
                    System.out.printf("  %s  ", aCol[k]);
                }
            }
        }
        System.out.println();
    }
    
    public void createPiece(String name, Integer team, Integer row, Integer col) {
		switch (name) {
		case "Pion":
			getPlateau()[row][col].setPiece(new Pion(team, 2));
			break;
		case "Tour":
			getPlateau()[row][col].setPiece(new Tour(team));
			break;
		case "Cavalier":
			getPlateau()[row][col].setPiece(new Cavalier(team));
			break;
		case "Fou":
			getPlateau()[row][col].setPiece(new Fou(team));
			break;
		case "Reine":
			getPlateau()[row][col].setPiece(new Reine(team));
			break;
		case "Roi":
			getPlateau()[row][col].setPiece(new Roi(team));
			break;
		default:
			break;
		}

    }

}
