package sistemaInventario;
// Clase Venta que representa una venta de productos
public class Venta {
    private Producto[] productosVendidos; // Arreglo para almacenar los productos vendidos
    private int[] cantidades; // Arreglo para almacenar las cantidades vendidas de cada producto
    private int cantidadProductos; // Número actual de productos en la venta
    private HistorialVentas historial; // Objeto para manejar el historial de ventas

    // Constructor de la clase Venta
    public Venta(int capacidad, int capacidadHistorial) {
        productosVendidos = new Producto[capacidad];
        cantidades = new int[capacidad];
        cantidadProductos = 0;
        historial = new HistorialVentas(capacidadHistorial);
    }

    // Método para agregar un producto a la venta
    public void agregarProducto(Producto producto, int cantidad) {
        try {
            // Verifica si hay suficientes unidades en el inventario
            if (producto.getCantidad() < cantidad) {
                throw new IllegalArgumentException("No hay suficientes unidades en el inventario.");
            }

            boolean productoExistente = false;
            // Verifica si el producto ya está en la venta actual
            for (int i = 0; i < cantidadProductos; i++) {
                if (productosVendidos[i].getId() == producto.getId()) {
                    cantidades[i] += cantidad;
                    productoExistente = true;
                }
            }

            // Si el producto no está en la venta, lo agrega
            if (!productoExistente) {
                if (cantidadProductos >= productosVendidos.length) {
                    throw new IllegalStateException("No se pueden agregar más productos a la venta.");
                }
                productosVendidos[cantidadProductos] = producto;
                cantidades[cantidadProductos] = cantidad;
                cantidadProductos++;
            }

            // Actualiza el inventario del producto
            producto.vender(cantidad);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para imprimir el recibo de la venta
    public void imprimirRecibo() {
        if (cantidadProductos == 0) {
            System.out.println("No se realizó ninguna venta.");
            return;
        }

        double total = 0;
        System.out.println("\nRecibo de Venta:");
        // Itera sobre los productos vendidos y calcula el subtotal y total
        for (int i = 0; i < cantidadProductos; i++) {
            double subtotal = productosVendidos[i].getPrecio() * cantidades[i];
            total += subtotal;
            System.out.println("Producto: " + productosVendidos[i].getNombre() + ", Cantidad: " + cantidades[i] + ", " +
                    "Subtotal: " + subtotal);
        }
        System.out.println("Total: S/" + total);

        // Agrega el recibo al historial
        for (int i = 0; i < cantidadProductos; i++) {
            historial.agregarRecibo(productosVendidos[i].getId(), productosVendidos[i].getNombre(),
                    productosVendidos[i].getPrecio() * cantidades[i]);
        }

        cantidadProductos = 0; // Reinicia la venta actual
    }

    // Método para imprimir el historial de ventas
    public void imprimirHistorialVentas(Inventario inventario) {
        try {
            historial.imprimirHistorial(productosVendidos, inventario);
        } catch (Exception e) {
            System.out.println("Error al imprimir el historial de ventas: " + e.getMessage());
        }
    }
}