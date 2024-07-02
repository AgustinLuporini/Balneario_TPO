public class CarpaFamiliar extends Carpa implements Informables {
    public CarpaFamiliar(String nombre, int precio, int capacidad) {
        super(nombre, precio, capacidad);
    }

    public void mostrarInfo(){
        System.out.println("Las carpas familiares protegen a del sol y del viento para poder disfrutar un día entero de playa." +
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
