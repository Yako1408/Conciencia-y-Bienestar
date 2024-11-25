package Concienciabienestar;
import java.time.LocalDateTime;
public class OrdenDeCompra {
    private int codigoOrden;
    private int codigoMedicamento;
    private String nombreMedicamento;
    private int cantidad;
    private String estado;
    private LocalDateTime fechaCreacion;

    public OrdenDeCompra(int codigoOrden, int codigoMedicamento, String nombreMedicamento, int cantidad) {
        this.codigoOrden = codigoOrden;
        this.codigoMedicamento = codigoMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidad = cantidad;
        this.estado = "Creada";
        this.fechaCreacion = LocalDateTime.now();
    }

    public int getCodigoOrden() {
        return codigoOrden;
    }

    public int getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return String.format(
                "Orden %d - Medicamento: %s (%d) - Cantidad: %d - Estado: %s - Fecha: %s",
                codigoOrden, nombreMedicamento, codigoMedicamento, cantidad, estado, fechaCreacion);
    }


}
