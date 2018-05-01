package es.maqui.listadecompra.frontend.ventanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.repository.ProductoAlmacenRepository;
import es.maqui.listadecompra.frontend.componentes.ProductoAdapter;

public class CrearListas extends AppCompatActivity {

    private ProductoAlmacenRepository repositoryProducto;

    private TextView textNombreProducto;
    private TextView textCantidadProducto;
    private ListView lstProductosView;

    private List<Producto> listaProductos;

    private Button botonAnnadir;
    private Button botonEliminar;

    private ProductoAdapter adapter=null;

    private Producto prodSeleccionado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_listas);
        repositoryProducto = new ProductoAlmacenRepository(this);

        textNombreProducto = findViewById(R.id.textNombreProducto);
        textCantidadProducto = findViewById(R.id.textCantidad);

        lstProductosView = findViewById(R.id.listaCreacionProductos);
        lstProductosView.setClickable(Boolean.TRUE);

        botonAnnadir = findViewById(R.id.botonAnadirProducto);
        botonEliminar = findViewById(R.id.botonEliminarProducto);

        listaProductos = repositoryProducto.getListaProductos();

        if(listaProductos == null){
            listaProductos = new ArrayList<>();
        }

        refrescarDatos(listaProductos);

        botonAnnadir.setOnClickListener((View v) -> {

            Producto producto = new Producto();
            producto.setNombre(textNombreProducto.getText().toString());
            producto.setCantidad(Integer.parseInt(textCantidadProducto.getText().toString()));
            producto.setCogido(0);

            listaProductos.add(producto);
            repositoryProducto.annadirProducto(producto);

            textNombreProducto.setText("");
            textCantidadProducto.setText("");

            refrescarDatos(listaProductos);

            mostrarNotificacion("Se Ha Añadido: "+producto.getNombre());
        });

        botonEliminar.setOnClickListener((View v) -> {

            if(prodSeleccionado!=null) {
                repositoryProducto.eliminarProducto(prodSeleccionado);

                refrescarDatos(listaProductos);
                mostrarNotificacion("Se Ha Eliminado: " + prodSeleccionado.getNombre());
            }else{
                mostrarNotificacion("Error: No se ha seleccionado ningún producto");
            }
        });
    }

    private void refrescarDatos(List<Producto> listaProductos) {
        if ((listaProductos != null) && (listaProductos.size() != 0)) {
            adapter = new ProductoAdapter(CrearListas.this, listaProductos);
            lstProductosView.setAdapter(adapter);
        }
    }

    private void mostrarNotificacion(String contenido){
        Toast.makeText(this, contenido, Toast.LENGTH_SHORT).show();
    }
}
