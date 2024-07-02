import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class Balneario {
    private List<Carpa> carpas = new ArrayList();
    private List<Membresia> membresias = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Privilegio> privilegios = new ArrayList<>();



    public void agregarMembresia(Membresia membresia){
        this.membresias.add(membresia);
    }


    public void agregarCarpa(Carpa carpa){
        this.carpas.add(carpa);
    }

    public void agregarPrivilegio(Privilegio privilegio){
        this.privilegios.add(privilegio);
    }

    public void crearReserva (Carpa carpa, Membresia membresia, int dni){
        Reserva reserva = new Reserva(carpa, membresia, dni);
        reservas.add(reserva);
    }

    public List<Reserva> getReservas(){
        return  this.reservas;
    }
    public List<Privilegio> getPrivilegios(){
        return  this.privilegios;
    }
    public List<Membresia> getMembresias() {return membresias;}

    public List<Carpa> getCarpa() {return carpas;}


    public void mostrarInfo(){
        Privilegio privilegio = new Privilegio("x",false);
        privilegio.mostrarInfo();
        System.out.println();
        CarpaFamiliar carpaF = new CarpaFamiliar("x",15000,4);
        carpaF.mostrarInfo();
        System.out.println();
        CarpaSobrilla sombrilla = new CarpaSobrilla("x",9000, 2);
        sombrilla.mostrarInfo();
        System.out.println();
    }

    public void mostrarMembresias(){
        for (int i = 0; i < membresias.size() ; i++) {
            System.out.println((i+1) + "-" + membresias.get(i).getNombre());
        }
    }
    public void mostrarPrivilegios(){
        for (int i = 0; i < privilegios.size() ; i++) {
            System.out.println((i+1) + "-" + privilegios.get(i).getNombre());
        }
    }

    public void mostrarCarpas(){
        for (int i = 0; i < carpas.size() ; i++) {
            System.out.println((i+1) + "-" + carpas.get(i).getNombre());
        }

    }


}
