import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    List<String> opciones = Arrays.asList(
            "1-Registrar reservas",
            "2-Actualizar membresias",
            "3-Actualizar precio carpas/sombrillas",
            "4-Acceso al privilegio",
            "5-Ver información carpa, sombrilla y privilegios",
            "6-Mostrar privilegios para mayores",
            "0-Salir del sistema");
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> verOpciones() {
        System.out.println();
        System.out.println("Elija una opción:");

        for (String opcion : this.opciones) {
            System.out.println(opcion);
        }
        return opciones;
    }

    public int tomarOpcion() {
        int numero;
        while (true) {
            System.out.println("Ingrese el número de opción:");
            try {
                numero = Integer.parseInt(scanner.nextLine());

                if (numero >= 0 && numero <= opciones.size()-1) {
                    return numero;
                } else {
                    System.out.println("Ingrese un número válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");

            }
        }

    }

    public void ejecOpcion(int opc, Balneario balneario) {

        if (opc == 1) {
            System.out.println("Registrar reserva:");
            opcion1(balneario);
        }
        if (opc == 2) {
            System.out.println("Actualizar membresias.");
            opcion2(balneario);
        }
        if (opc == 3) {
            System.out.println("Actualizar precios carpa/sombrilla.");
            opcion3(balneario);
        }
        if (opc == 4){
            System.out.println("Acceso permitido al privilegio.");
            opcion4(balneario);
        }
        if (opc == 5){
            System.out.println("Información:");
            opcion5(balneario);
        }

        if (opc == 6){
            System.out.println("Información:");
            opcion6(balneario);
        }

        if (opc == 0) {
            System.out.println("Saliendo del sistema...");
        }

    }




    public void opcion1(Balneario balneario){
        //Variables
        int dni;
        int membresia;
        int carpa;

        //DNI
        System.out.println("Ingrese el número de DNI: ");
        try{
            dni = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Ingreso un DNI invalido");
            return;
        }

        //Membresia
        System.out.println("Elija la membresía");
        balneario.mostrarMembresias();
        System.out.println("Ingrese el número de la membresía deseada: ");
        try{
            membresia = Integer.parseInt(scanner.nextLine());
            if (membresia<1 || membresia>balneario.getMembresias().size()){
                System.out.println("Ingreso una opción invalida");
                return;
            }
        }catch (Exception e){
            System.out.println("Ocurrió un error, intente de nuevo.");
            return;
        }

        //Carpa
        System.out.println("Elija la carpa");
        balneario.mostrarCarpas();
        System.out.println("Ingrese el número de la carpa deseada: ");
        try{
            carpa = Integer.parseInt(scanner.nextLine());
            if (carpa<1 || carpa>balneario.getMembresias().size()){
                System.out.println("Ingreso una opción invalida");
                return;
            }
        }catch (Exception e){
            System.out.println("Ocurrió un error, intente de nuevo.");
            return;
        }/*
        System.out.println("¿Le gustaría agrandar su carpa por un 25% extra, o achicar por un 25% de descuento?");
        System.out.println("Opciones:");
        System.out.println("1-Agrandar");
        System.out.println("2-Achicar");
        System.out.println("Ingrese cualquier caracter en caso negativo");
        String rta = scanner.nextLine();
        if (rta.equals("1")){
            balneario.crearReserva(
                    balneario.getCarpa().get(carpa-1).agrandar(),
                    balneario.getMembresias().get(membresia-1),
                    dni);
            return;
        }
        if (rta.equals("2")){
            balneario.crearReserva(
                    balneario.getCarpa().get(carpa-1).achicar(),
                    balneario.getMembresias().get(membresia-1),
                    dni);
            return;
        }
        */
        balneario.crearReserva(
                balneario.getCarpa().get(carpa-1),
                balneario.getMembresias().get(membresia-1),
                dni);

    }



    public void opcion2(Balneario balneario){
        List<Membresia> membresias = balneario.getMembresias();
        System.out.println("Opciones: ");
        balneario.mostrarMembresias();
        System.out.println("Ingrese el número de opción: ");
        try{
            int opc = Integer.parseInt(scanner.nextLine());
            if (opc<1 || opc>balneario.getMembresias().size()){
                System.out.println("Ingreso una opción invalida");
                return;
            }else{
                System.out.println("Nuevo precio: ");
                int nuevoPrecio = Integer.parseInt(scanner.nextLine());
                membresias.get(opc-1).setPrecio(nuevoPrecio);
            }
        }catch (Exception e){
            System.out.println("Ocurrió un error, intente de nuevo.");
        }
    }



    public void opcion3(Balneario balneario){
        System.out.println("¿Quiere actualizar precio de la carpa o de la sombrilla?");
        balneario.mostrarCarpas();
        try{
            int opc = Integer.parseInt(scanner.nextLine());
            if (opc<1 || opc>balneario.getCarpa().size()){
                System.out.println("Ingreso una opción invalida");
                return;
            }else{
                System.out.println("Nuevo precio: ");
                int nuevoPrecio = Integer.parseInt(scanner.nextLine());
                balneario.getCarpa().get(opc-1).setPrecio(nuevoPrecio);
            }
        }catch (Exception e){
            System.out.println("Ocurrió un error, intente de nuevo.");
        }
    }

    private void printOpc4(Balneario balneario, Privilegio privilegio){
        System.out.println("DNIs habilitados para el acceso al privilegio:");
        for (Reserva reserva : balneario.getReservas()){
            if (privilegio.puedeEntrar(reserva)){
                System.out.println(reserva.getDni());
            }
        }
    }


    public void opcion4(Balneario balneario){
        List<Privilegio> privilegios = balneario.getPrivilegios();
        System.out.println("Opciones: ");
        for (int i = 0; i < privilegios.size() ; i++) {
            System.out.println((i+1) + "-" + privilegios.get(i).getNombre());
        }
        int opc = 0;
        try{
            opc = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Ingreso un número invalido");
        }
        if (opc<1 || opc>7){
            System.out.println("Número de opción invalido");
            return;
        }else{
            printOpc4(balneario, privilegios.get(opc-1));
        }
    }

    public void opcion5(Balneario balneario){
        balneario.mostrarInfo();
    }
    public void opcion6(Balneario balneario){
        System.out.println("Privilegios para mayores de edad: ");
        List<Privilegio> privilegiosMayores18 =
                balneario.getPrivilegios().stream()
                .filter(Privilegio::getMayor18)
                        .collect(Collectors.toList());

        for(Privilegio privilegio : privilegiosMayores18){
            System.out.println(privilegio.getNombre());
        }
    }




}



