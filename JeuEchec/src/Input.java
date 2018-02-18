import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public String getInput(String message) {
    	System.out.println();
        System.out.println(message);
        System.out.print("> ");
        return input.nextLine();
    }

    public String getInput(String message, Integer player) {
    	System.out.println();
        System.out.println(message);
        System.out.print("Joueur " + (player + 1) +" > ");
        return input.nextLine();
    }

}