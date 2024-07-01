public class Main {
    public static void main(String[] args) {
        //Creación de membresías
        Membresia vip = new Membresia(20000);
        Membresia intermedio = new Membresia(10000);
        Membresia base = new Membresia(8500);
        //Creación carpas y sombrillas
        CarpaFamiliar carpaF = new CarpaFamiliar(15000,4);
        CarpaSobrilla sombrilla = new CarpaSobrilla(9000, 2);
        //Creación privilegios
        Privilegio banio = new Privilegio();
        Privilegio pileta = new Privilegio();
        Privilegio buffet = new Privilegio();
        Privilegio guarderia = new Privilegio();
        //Privilegios para cada membresía
        //Base
        banio.agregarMiembros(base);
        //Intermedio
        banio.agregarMiembros(intermedio);
        pileta.agregarMiembros(intermedio);
        //VIP
        banio.agregarMiembros(vip);
        pileta.agregarMiembros(vip);
        buffet.agregarMiembros(vip);
        guarderia.agregarMiembros(vip);

        //Creación balneario
        Balneario divisadero = new Balneario();

        divisadero.agregarMembresia(base);
        divisadero.agregarMembresia(intermedio);
        divisadero.agregarMembresia(vip);



        Menu menu = new Menu();
        int opc;
        System.out.println("¡Bienvenido al sistema!");
        while (true){
            menu.verOpciones();
            opc = menu.tomarOpcion();
            menu.ejecOpcion(opc, carpaF, sombrilla, vip, intermedio, base, divisadero, banio, pileta, buffet, guarderia);
            if (opc == 0){
                System.exit(0);
            }
        }

    }
   }
