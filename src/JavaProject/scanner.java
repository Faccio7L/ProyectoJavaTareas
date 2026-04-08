package JavaProject;
import java.util.Scanner;

public class scanner{
    static Scanner sc = new Scanner(System.in);
    public static int InicializarScannerINT(){
        int x = sc.nextInt();
        sc.nextLine(); 
        return x;
    }
    public static String InicializarScannerSTR(){
    	String x = sc.nextLine();
        sc.nextLine(); 
        return x;
    }
}
