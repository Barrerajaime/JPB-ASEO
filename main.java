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
