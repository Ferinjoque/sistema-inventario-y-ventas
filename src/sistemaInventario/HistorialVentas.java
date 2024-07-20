package sistemaInventario;
// Clase HistorialVentas que representa el historial de ventas
public class HistorialVentas {
    private double[][] historial; // Arreglo para almacenar el historial de ventas (ID, subtotal, número de venta)
    private int numVentas; // Número actual de ventas registradas
    private double total; // Total acumulado de ventas

    // Constructor de la clase HistorialVentas
    public HistorialVentas(int capacidad) {
        historial = new double[capacidad][3];
        numVentas = 0;
        total = 0;
    }

    // Método para agregar un recibo al historial
    public void agregarRecibo(double idProducto, String nombreProducto, double subtotal) {
        try {
            if (numVentas >= historial.length) {
                throw new IllegalStateException("No se pueden registrar más ventas.");
            }

            historial[numVentas][0] = idProducto; // Almacena el ID del producto
            historial[numVentas][1] = subtotal; // Almacena el subtotal
            historial[numVentas][2] = numVentas + 1; // Almacena el número de venta
            total += subtotal; // Actualiza el total acumulado de ventas
            numVentas++;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para imprimir el historial de ventas
    public void imprimirHistorial(Producto[] productosVendidos, Inventario inventario) {
        try {
            if (numVentas == 0) {
                System.out.println("No hay ventas registradas en el historial.");
                return;
            }

            System.out.println("\nHistorial de Ventas:");
            // Itera sobre el historial y muestra los detalles de cada venta
            for (int i = 0; i < numVentas; i++) {
                int idProducto = (int) historial[i][0];
                double subtotal = historial[i][1];
                int numeroVenta = (int) historial[i][2]; // Obtiene el número de venta

                Producto producto = inventario.buscarProducto(idProducto);
                if (producto == null) {
                    throw new IllegalArgumentException("Nombre del producto no encontrado para el ID: " + idProducto);
                }

                String nombreProducto = producto.getNombre();

                System.out.println("Recibo N°" + numeroVenta + ": Producto ID = " + idProducto +
                        ", Nombre = " + nombreProducto + ", Subtotal = S/" + subtotal);
            }
            System.out.println("Total acumulado de ventas: S/" + total);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}