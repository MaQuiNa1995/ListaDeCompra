package es.maqui.listadecompra.backend.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.maqui.listadecompra.backend.dominio.Almacen;

public class AlmacenRepository extends SQLiteOpenHelper {

    //Base De Datos
    private static final int VERSION_BD = 2;
    private static final String NOMBRE_BD = "MaquiListaCompraBD";

    //Tablas
    private static final String NOMBRE_TABLA = "ALMACEN";
    private static final String COLUMNA_ID = "ID";
    private static final String COLUMNA_NOMBRRE = "NOMBRE_ALMACEN";

    public AlmacenRepository(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    public void annadirAlmacen(Almacen almacen) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {

            ContentValues contenedor = new ContentValues();
            contenedor.put(COLUMNA_NOMBRRE, almacen.getNombre());

            db.insert(NOMBRE_TABLA, null, contenedor);

        } catch (Exception e) {
            Log.e("Error al guardar", "Ha ocurrido un error al intentar guardar el almacen " + almacen.toString() + " Traza de log: " + e.getMessage());
        }

    }

    public int actualizarAlmacen(Almacen almacen) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {

            ContentValues contenedor = new ContentValues();
            contenedor.put(COLUMNA_NOMBRRE, almacen.getNombre());

            return db.update(NOMBRE_TABLA, contenedor, COLUMNA_ID + " =?", new String[]{String.valueOf(almacen.getId())});

        } catch (Exception e) {
            Log.e("Error al modificar", "Ha ocurrido un error al intentar modificar el almacen " + almacen.toString() + " Traza de log: " + e.getMessage());
            return -404;
        }
    }

    public void eliminarAlmacen(Almacen almacen) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {

            db.delete(NOMBRE_TABLA, COLUMNA_ID + " =?", new String[]{String.valueOf(almacen.getId())});

        } catch (Exception e) {
            Log.e("Error al modificar", "Ha ocurrido un error al intentar modificar el almacen " + almacen.toString() + " Traza de log: " + e.getMessage());
        }
    }

    public Almacen getAlmacen(int id) {

        Almacen almacen = null;

        try (SQLiteDatabase db = this.getWritableDatabase();
             Cursor cursor = db.query(NOMBRE_TABLA, new String[]{COLUMNA_ID, COLUMNA_NOMBRRE}, COLUMNA_ID + "=?",
                     new String[]{String.valueOf(id)}, null, null, null, null)) {

            if (cursor != null) {
                cursor.moveToFirst();

                almacen = new Almacen();
                almacen.setId(cursor.getLong(0));
                almacen.setNombre(cursor.getString(1));
            }
        } catch (Exception e) {
            Log.wtf("Error al obtener almacén", "Ha ocurrido un error al intentar recuperar el almacén " + almacen.toString() + " Traza de log: " + e.getMessage());
            almacen = null;
        }

        return almacen;
    }

    public List<Almacen> getListaAlmacenes() {

        List<Almacen> listaProductos = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + NOMBRE_TABLA;

        try (SQLiteDatabase db = this.getWritableDatabase(); Cursor cursor = db.rawQuery(selectQuery, null)) {
            if (cursor.moveToFirst()) {
                do {
                    Almacen producto = new Almacen();

                    producto.setId(cursor.getLong(0));
                    producto.setNombre(cursor.getString(1));

                    listaProductos.add(producto);
                }
                while (cursor.moveToNext());
            }
        } catch (Exception e) {
            listaProductos = null;
            Log.e("Error al obtener lista", "Ha ocurrido un error al intentar recuperar la lista de productos  Traza de log: " + e.getMessage());
        }

        return listaProductos;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE =
                "CREATE TABLE " + NOMBRE_TABLA + "("
                        + COLUMNA_ID + " INTEGER PRIMARY KEY,"
                        + COLUMNA_NOMBRRE + " TEXT"
                        + ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA);

        onCreate(sqLiteDatabase);
    }

}
