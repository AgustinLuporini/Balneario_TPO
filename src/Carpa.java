public class Carpa {
//    private int capacidad = 4;
  //  private int precio = 10000;
    private int capacidad;
    private int precio;

    public Carpa(int precio, int capacidad){
        this.precio=precio;
        this.capacidad=capacidad;
    }

    public void actualizarPrecio(int precio){
        this.precio = precio;
    }
    public int getPrecio(){
        return this.precio;
    }
}
