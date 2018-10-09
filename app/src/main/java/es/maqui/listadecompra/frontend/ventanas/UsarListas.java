package es.maqui.listadecompra.frontend.ventanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.dominio.Producto;
import es.maqui.listadecompra.backend.repository.ProductoRepository;
import es.maqui.listadecompra.frontend.componentes.ProductoAdapter;

public class UsarListas extends AppCompatActivity {

    private ProductoRepository repositoryProducto;

    private ListView lstProductosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_productos_completa);

        repositoryProducto = new ProductoRepository(this);

        lstProductosView = findViewById(R.id.listaProductos);

        List<Producto> listaProductos = repositoryProducto.getListaProductos();

        refrescarDatos(listaProductos);
    }

    private void refrescarDatos(List<Producto> listaProductos) {
        if ((listaProductos != null) && (listaProductos.size() != 0)) {
            ProductoAdapter adapter = new ProductoAdapter(UsarListas.this, listaProductos);
            lstProductosView.setAdapter(adapter);
        }
    }
}
