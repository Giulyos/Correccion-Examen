public class Meds {
    String nombre, tamano, instru, tipo, name, fecha;
    View view;

    public Meds(String nombre, String tamano, String instru, String tipo){
        this.nombre = nombre;
        this.tamano = tamano;
        this.instru = instru;
        this.tipo = tipo;
        view = new View();
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getTamano(){
        return this.tamano;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void name(String name){
        this.name = name;
    }

    public void fecha(String fecha){
        this.fecha = fecha;
    }

    public void genEtiqueta(){
        String mensaje;
        mensaje = "\n" + this.name + " - " + this.fecha + "\n\n" + this.instru + "\n" + this.nombre + ": " + this.tamano + ". " + this.tipo + ". \n";
        view.print(mensaje);
    }
}
