
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
        p.displayPlateau();
        d.oldPosition(p);
        d.newPosition(p);
        p.displayPlateau();
    }
}
