import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alcancia {
    private Map<Integer, Integer> monedas;
    private int totalMonedas;
    private int totalAcumulado;

    public Alcancia() {
        this.monedas = new HashMap<>();
        this.totalMonedas = 0;
        this.totalAcumulado = 0;
    }

    public void agregarMoneda(int denominacion) {
        monedas.put(denominacion, monedas.getOrDefault(denominacion, 0) + 1);
        totalMonedas++;
        totalAcumulado += denominacion;
    }

    public int getCantidadMonedasPorDenominacion(int denominacion) {
        return monedas.getOrDefault(denominacion, 0);
    }

    public int getTotalMonedas() {
        return totalMonedas;
    }

    public int getTotalAcumulado() {
        return totalAcumulado;
    }

    public void vaciarAlcancia() {
        monedas.clear();
        totalMonedas = 0;
        totalAcumulado = 0;
    }

    public boolean retirarMoneda(int denominacion) {
        if (monedas.getOrDefault(denominacion, 0) > 0) {
            monedas.put(denominacion, monedas.get(denominacion) - 1);
            totalMonedas--;
            totalAcumulado -= denominacion;
            return true;
        }
        return false;
    }

    // Otros métodos...
}

public class Producto {
    private String nombre;
    private double precioBase;
    private String tipo; // supermercado, droguería, papelería
    private int stock;

    public Producto(String nombre, double precioBase, String tipo, int stock) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.stock = stock;
    }

    public double calcularPrecioConIVA() {
        double iva = switch (tipo) {
            case "supermercado" -> 0.04;
            case "droguería" -> 0.12;
            case "papelería" -> 0.16;
            default -> 0;
        };
        return precioBase + (precioBase * iva);
    }

    public void venderProducto(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock para realizar la venta.");
        }
    }

    // Getters y setters
    // ...
}

public class Tienda {
    private String nombre;
    private ArrayList<Producto> productos;
    private ArrayList<Venta> historialVentas;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.historialVentas = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void realizarVenta(String nombreProducto, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto) && producto.getStock() >= cantidad) {
                producto.venderProducto(cantidad);
                double totalVenta = producto.calcularPrecioConIVA() * cantidad;
                historialVentas.add(new Venta(nombreProducto, cantidad, totalVenta));
                System.out.println("Venta realizada: " + cantidad + " x " + nombreProducto + " = $" + totalVenta);
                return;
            }
        }
        System.out.println("No se pudo realizar la venta. Producto no encontrado o sin stock suficiente.");
    }

    // Getters y setters
    // ...
}

public class Venta {
    private String nombreProducto;
    private int cantidad;
    private double totalVenta;

    public Venta(String nombreProducto, int cantidad, double totalVenta) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.totalVenta = totalVenta;
    }

    // Getters y setters
    // ...
}

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda("JPB ASEO");

        // Agregar 20 productos de limpieza
        tienda.agregarProducto(new Producto("Detergente", 5000, "supermercado", 50));
        tienda.agregarProducto(new Producto("Jabón", 3000, "supermercado", 40));
        tienda.agregarProducto(new Producto("Desinfectante", 8000, "droguería", 30));
        tienda.agregarProducto(new Producto("Limpiador Multiuso", 7000, "supermercado", 25));
        tienda.agregarProducto(new Producto("Ambientador", 4000, "supermercado", 20));
        tienda.agregarProducto(new Producto("Guantes de Limpieza", 10000, "droguería", 15));
        tienda.agregarProducto(new Producto("Cera para Pisos", 12000, "supermercado", 10));
        tienda.agregarProducto(new Producto("Cloro", 2000, "droguería", 50));
        tienda.agregarProducto(new Producto("Esponja", 1500, "supermercado", 40));
        tienda.agregarProducto(new Producto("Toallas de Papel", 6000, "papelería", 30));
        tienda.agregarProducto(new Producto("Limpiador de Vidrios", 9000, "supermercado", 25));
        tienda.agregarProducto(new Producto("Desengrasante", 11000, "droguería", 20));
        tienda.agregarProducto(new Producto("Líquido para Platos", 4000, "supermercado", 15));
        tienda.agregarProducto(new Producto("Lejía", 3000, "droguería", 10));
        tienda.agregarProducto(new Producto("Escoba", 8000, "supermercado", 5));
        tienda.agregarProducto(new Producto("Recogedor", 7000, "supermercado", 50));
        tienda.agregarProducto(new Producto("Mopa", 15000, "supermercado", 40));
        tienda.agregarProducto(new Producto("Cepillo", 5000, "supermercado", 30));
        tienda.agregarProducto(new Producto("Papel Higiénico", 10000, "papelería", 25));
        tienda.agregarProducto(new Producto("Detergente en Polvo", 14000, "supermercado", 20));

        // Realizar algunas ventas
        tienda.realizarVenta("Detergente", 5);
        tienda.realizarVenta("Jabón", 10);
        // Más ventas...
    }
}
