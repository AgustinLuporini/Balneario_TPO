import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Privilegio {
    private List<Membresia> miembros = new ArrayList<>();

    public boolean puedeEntrar(Reserva reserva){
        return (miembros.contains(reserva.getMembresia()));
    }

    public void agregarMiembros(Membresia membresia){
        miembros.add(membresia);
    }

}
