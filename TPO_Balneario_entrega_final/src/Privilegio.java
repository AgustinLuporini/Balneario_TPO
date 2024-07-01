import java.util.List;
import java.util.ArrayList;


public class Privilegio {
    private List<Membresia> miembros = new ArrayList<>();

    public boolean puedeEntrar(Reserva reserva){
        return (miembros.contains(reserva.getMembresia()));
    }

    public void agregarMiembros(Membresia membresia){
        miembros.add(membresia);
    }


}
