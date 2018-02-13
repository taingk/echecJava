import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public String getInput(String message) {
    	System.out.println();
        System.out.println(message);
        System.out.print("> ");
        return input.nextLine();
    }

}