package Concienciabienestar;

public class VerInventario {
    public static void listarInventario(Inventario inventario) {
        for (Medicamento med : inventario.getMedicamentos()) {
            System.out.println(med);
        }
    }
}
