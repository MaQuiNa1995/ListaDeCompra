package es.maqui.listadecompra.frontend.componentes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.maqui.listadecompra.R;
import es.maqui.listadecompra.backend.dominio.Producto;

public class ProductoAdapter extends BaseAdapter {

    private List<Producto> listaProductos;
    private LayoutInflater inflater;

    public ProductoAdapter(Activity activity, List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Producto getItem(int i) {
        return listaProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaProductos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.plantilla_lista_compra, null);

        TextView txtRowNombreProducto = rowView.findViewById(R.id.rowNombreProducto);
        TextView txtRowCantidad = rowView.findViewById(R.id.rowCantidadProducto);
        CheckBox checkBox = rowView.findViewById(R.id.rowCogidoProducto);

        Producto producto = listaProductos.get(i);

        if(producto != null){
            txtRowNombreProducto.setText(producto.getNombre());
            txtRowCantidad.setText(String.valueOf(producto.getCantidad()));
            checkBox.setChecked(producto.getCogido()==1);
        }

        return rowView;
    }
}
