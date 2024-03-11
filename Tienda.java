import java.util.ArrayList;

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
