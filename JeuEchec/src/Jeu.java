import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Jeu {
    private static Scanner input = new Scanner(System.in);
    private HashMap<String, Integer> xPos = new HashMap<>();
    private HashMap<String, Integer> yPos = new HashMap<>();
    private String name;
    private Integer team;

    public String getInput() {
        System.out.println();
        System.out.print("> ");
        return input.nextLine();
    }

    public void menu() {
        System.out.println("Bienvenue sur le jeu d'échecs");
        boolean start = false;

        System.out.println("[1] Lancer le jeu");
        System.out.println("[0] Quitter le jeu");

        while (!start) {
            String choice = getInput();

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
        initMap(p);
        // Boucle de jeu
        p.displayPlateau();
        oldDeplacement(p);
        newDeplacement(p);
        p.displayPlateau();
    }

    public void collision(Plateau p, String oldN, String oldL) {
        Integer l = xPos.get(oldL);
        Integer n = yPos.get(oldN);

        if (collisionAround(p, n, l)) {
            System.out.println("Je suis entouré");
        }
    }

    public boolean collisionAround(Plateau p, Integer n, Integer l) {
        if (p.getPlateau()[ n - 1 ][l].getPiece() != null)
        //        &&
          //      p.getPlateau()[ n + 1 ][l].getPiece() != null &&
            //    p.getPlateau()[ n ][l - 1].getPiece() != null &&
              //  p.getPlateau()[ n ][l + 1].getPiece() != null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkOutArray(Integer n) {
        if (n > 8 || n < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void oldDeplacement(Plateau p) {
        System.out.println();
        System.out.print("Veuillez saisir la pièce à déplacer :");
        String deplacement = getInput();

        // Check si la commande rentrée est une string de 2 caractères
        if (deplacement.length() == 2) {
            String oldL = deplacement.substring(0, 1);
            String oldN = deplacement.substring(1, 2);

            if (xPos.containsKey(oldL) && yPos.containsKey(oldN)) {
                if (p.getPlateau()[yPos.get(oldN)][xPos.get(oldL)].getPiece() != null && p.getPlateau()[yPos.get(oldN)][xPos.get(oldL)].getPiece() != null) {
                    name = p.getPlateau()[yPos.get(oldN)][xPos.get(oldL)].getPiece().getName();
                    team = p.getPlateau()[yPos.get(oldN)][xPos.get(oldL)].getPiece().getTeam();

                    collision(p, oldN, oldL);
                    p.getPlateau()[yPos.get(oldN)][xPos.get(oldL)].setPiece(null);
                    return;
                }
            }
        }
        System.out.println("Mauvaise commande");
        oldDeplacement(p);
    }

    public void newDeplacement(Plateau p) {
        System.out.println();
        System.out.print("Veuillez saisir la nouvelle position :");
        String deplacement = getInput();

        if (deplacement.length() == 2) {
            String newL = deplacement.substring(0, 1);
            String newN = deplacement.substring(1, 2);
            if (xPos.containsKey(newL) && yPos.containsKey(newN)) {
                switch (name) {
                    case "Pion":
                        p.getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Pion(team));
                        break;
                    case "Tour":
                        p.getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Tour(team));
                        break;
                    case "Cavalier":
                        p.getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Cavalier(team));
                        break;
                    case "Fou":
                        p.getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Fou(team));
                        break;
                    case "Reine":
                        p.getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Reine(team));
                        break;
                    case "Roi":
                        p.getPlateau()[yPos.get(newN)][xPos.get(newL)].setPiece(new Roi(team));
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

    public void initMap(Plateau p) {
        for (Integer i = 0; i < p.getxLetters().length; i++) {
            xPos.put(p.getxLetters()[i], i);
        }
        for (Integer j = 0; j < p.getyNum().length; j++) {
            yPos.put(p.getyNum()[j], j);
        }
    }

}
