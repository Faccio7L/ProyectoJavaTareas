package JavaProject;
import java.util.Scanner;

public class scanner {
    private static Scanner sc = new Scanner(System.in);

    public static int InicializarScanner() {
        int x = sc.nextInt();
        sc.nextLine(); 
        return x;
    }
}
