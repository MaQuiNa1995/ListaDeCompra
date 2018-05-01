package es.maqui.listadecompra.frontend.componentes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.dominio.ProductoCompra;

public class ProductoListaCompraAdapter extends BaseAdapter {

    private List<ProductoCompra> listaProductos;
    private LayoutInflater inflater;

    public ProductoListaCompraAdapter(Activity activity, List<ProductoCompra> listaProductos) {
        this.listaProductos = listaProductos;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaProductos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.plantilla_lista_compra, null);

        final TextView txtRowNombreProducto = rowView.findViewById(R.id.);
        final TextView txtRowCantidad = rowView.findViewById(R.id.);

        txtRowNombreProducto.setText(listaProductos.get(i).getNombre());
        txtRowCantidad.setText(String.valueOf(listaProductos.get(i).getCantidad()));

        rowView.setOnClickListener((View v) -> {
                // TODO relllenar boton
        });

        return rowView;
    }
}
