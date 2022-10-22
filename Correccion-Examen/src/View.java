import java.util.Scanner;

public class View {
    static Scanner scan;

    public View(){
        scan = new Scanner(System.in);
    }

    public String pedirStr(String mensaje){
        System.out.print(mensaje);
        String txt = scan.nextLine();
        return txt;
    }

    public int pedirInt(String mensaje){
        System.out.print(mensaje);
        int num = Integer.parseInt(scan.nextLine());
        return num;
    }

    public void print(String mensaje){
        System.out.print(mensaje);
    }
}
