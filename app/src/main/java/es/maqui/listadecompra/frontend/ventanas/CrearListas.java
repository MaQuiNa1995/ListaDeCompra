package es.maqui.listadecompra.frontend.ventanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.dominio.Producto;
import es.maqui.listadecompra.backend.repository.ProductoRepository;
import es.maqui.listadecompra.frontend.componentes.ProductoAdapter;

public class CrearListas extends AppCompatActivity {

    private ProductoRepository repositoryProducto;

    private TextView textNombreProducto;
    private TextView textCantidadProducto;
    private ListView lstProductosView;

    private List<Producto> listaProductos;

    private Button botonAnnadir;
    private Button botonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_listas);
        repositoryProducto = new ProductoRepository(this);

        textNombreProducto = findViewById(R.id.textNombreProducto);
        textCantidadProducto = findViewById(R.id.textCantidad);

        lstProductosView = findViewById(R.id.listaCreacionProductos);

        botonAnnadir = findViewById(R.id.botonAnadirProducto);
        botonEliminar = findViewById(R.id.botonEliminarProducto);


        listaProductos = repositoryProducto.getListaProductos();
        refrescarDatos(listaProductos);


        botonAnnadir.setOnClickListener((View v) -> {
            Producto producto = new Producto();
            producto.setNombre(textNombreProducto.getText().toString());
            producto.setCantidad(Integer.parseInt(textCantidadProducto.getText().toString()));
            listaProductos.add(producto);

            repositoryProducto.annadirProducto(producto);

            refrescarDatos(listaProductos);
        });

        botonEliminar.setOnClickListener((View v) -> refrescarDatos(listaProductos));
    }

    private void refrescarDatos(List<Producto> listaProductos) {
        if ((listaProductos != null) && (listaProductos.size() != 0)) {
            ProductoAdapter adapter = new ProductoAdapter(CrearListas.this, listaProductos);
            lstProductosView.setAdapter(adapter);
        }
    }
}
