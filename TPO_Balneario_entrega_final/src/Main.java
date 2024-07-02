public class Main {
    public static void main(String[] args) {
        //Creación de membresías
        Membresia vip = new Membresia("VIP",20000);
        Membresia intermedio = new Membresia("Intermedio", 10000);
        Membresia base = new Membresia("base",8500);
        //Creación carpas y sombrillas
        CarpaFamiliar carpaF = new CarpaFamiliar("Carpa familiar",15000,4);
        CarpaSobrilla sombrilla = new CarpaSobrilla("Sombrilla", 9000, 2);
        //Creación privilegios
        Privilegio banio = new Privilegio("baño",false);
        Privilegio pileta = new Privilegio("pileta",false);
        Privilegio buffet = new Privilegio("buffet",false);
        Privilegio guarderia = new Privilegio("guarderia",false);
        Privilegio toboganes = new Privilegio("toboganes",true);
        Privilegio bar = new Privilegio("bar",true);
        Privilegio cancha = new Privilegio("cancha",true);


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
        toboganes.agregarMiembros(vip);
        bar.agregarMiembros(vip);
        cancha.agregarMiembros(vip);

        //Creación balneario
        Balneario divisadero = new Balneario();

        //Agregar carpas al balneario
        divisadero.agregarCarpa(carpaF);
        divisadero.agregarCarpa(sombrilla);
        //Agregar membresias al balneario
        divisadero.agregarMembresia(base);
        divisadero.agregarMembresia(intermedio);
        divisadero.agregarMembresia(vip);
        //Agregar privilegios al balneario
        divisadero.agregarPrivilegio(banio);
        divisadero.agregarPrivilegio(pileta);
        divisadero.agregarPrivilegio(buffet);
        divisadero.agregarPrivilegio(guarderia);
        divisadero.agregarPrivilegio(toboganes);
        divisadero.agregarPrivilegio(bar);
        divisadero.agregarPrivilegio(cancha);





        Menu menu = new Menu();
        int opc;
        System.out.println("¡Bienvenido al sistema!");
        while (true){
            menu.verOpciones();
            opc = menu.tomarOpcion();
            menu.ejecOpcion(opc, divisadero);
            if (opc == 0){
                System.exit(0);
            }
        }

    }
   }
