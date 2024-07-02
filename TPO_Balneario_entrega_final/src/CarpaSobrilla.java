public class CarpaSobrilla extends Carpa implements Informables{
    public CarpaSobrilla(String nombre, int precio, int capacidad) {
        super(nombre, precio, capacidad);
    }

    public void mostrarInfo(){
        System.out.println("Las sombrillas son una opción económica para disfrutar de un día de playa y " +
                "los beneficios del balneario " +
                "Horario de apertura y cierre de las carpas: 06:00 - 20:00");
    }

    @Override
    public void agrandar() {
        this.capacidad += 2;
        this.precio = this.precio * 1.25;
    }

    @Override
    public void achicar() {
        this.capacidad -= 2;
        this.precio = this.precio * 0.75;
    }
}
