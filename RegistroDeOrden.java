package Concienciabienestar;

import java.util.LinkedList;
import java.util.Scanner;
public class RegistroDeOrden {
    private LinkedList<OrdenDeCompra> ordenes;
    private Inventario inventario;
    private int codigoOrdenActual;

    public RegistroDeOrden(Inventario inventario) {
        this.inventario = inventario;
        this.ordenes = new LinkedList<>();
        this.codigoOrdenActual = 20240000; // Código inicial para las órdenes
    }

    public void crearOrden() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del medicamento: ");
        int codigoMedicamento = scanner.nextInt();
        Medicamento med = inventario.buscarMedicamento(codigoMedicamento);

        if (med != null) {
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();

            if (cantidad <= med.getCantidad()) {
                OrdenDeCompra orden = new OrdenDeCompra(
                        codigoOrdenActual++,
                        codigoMedicamento,
                        med.getNombre(),
                        cantidad
                );
                ordenes.add(orden);
                inventario.actualizarStock(codigoMedicamento, -cantidad);
                System.out.println("Orden creada exitosamente.");
            } else {
                System.out.println("Stock insuficiente.");
            }
        } else {
            System.out.println("Medicamento no encontrado.");
        }
    }

    public void listarOrdenes() {
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes registradas.");
        } else {
            for (OrdenDeCompra orden : ordenes) {
                System.out.println(orden);
            }
        }
    }

    public LinkedList<OrdenDeCompra> getOrdenes() {
        return ordenes;
    }

    public void listarHistorial() {
    }
}

