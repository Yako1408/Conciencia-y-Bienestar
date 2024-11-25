package Concienciabienestar;
import java.util.Scanner;
public class GestionDeOrden {
    private RegistroDeOrden registro;
    private Inventario inventario;

    public GestionDeOrden(RegistroDeOrden registro, Inventario inventario) {
        this.registro = registro;
        this.inventario = inventario;
    }

    public void gestionarOrden() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código de la orden: ");
        int codigoOrden = scanner.nextInt();

        for (OrdenDeCompra orden : registro.getOrdenes()) {
            if (orden.getCodigoOrden() == codigoOrden) {
                System.out.println("Estado actual: " + orden.getEstado());
                System.out.println("1. Completar");
                System.out.println("2. Anular");
                System.out.print("Seleccione una acción: ");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    orden.setEstado("Completada");
                    System.out.println("Orden completada.");
                } else if (opcion == 2) {
                    orden.setEstado("Anulada");
                    inventario.actualizarStock(orden.getCodigoMedicamento(), orden.getCantidad());
                    System.out.println("Orden anulada y stock actualizado.");
                } else {
                    System.out.println("Opción inválida.");
                }
                return;
            }
        }
        System.out.println("Orden no encontrada.");
    }
}
