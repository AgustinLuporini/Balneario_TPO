public abstract class Carpa {

    protected String nombre;
    protected int capacidad;
    protected double precio;

    public Carpa(String nombre, int precio, int capacidad){
        this.nombre=nombre;
        this.precio=precio;
        this.capacidad=capacidad;
    }

    public void actualizarPrecio(int precio){
        this.precio = precio;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }
    public String getNombre(){return this.nombre;}

    public abstract void agrandar();
    public abstract void achicar();


}
