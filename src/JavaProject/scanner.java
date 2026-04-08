package JavaProject;
import java.util.Scanner;
import java.util.InputMismatchException;

public class scanner{
    static Scanner sc = new Scanner(System.in);

    public static int InicializarScannerINT(){
        while (true){
            try {
                int x = sc.nextInt();
                sc.nextLine();
                return x;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Ingresó un caracter erróneo, por favor, ingrese un número entero.");
            }
        
        }
    }

    public static String InicializarScannerSTR(){
    	String x = sc.nextLine();
        return x;
    }
}
