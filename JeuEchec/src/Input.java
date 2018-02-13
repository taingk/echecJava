import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public String getInput() {
        System.out.println();
        System.out.print("> ");
        return input.nextLine();
    }

}
