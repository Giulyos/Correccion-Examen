public class Estante {
    int fil, col;
    Meds[][] estante;
    String[][] visual;
    View view;
    Meds med;

    public Estante(int filas, int columnas){
        view = new View();
        estante = new Meds[filas][columnas];
        visual = new String[filas][columnas];
        fil = filas;
        col = columnas;
    }

    public void print(){
        int i;
        int j;
        for(i = 0 ; i < fil ; i++){
            view.print("\n");
            for(j = 0 ; j < col ; j++){
                System.out.print(visual[i][j] + " ");
            }
        }
    }

    public void guardar(){
        boolean prueba = false;
        int filG = -1;
        int colG = -1;
        while(prueba == false){
            filG = view.pedirInt("Digite la fila a la que desea agregar: ");
            colG = view.pedirInt("Digite la columna a la que desea agregar: ");
            if (0 < filG && filG < fil && 0 < colG && colG < col){
                if(visual[filG][colG] == null){
                prueba = true;
                }
            }
            else{
                view.print("Intente de nuevo :(\n");    
            }
        }
        String nombre = view.pedirStr("Digite el nombre del medicamento: ");
        String tamano = view.pedirStr("Digite el tamano del medicamento: ");
        String instru = view.pedirStr("Digite las instrucciones de uso del medicamento: ");
        String tipo = view.pedirStr("Digite el tipo de medicamento (pastilla, crema, jarabe): ");
        med = new Meds(nombre, tamano, instru, tipo);
        String text = med.getNombre() + ": " + med.getTamano();
        visual[filG][colG] = text;
        estante[filG][colG] = med;
    }

    public void entrega(){
        boolean prueba = false;
        int filE = -1;
        int colE = -1;
        String name, fecha;
        while(prueba == false){
            filE = view.pedirInt("Digite la fila en la que esta el medicamento que desea entregar: ");
            colE = view.pedirInt("Digite la columna en la que esta el medicamento que desea entregar: ");
            if(0 < filE && filE < fil && 0 < colE && colE < col){
                if(visual[filE][colE] != null){
                    prueba = true;
                }
            }
            else{
                view.print("Intente de nuevo :(\n");    
            }
        }
        name = view.pedirStr("Persona que recibe el medicamento: ");
        fecha = view.pedirStr("Dia en el que recibe el medicamento: ");
        Meds entrada = estante[filE][colE];
        entrada.name(name);
        entrada.fecha(fecha);
        entrada.genEtiqueta();
        estante[filE][colE] = null;
        visual[filE][colE] = null;
    }

    public void stats(){
        int i, j;
        int crema = 0;
        int pastilla = 0;
        int jarabe = 0;
        int count = 0;
        String tipo;
        double porCrema;
        double porPastilla;
        double porJarabe;
        Meds entrada;

        for(i = 0 ; i < fil ; i++){
            for(j = 0 ; j < col ; j++){
                if(visual[i][j] != null){
                    count++;
                    entrada = estante[i][j];
                    tipo = entrada.getTipo();
                    if(tipo.equals("pastilla")){
                        pastilla++;
                    }if(tipo.equals("jarabe")){
                        jarabe++;
                    }if(tipo.equals("crema")){
                        crema++;
                    }
                }
            }
        }
        porCrema = (double)crema*100/(double)count;
        porPastilla = (double)pastilla*100/(double)count;
        porJarabe = (double)jarabe*100/(double)count;
        System.out.print("\n" + porPastilla + "% de pastillas, " + porJarabe + "% de jarabes, " + porCrema + "% de cremas.");

    }
}
