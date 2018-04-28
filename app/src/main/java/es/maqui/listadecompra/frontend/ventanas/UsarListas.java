package es.maqui.listadecompra.frontend.ventanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.repository.ProductoAlmacenRepository;
import es.maqui.listadecompra.frontend.componentes.ProductoCompletoAdapter;

public class UsarListas extends AppCompatActivity {

    private ProductoAlmacenRepository repositoryProducto;

    private ListView lstProductosView;
    private TextView nombreProducto;
    private TextView cantidadProducto;
    private Switch switchBoxCogido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_productos_completa);

        repositoryProducto = new ProductoAlmacenRepository(this);

        nombreProducto = findViewById(R.id.rowNombreProductoListaDefinitiva);
        cantidadProducto = findViewById(R.id.rowCantidadProductoListaDefinitiva);
        switchBoxCogido = findViewById(R.id.rowCogido);

        lstProductosView = findViewById(R.id.listaProductos);

        List<Producto> listaProductos = repositoryProducto.getListaProductos();

        refrescarDatos(listaProductos);
    }

    private void refrescarDatos(List<Producto> listaProductos) {
        if ((listaProductos != null) && (listaProductos.size() != 0)) {
            ProductoCompletoAdapter adapter = new ProductoCompletoAdapter(UsarListas.this, listaProductos);
            lstProductosView.setAdapter(adapter);
        }
    }
}
