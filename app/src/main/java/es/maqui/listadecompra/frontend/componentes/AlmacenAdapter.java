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
import es.maqui.listadecompra.backend.dominio.Almacen;

public class AlmacenAdapter extends BaseAdapter {

    private List<Almacen> listaAlmacenes;
    private LayoutInflater inflater;

    public AlmacenAdapter(Activity activity, List<Almacen> listaAlmacenes) {
        this.listaAlmacenes = listaAlmacenes;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listaAlmacenes.size();
    }

    @Override
    public Object getItem(int i) {
        return listaAlmacenes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaAlmacenes.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout., null);

        final TextView txtRowNombreProducto = rowView.findViewById(R.id.);
        final TextView txtRowCantidad = rowView.findViewById(R.id.);

        txtRowCantidad.setText(String.valueOf(listaAlmacenes.get(i).getId()));
        txtRowNombreProducto.setText(listaAlmacenes.get(i).getNombre());


        rowView.setOnClickListener((View v) -> {
        });

        return rowView;
    }
}
