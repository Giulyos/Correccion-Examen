public class Controller {
    int filas, columnas, opcion;
    View view;
    Estante estante;

    public Controller(){
        view = new View();
        filas = view.pedirInt("Digite la cantidad de filas");
        columnas = view.pedirInt("Digite la cantidad de columnas");
    }

    public void run(){
        boolean prueba = true;
        while(prueba == true){
            view.print("\n1. Imprimir el estante\n2. Guardar un medicamento\n3. Entregar un medicamento\n4. Imprimir estad[isticas\n5. Terminar el programa\n");
            opcion = view.pedirInt("Elija una opcion: ");
            if(opcion == 1){
                estante.print();
            }if(opcion == 2){
                estante.guardar();
            }if(opcion == 3){
                estante.entrega();
            }if(opcion ==4){
                estante.stats();
            }if(opcion == 5){
                prueba = false;
                view.print("Se ha terminado el programa");
            }
        }
    }
}
