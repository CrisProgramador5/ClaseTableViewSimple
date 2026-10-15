package cl.duoc.tabla;


// Record simple para guardar los datos de un Producto.
// Cada Producto tendrá nombre, categoria y precio.

public record Producto(String nombre, String categoria, double precio) {
}