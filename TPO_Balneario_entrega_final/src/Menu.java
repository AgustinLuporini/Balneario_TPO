import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void verOpciones() {
        System.out.println();
        System.out.println("Elija una opción:");

        String[] opciones = {
                "1-Registrar reservas",
                "2-Actualizar membresias",
                "3-Actualizar precio carpas/sombrillas",
                "4-Acceso al privilegio",
                "0-Salir del sistema",
                ""
        };

        for (String opcion : opciones) {
            System.out.println(opcion);
        }
    }

    public int tomarOpcion() {
        int numero;
        while (true) {
            System.out.println("Ingrese el número de opción:");
            try {
                numero = Integer.parseInt(scanner.nextLine());

                if (numero >= 0 && numero <= 4) {
                    return numero;
                } else {
                    System.out.println("Ingrese un número válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");

            }
        }

    }

    public void ejecOpcion(int opc, CarpaFamiliar carpaF, CarpaSobrilla sombrilla,
                           Membresia vip, Membresia intermedio, Membresia base, Balneario balneario,
                           Privilegio banio, Privilegio pileta, Privilegio buffet, Privilegio guarderia) {

        if (opc == 1) {
            System.out.println("Registrar reserva:");
            opcion1(vip,intermedio,base, carpaF, sombrilla, balneario);
        }
        if (opc == 2) {
            System.out.println("Actualizar membresias.");
            opcion2(vip, intermedio, base);
        }
        if (opc == 3) {
            System.out.println("Actualizar precios carpa/sombrilla.");
            opcion3(carpaF, sombrilla);
        }
        if (opc == 4){
            System.out.println("Acceso permitido al privilegio.");
            opcion4(balneario, banio, pileta, buffet, guarderia);
        }
        if (opc == 0) {
            System.out.println("Saliendo del sistema...");
        }

    }


    public void opcion1(Membresia vip, Membresia intermedio, Membresia base,
                        CarpaFamiliar carpaF, CarpaSobrilla sombrilla,
                        Balneario balneario){

        //Registrar id
        int dni;
        Membresia membresia = null;
        int membresiaOpc;
        Carpa carpa = null;
        int carpaOpc;

        //Validación DNI
        System.out.println("Ingrese un número de DNI: ");
        try {
            dni = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Ocurrio un error, intente de nuevo.");
            return;
        }

        //Elegir membresia
        System.out.println();
        System.out.println("Seleccione la membresía para la reserva:");
        System.out.println("1-VIP");
        System.out.println("2-Intermedio");
        System.out.println("3-Base");
        System.out.println("Ingrese su opción: ");
        //Validación membresia
        try{
            membresiaOpc = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Ingresó una opción invalida");
            return;
        }
        if ((membresiaOpc <1) || (membresiaOpc>3)){
            System.out.println("Ingresó una opción invalida");
            return;
        }else{
            if (membresiaOpc == 1){
                membresia = vip;
            }
            if (membresiaOpc == 2){
                membresia = intermedio;
            }
            if (membresiaOpc == 3){
                membresia = base;
            }
        }

        //Elergir carpa
        System.out.println("Elija la carpa que desea: ");
        System.out.println("1-Carpa familiar");
        System.out.println("2-Sombrilla");
        System.out.println("Ingrese su opción: ");
        //Validación carpa
        try{
            carpaOpc = Integer.parseInt(scanner.nextLine());
        }
        catch(Exception e){
            System.out.println("Ingresó una opción invalida");
            return;
        }

        if (carpaOpc<1 || carpaOpc>2){
            System.out.println("Ingresó una opción invalida");
            return;
        }else{
            if (carpaOpc == 1){
                carpa = carpaF;
            }
            if (carpaOpc == 2){
                carpa = sombrilla;
            }
        }

        //Agregar reserva al balneario
        if ((carpa != null) && (membresia != null)){
            balneario.crearReserva(carpa, membresia, dni);
            System.out.println("Reserva registrada");
        }
    }


    public void opcion2(Membresia vip, Membresia intermedio, Membresia base) {
        while (true) {
            System.out.println("Seleccione la membresía a actualizar:");
            System.out.println("1-VIP");
            System.out.println("2-Intermedio");
            System.out.println("3-Base");
            System.out.print("Ingrese su opción: ");

            try {
                int opc = Integer.parseInt(scanner.nextLine());
                if (opc >= 1 && opc <= 3) {
                    System.out.print("Ingrese el nuevo precio: ");
                    int nuevoPrecio = Integer.parseInt(scanner.nextLine());
                    switch (opc) {
                        case 1:
                            vip.actualizarPrecio(nuevoPrecio);
                            System.out.println("El precio de la membresía VIP ahora es de: " + vip.getPrecio());
                            break;
                        case 2:
                            intermedio.actualizarPrecio(nuevoPrecio);
                            System.out.println("El precio de la membresía Intermedio ahora es de: " + intermedio.getPrecio());
                            break;
                        case 3:
                            base.actualizarPrecio(nuevoPrecio);
                            System.out.println("El precio de la membresía Base ahora es de: " + base.getPrecio());
                            break;
                    }
                    return;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor numérico válido.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error, intente de nuevo.");
            }
        }
    }



    public void opcion3(CarpaFamiliar carpaF, CarpaSobrilla sombrilla) {
        int opc;

        while (true) {
            System.out.println("¿Quiere actualizar precio de la carpa o de la sombrilla?");
            System.out.println("1-Carpa familiar");
            System.out.println("2-Sombrilla");
            System.out.println("Ingrese su opción: ");

            try {
                opc = Integer.parseInt(scanner.nextLine());
                if (opc == 1) {
                    System.out.print("Ingrese el nuevo precio de la carpa: ");
                    int precio = Integer.parseInt(scanner.nextLine());
                    carpaF.actualizarPrecio(precio);
                    System.out.println("El precio de la carpa ahora es de: "+carpaF.getPrecio());
                    return;
                }
                if (opc == 2) {
                    System.out.print("Ingrese el nuevo precio de la sombrilla: ");
                    int precio = Integer.parseInt(scanner.nextLine());
                    sombrilla.actualizarPrecio(precio);
                    System.out.println("El precio de la sombrilla ahora es de: "+sombrilla.getPrecio());
                    return;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor numérico válido.");
            } catch (Exception e){
                System.out.println("Ocurrio un error, intente de nuevo.");
            }
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

    public void  opcion4(Balneario balneario,
                         Privilegio banio, Privilegio pileta, Privilegio buffet, Privilegio guarderia){
        int opc=0;
        System.out.println("Opciones: ");
        System.out.println("1-Baño");
        System.out.println("2-Pileta");
        System.out.println("3-Buffet");
        System.out.println("4-Guardería");
        System.out.println("Ingrese el número correspondiente al privilegio");
        try{
            opc = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Ingrese un número valido");
        }
        if (opc<1 || opc>4){
            System.out.println("Número de opción invalido");
            return;
        }
        if (opc == 1){
            printOpc4(balneario,banio);
        }
        if (opc == 2){
            printOpc4(balneario,pileta);
        }
        if (opc == 3){
            printOpc4(balneario, buffet);
        }
        if (opc == 4){
            printOpc4(balneario, guarderia);
        }
    }




}



