package Concienciabienestar;
import java.util.LinkedList;

public class Inventario {
    private LinkedList<Medicamento> medicamentos;

    public Inventario() {
        medicamentos = new LinkedList<>(); // Especifica el tipo genérico
        inicializarInventario();
    }

    private void inicializarInventario() {
        medicamentos.add(new Medicamento(101, "Paracetamol", 50, "2024-12-31"));
        medicamentos.add(new Medicamento(102, "Ibuprofeno", 30, "2025-06-15"));
        medicamentos.add(new Medicamento(103, "Amoxicilina", 40, "2025-08-20"));
        medicamentos.add(new Medicamento(104, "Clorfenamina", 20, "2024-03-10"));
        medicamentos.add(new Medicamento(105, "Omeprazol", 60, "2026-01-01"));
        medicamentos.add(new Medicamento(106, "Metformina", 70, "2025-07-07"));
        medicamentos.add(new Medicamento(107, "Losartán", 35, "2026-12-12"));
        medicamentos.add(new Medicamento(108, "Simvastatina", 50, "2024-11-30"));
        medicamentos.add(new Medicamento(109, "Aspirina", 80, "2025-05-20"));
        medicamentos.add(new Medicamento(110, "Salbutamol", 15, "2024-09-15"));
    }

    public Medicamento buscarMedicamento(int codigo) {
        return buscarMedicamentoRecursivo(codigo, 0);
    }

    private Medicamento buscarMedicamentoRecursivo(int codigo, int index) {
        if (index >= medicamentos.size()) {
            return null; // No encontrado
        }
        Medicamento med = medicamentos.get(index);
        if (med.getCodigo() == codigo) {
            return med; // Encontrado
        }
        return buscarMedicamentoRecursivo(codigo, index + 1); // Siguiente elemento
    }

    public void actualizarStock(int codigo, int cantidad) {
        Medicamento med = buscarMedicamento(codigo);
        if (med != null) {
            med.setCantidad(med.getCantidad() + cantidad);
        }
    }

    public LinkedList<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}

class Medicamento {
    private int codigo;
    private String nombre;
    private int cantidad;
    private String fechaExpiracion;

    public Medicamento(int codigo, String nombre, int cantidad, String fechaExpiracion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    @Override
    public String toString() {
        return String.format("Código: %d, Nombre: %s, Cantidad: %d, Expira: %s",
                codigo, nombre, cantidad, fechaExpiracion);
    }

}