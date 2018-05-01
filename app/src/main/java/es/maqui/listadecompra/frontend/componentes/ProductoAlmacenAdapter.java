package es.maqui.listadecompra.frontend.componentes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.dominio.ProductoAlmacen;

public class ProductoAlmacenAdapter extends BaseAdapter {

    private List<ProductoAlmacen> listaProductos;
    private LayoutInflater inflater;

    public ProductoAlmacenAdapter(Activity activity, List<ProductoAlmacen> listaProductos) {
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
        View rowView = inflater.inflate(R.layout.plantilla_lista_compra_creada, null);

        final TextView txtRowNombreProducto = rowView.findViewById(R.id.);
        final TextView txtRowCantidad = rowView.findViewById(R.id.);
        final Switch switchCogido = rowView.findViewById(R.id.rowCogido);

        txtRowNombreProducto.setText(listaProductos.get(i).getNombre());
        txtRowCantidad.setText(String.valueOf(listaProductos.get(i).getCantidad()));
        switchCogido.setChecked(Boolean.FALSE);

        rowView.setOnClickListener((View v) -> {
        });

        return rowView;
    }
}
