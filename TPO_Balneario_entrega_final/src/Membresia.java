public class Membresia {
    private int precio;

    public Membresia(int precio){
        this.precio=precio;
    }

    public void actualizarPrecio(int precio){
        this.precio= precio;
    }

    public int getPrecio(){
        return this.precio;
    }


}
