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
