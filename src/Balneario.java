import java.util.ArrayList;
import java.util.List;

public class Balneario {
    private List<Carpa> carpas = new ArrayList();
    private List<Membresia> membresias = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();


    public void agregarMembresia(Membresia membresia){
        this.membresias.add(membresia);
    }
    public List<Carpa> getCarpas(){
        return this.carpas;
    }

    public void agregarCarpa(Carpa carpa){
        this.carpas.add(carpa);
    }

    public void crearReserva (Carpa carpa, Membresia membresia, int dni){
        Reserva reserva = new Reserva(carpa, membresia, dni);
        reservas.add(reserva);
    }

    public List<Reserva> getReservas(){
        return  this.reservas;
    }
}
