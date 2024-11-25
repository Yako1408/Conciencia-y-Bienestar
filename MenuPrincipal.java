package Concienciabienestar;
import java.util.Scanner;

public class MenuPrincipal {
    private Inventario inventario;
    private RegistroDeOrden registro;
    private GestionDeOrden gestion;

    public MenuPrincipal() {
        inventario = new Inventario();
        registro = new RegistroDeOrden(inventario);
        gestion = new GestionDeOrden(registro, inventario);
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Verificar stock............................(1)");
            System.out.println("2. Crear orden de compra......................(2)");
            System.out.println("3. Gestión de orden...........................(3)");
            System.out.println("4. Ordenes...................................(5)");
            System.out.println("5. Salir......................................(6)");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    VerInventario.listarInventario(inventario);
                    break;
                case 2:
                    registro.crearOrden();
                    break;
                case 3:
                    gestion.gestionarOrden();
                    break;
                case 4:
                    registro.listarOrdenes();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
