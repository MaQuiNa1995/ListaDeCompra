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

public class ProductoCompletoAdapter extends BaseAdapter {

    private List<Producto> listaProductos;
    private LayoutInflater inflater;

    private Producto producto;
    private int posicion;

    public ProductoCompletoAdapter(Activity activity, List<Producto> listaProductos) {
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

        final TextView txtRowNombreProducto = rowView.findViewById(R.id.rowNombreProductoListaDefinitiva);
        final TextView txtRowCantidad = rowView.findViewById(R.id.rowCantidadProductoListaDefinitiva);
        final Switch switchCogido = rowView.findViewById(R.id.rowCogido);

        txtRowNombreProducto.setText(listaProductos.get(i).getNombre());
        txtRowCantidad.setText(String.valueOf(listaProductos.get(i).getCantidad()));
        switchCogido.setChecked((listaProductos.get(i).getCogido() < 1) ? false : true);

        rowView.setOnClickListener((View v) -> {
        });

        return rowView;
    }
}
