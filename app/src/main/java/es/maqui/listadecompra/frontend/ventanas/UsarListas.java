package es.maqui.listadecompra.frontend.ventanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.dominio.Producto;
import es.maqui.listadecompra.backend.repository.ProductoRepository;

public class UsarListas extends AppCompatActivity {

    private ProductoRepository repositoryProducto;

    private TextView nombreProducto;
    private TextView cantidadProducto;
    private CheckBox checkBoxCogido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usar_lista_compra);

        nombreProducto = findViewById(R.id.rowNombreProducto);
        cantidadProducto = findViewById(R.id.rowCantidadProducto);

        repositoryProducto = new ProductoRepository(this);

        cargarDatos(repositoryProducto.getListaProductos());

    }

    private void cargarDatos(List<Producto> listaProductos){
        /*for (Producto productoSacado: listaProductos) {
            productoSacado.
        }*/
    }
}
