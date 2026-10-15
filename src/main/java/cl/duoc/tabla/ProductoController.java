package cl.duoc.tabla;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductoController {

    // ObservableList: lista que JavaFX puede observar.
    // Cuando agregamos un Producto, la tabla se actualiza sola.
    private final ObservableList<Producto> productos = FXCollections.observableArrayList();

    public VBox crearVista() {

        // Creamos la tabla que mostrará objetos de tipo Alumno.
        TableView<Producto> tabla = new TableView<>();

        // Creamos la columna Nombre.
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");

        // Indicamos que esta columna mostrará el nombre del Producto.
        colNombre.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().nombre())
        );

        // Creamos la columna Categoria.
        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoria");

        // Indicamos que esta columna mostrará la categoria del producto.
        colCategoria.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().categoria( )));

        // Creamos la columna Precio.
        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");

        // Indicamos que esta columna mostrará la nota del alumno.
        colPrecio.setCellValueFactory(dato ->
                new SimpleDoubleProperty(dato.getValue().precio()));

        // Agregamos las columnas a la tabla.
        tabla.getColumns().addAll(colNombre, colCategoria, colPrecio);

        // Conectamos la tabla con la lista observable.
        tabla.setItems(productos);

        // Agregamos datos iniciales.
        productos.add(new Producto("Pepsi", "Bebidas", 2000));
        productos.add(new Producto("Cheetos mani", "Snacks", 1500));

        // Campo para ingresar el nombre.
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        // Campo para ingresar la categoria.
        TextField txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoria");

        // Campo para ingresar la precio.
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        // Botón para agregar un nuevo producto.
        Button btnAgregar = new Button("Agregar producto");

        // Acción del botón.
        btnAgregar.setOnAction(evento -> {
            String nombre = txtNombre.getText();
            String categoria = txtCategoria.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            // Agregamos el alumno a la lista observable.
            productos.add(new Producto(nombre, categoria, precio));

            // Limpiamos los campos.
            txtNombre.clear();
            txtCategoria.clear();
            txtPrecio.clear();
        });

        // VBox ordena los elementos de arriba hacia abajo.
        return new VBox(10, tabla, txtNombre, txtCategoria, txtPrecio, btnAgregar);
    }
}
