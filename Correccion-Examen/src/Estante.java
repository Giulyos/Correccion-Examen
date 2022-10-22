public class Estante {
    int fil, col;
    Meds[][] estante;
    String[][] visual;
    View view;
    Meds med;

    public void print(){
        int i;
        int j;
        String entrada;
        for(i = 0 ; i < fil ; i++){
            view.print("\n");
            for(j = 0 ; j < col ; j++){
                System.out.print(visual[i][j] + " ");
            }
        }
    }

    public void guardar(){
        boolean prueba = false;
        int filG, colG;
        while(prueba == false){
            filG = view.pedirInt("Digite la fila a la que desea agregar: ");
            colG = view.pedirInt("Digite la columna a la que desea agregar: ");
            if (visual[filG][colG] == null && 0 < filG && filG < fil && 0 < colG && colG < col){
                prueba = true;
            }
        }
        String nombre = view.pedirStr("Digite el nombre del medicamento: ");
        String tamano = view.pedirStr("Digite el tamano del medicamento: ");
        String instru = view.pedirStr("Digite las instrucciones de uso del medicamento: ");
        String tipo = view.pedirStr("Digite el tipo de medicamento (pastilla, crema, jarabe): ");
        med = new Meds(nombre, tamano, instru, tipo);
        String text = med.getNombre() + ": " + med.getTamano();
        visual[filG][colG] = text;
    }

    public void entrega(){
        boolean prueba = false;
        int filE, colE;
        String name, fecha;
        Meds entrada;
        while(prueba == false){
            filE = view.pedirInt("Digite la fila en la que esta el medicamento que desea entregar: ");
            colE = view.pedirInt("Digite la columna en la que esta el medicamento que desea entregar: ");
            if(visual[filE][colE] != null && 0 < filE && filE < fil && 0 < colE && colE < col){
                prueba = true;
            }
        }
        name = view.pedirStr("Persona que recibe el medicamento: ");
        fecha = view.pedirStr("Dia en el que recibe el medicamento: ");
        estante[filE][colE].setName(name);
        estante[filE][colE].setFecha(fecha);
        entrada = estante[filE][colE];
        entrada.genEtiqueta();
        estante[filE][colE] = null;
        visual[filE][colE] = null;
    }

    public void stats(){
        
    }
}
