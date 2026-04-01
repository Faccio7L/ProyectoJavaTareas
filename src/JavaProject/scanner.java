package JavaProject;
import java.util.Scanner;

public class scanner {
    private static Scanner sc = new Scanner(System.in); 
 // como es static se crea el objeto al invocar cualquier metoodo de la clase.
    public static int InicializarScanner() {
        int x = sc.nextInt();
        sc.nextLine(); 
        return x;
    }
}
