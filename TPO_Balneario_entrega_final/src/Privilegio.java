import java.util.List;
import java.util.ArrayList;


public class Privilegio implements Informables {
    private List<Membresia> miembros = new ArrayList<>();

    private boolean mayor18;
    private String nombre;

    Privilegio(String nombre, boolean m18){
        this.nombre = nombre;
        this.mayor18 = m18;
    }
    public boolean puedeEntrar(Reserva reserva){
        return (miembros.contains(reserva.getMembresia()));
    }

    public void agregarMiembros(Membresia membresia){
        miembros.add(membresia);
    }

    public void mostrarInfo(){
        System.out.println("Los privilegios del balneario no se pueden comprar. Vienen incluidos con cada membresía" +
                "Horario de apertura y cierre de los privilegios: 08:00 - 16:00");
    }

    public String getNombre(){
        return this.nombre;
    }
    public boolean getMayor18(){
        return this.mayor18;
    }

}
