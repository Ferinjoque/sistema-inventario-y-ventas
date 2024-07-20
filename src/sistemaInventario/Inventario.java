package sistemaInventario;
// Clase Inventario que representa el inventario de productos
public class Inventario {
    private Producto[] productos; // Arreglo para almacenar los productos
    private int cantidadProductos; // Número actual de productos en el inventario

    // Constructor de la clase Inventario
    public Inventario(int capacidad) {
        productos = new Producto[capacidad];
        cantidadProductos = 0;
    }

    // Método para agregar un nuevo producto al inventario
    public void agregarProducto(Producto producto) {
        // Verifica si el producto ya existe en el inventario
        if (buscarProducto(producto.getId(), false) != null) {
            System.out.println("Error: Ya existe un producto con el ID " + producto.getId() + " en el inventario.");
            return;
        }

        // Agrega el producto al inventario si hay espacio disponible
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos++] = producto;
            System.out.println("Producto agregado al inventario correctamente.");
        } else {
            System.out.println("Error: No se pueden agregar más productos al inventario.");
        }
    }

    // Método para buscar un producto por su ID
    public Producto buscarProducto(int id) {
        return buscarProducto(id, true);
    }

    // Método privado para buscar un producto por su ID con control de impresión de errores
    private Producto buscarProducto(int id, boolean imprimirError) {
        for (int i = 0; i < cantidadProductos; i++) {
            if (productos[i].getId() == id) {
                return productos[i];
            }
        }
        if (imprimirError) {
            System.out.println("Error: Producto no encontrado con ID " + id);
        }
        return null;
    }

    // Método para imprimir el inventario actual
    public void imprimirInventario() {
        if (cantidadProductos == 0) {
            System.out.println("No hay productos en el inventario");
            return;
        }

        System.out.println("\nInventario Actual:");
        for (int i = 0; i < cantidadProductos; i++) {
            Producto producto = productos[i];
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() +
                    ", Precio: " + producto.getPrecio() + ", Cantidad en stock: " + producto.getCantidad());
        }
    }

    // Método para verificar si el inventario está vacío
    public boolean estaVacio() {
        return cantidadProductos == 0;
    }
}