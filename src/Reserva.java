public class Reserva {
    private Membresia membresia;
    private Carpa carpa;
    private int dni;

    public Reserva(Carpa carpa, Membresia membresia, int dni){
        this.carpa = carpa;
        this.membresia = membresia;
        this.dni = dni;
    }

    public int calcularPrecio(){
        return carpa.getPrecio() + membresia.getPrecio();
    }

    public int getDni(){return this.dni;}

    //public Carpa getCarpa(){return this.carpa;}
    public Membresia getMembresia(){
        return this.membresia;
    }
}
