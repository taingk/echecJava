
public class Jeu {

    public void menu() {
    	Input input = new Input();
        System.out.println("Bienvenue sur le jeu d'échecs");
        boolean start = false;

        System.out.println("[1] Lancer le jeu");
        System.out.println("[0] Quitter le jeu");

        while (!start) {
            String choice = input.getInput();

            if (choice.equals("1")) {
                start = true;
                System.out.println("C'est parti");
                this.boucleJeu();
            } else if (choice.equals("0")) {
                start = true;
                System.out.println("A bientôt !");
            } else {
                System.out.println("Commande inconnue");
            }
        }
    }

    public void boucleJeu() {
        Plateau p = new Plateau();
        Deplacement d = new Deplacement();
        p.initMap();
        // Boucle de jeu
        p.displayPlateau();
        d.oldDeplacement(p);
        d.newDeplacement(p);
        p.displayPlateau();
    }
}
