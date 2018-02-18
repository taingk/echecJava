import java.util.ArrayList;

public class Jeu {

	public void menu() {
		Input input = new Input();
		System.out.println("Bienvenue sur le jeu d'echec");
		boolean start = false;

		while (!start) {
			String choice = input.getInput("[1] Lancer le jeu \n[0] Quitter le jeu");

			if (choice.equals("1")) {
				start = true;
				System.out.println("C'est parti");
				this.boucleJeu();
			} else if (choice.equals("0")) {
				start = true;
				System.out.println("A bientot !");
			} else {
				System.out.println("Commande inconnue");
			}
		}
	}

	public void boucleJeu() {
		Plateau p = new Plateau();
		Deplacement d = new Deplacement();
		// Boucle de jeu

		Integer player = 0;

		while (checkKings(p).size() == 2){
			p.displayPlateau();

			if (player.equals(0)) {
				player = 1;
			} else {
				player = 0;
			}

			d.deplacement(p, player);
		}
		
		if(player.equals(0)){
			System.out.println("Le player 1 à gagné la partie");	
		}else{
			System.out.println("Le player 2 à gagné la partie");
		}
	}

	public ArrayList<Integer> checkKings(Plateau p) {
    	
    		ArrayList<Integer> kings = new ArrayList<Integer>();
		for(int i = 0; i < p.getPlateau().length; i++) {
            for(int j = 0; j < p.getPlateau().length; j++) {
            		if(p.getPiece(i, j) != null) {
            			if(p.getPiece(i, j).getName().equals("Roi")) {
            				kings.add(i);
            				
            		}

            		}
            	}
         }
            
           
            return kings;
	}
}
