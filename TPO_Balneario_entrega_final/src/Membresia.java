public class Membresia {
    private String nombre;
    private int precio;

    public Membresia(String nombre, int precio){
        this.nombre=nombre;this.precio=precio;
    }

    public void actualizarPrecio(int precio){
        this.precio= precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public void setPrecio(int precio){this.precio=precio;}


    public String getNombre() {
        return this.nombre;
    }
}
