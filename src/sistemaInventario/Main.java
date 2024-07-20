package sistemaInventario;
import java.util.Scanner;

// Clase principal del programa
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de un objeto Inventario con capacidad para 20 productos
        Inventario inventario = new Inventario(20);

        // Creación de un objeto Venta con capacidad para 10 productos en la venta actual y 20 en el historial de ventas
        Venta venta = new Venta(10, 20);

        int opcion = 0;
        // Bucle principal del menú de opciones
        do {
            System.out.println("\n------ Menú de Opciones ------");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Realizar una venta");
            System.out.println("3. Ver inventario");
            System.out.println("4. Ver historial de ventas");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción deseada: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consume la nueva línea

                switch (opcion) {
                    case 1:
                        agregarProductoInventario(scanner, inventario);
                        break;
                    case 2:
                        realizarVenta(scanner, inventario, venta);
                        break;
                    case 3:
                        inventario.imprimirInventario();
                        break;
                    case 4:
                        venta.imprimirHistorialVentas(inventario);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor ingrese una opción válida.");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.next();
            }
        } while (opcion != 5);

        scanner.close(); // Cierra el objeto Scanner
    }

    // Método para agregar un producto al inventario
    private static void agregarProductoInventario(Scanner scanner, Inventario inventario) {
        try {
            int id = -1;
            // Pide y valida el ID del producto
            while (id < 1) {
                System.out.print("\nIngrese el ID del producto: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    if (id < 1) {
                        System.out.println("El ID debe ser mayor o igual a 1.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingrese un número.");
                    scanner.next();
                }
            }
            scanner.nextLine();

            // Pide y valida el nombre del producto
            String nombre = "";
            while (!nombre.matches("[a-zA-Z\\s]+")) {
                System.out.print("Ingrese el nombre del producto: ");
                nombre = scanner.nextLine();
                if (!nombre.matches("[a-zA-Z\\s]+")) {
                    System.out.println("El nombre no puede contener números.");
                }
            }

            // Pide y valida el precio del producto
            double precio = -1;
            while (precio <= 0) {
                System.out.print("Ingrese el precio del producto: ");
                if (scanner.hasNextDouble()) {
                    precio = scanner.nextDouble();
                    if (precio <= 0) {
                        System.out.println("El precio debe ser mayor a 0.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingrese un número.");
                    scanner.next();
                }
            }

            // Pide y valida la cantidad inicial del producto
            int cantidad = -1;
            while (cantidad < 1) {
                System.out.print("Ingrese la cantidad inicial en stock: ");
                if (scanner.hasNextInt()) {
                    cantidad = scanner.nextInt();
                    if (cantidad < 1) {
                        System.out.println("La cantidad inicial en stock debe ser mayor o igual a 1.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingrese un número.");
                    scanner.next();
                }
            }

            // Crea un objeto Producto y lo agrega al inventario
            Producto producto = new Producto(id, nombre, precio, cantidad);
            inventario.agregarProducto(producto);
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            scanner.nextLine();
        }
    }

    // Método para realizar una venta
    private static void realizarVenta(Scanner scanner, Inventario inventario, Venta venta) {
        try {
            // Verifica si el inventario está vacío
            if (inventario.estaVacio()) {
                System.out.println("No hay productos en el inventario para realizar una venta.");
                return;
            }

            int id;
            Producto producto;
            // Bucle para procesar la venta de productos
            do {
                System.out.print("\nIngrese el ID del producto a vender (0 para finalizar la venta): ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    if (id != 0) {
                        producto = inventario.buscarProducto(id);
                        if (producto != null) {
                            System.out.print("Ingrese la cantidad a vender: ");
                            if (scanner.hasNextInt()) {
                                int cantidad = scanner.nextInt();
                                venta.agregarProducto(producto, cantidad);
                            } else {
                                System.out.println("Entrada no válida. Por favor ingrese un número.");
                                scanner.next();
                            }
                        } else {
                            System.out.println("Producto no encontrado en el inventario.");
                        }
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingrese un número.");
                    scanner.next();
                    id = -1; // Mantiene el bucle si la entrada no es válida
                }
            } while (id != 0);

            venta.imprimirRecibo(); // Imprime el recibo de la venta
        } catch (Exception e) {
            System.out.println("Error al realizar venta: " + e.getMessage());
            scanner.nextLine();
        }
    }
}