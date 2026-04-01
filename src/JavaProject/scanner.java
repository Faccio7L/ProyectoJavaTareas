package JavaProject;
import java.util.Scanner;

public class scanner {
    static Scanner sc = new Scanner(System.in); 
 // como es static se crea el objeto al invocar cualquier metoodo de la clase.
    public static int InicializarScannerINT() {
        int x = sc.nextInt();
        sc.nextLine(); 
        return x;
    }
    public static String InicializarScannerSTR() {
    	String x = sc.nextLine();
        sc.nextLine(); 
        return x;
    }
}
