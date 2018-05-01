package es.maqui.listadecompra.backend.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.maqui.listadecompra.backend.dominio.ProductoCompra;

public class ProductoCompraRepository extends SQLiteOpenHelper {

    //Base De Datos
    private static final int VERSION_BD = 2;
    private static final String NOMBRE_BD = "MaquiListaCompraBD";

    //Tablas
    private static final String NOMBRE_TABLA = "PRODUCTO_COMPRA";
    private static final String COLUMNA_ID = "ID";
    private static final String COLUMNA_NOMBRRE = "NOMBRE";
    private static final String COLUMNA_CANTIDAD = "CANTIDAD";
    private static final String COLUMNA_ID_LISTA = "ID_LISTA_COMPRA";

    public ProductoCompraRepository(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    public void annadirProducto(ProductoCompra producto) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {

            ContentValues contenedor = new ContentValues();
            contenedor.put(COLUMNA_NOMBRRE, producto.getNombre());
            contenedor.put(COLUMNA_CANTIDAD, producto.getCantidad());
            contenedor.put(COLUMNA_ID_LISTA, producto.getIdProductoCompra());

            db.insert(NOMBRE_TABLA, null, contenedor);

        } catch (Exception e) {
            Log.e("Error al guardar", "Ha ocurrido un error al intentar guardar el producto " + producto.toString() + " Traza de log: " + e.getMessage());
        }

    }

    public int actualizarProducto(ProductoCompra producto) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {

            ContentValues contenedor = new ContentValues();
            contenedor.put(COLUMNA_NOMBRRE, producto.getNombre());
            contenedor.put(COLUMNA_CANTIDAD, producto.getCantidad());
            contenedor.put(COLUMNA_ID_LISTA, producto.getIdProductoCompra());

            return db.update(NOMBRE_TABLA, contenedor, COLUMNA_ID + " =?", new String[]{String.valueOf(producto.getId())});

        } catch (Exception e) {
            Log.e("Error al modificar", "Ha ocurrido un error al intentar modificar el producto " + producto.toString() + " Traza de log: " + e.getMessage());
            return -404;
        }
    }

    public void eliminarProducto(ProductoCompra producto) {

        try (SQLiteDatabase db = this.getWritableDatabase()) {

            db.delete(NOMBRE_TABLA, COLUMNA_ID + " =?", new String[]{String.valueOf(producto.getId())});

        } catch (Exception e) {
            Log.e("Error al modificar", "Ha ocurrido un error al intentar modificar el producto " + producto.toString() + " Traza de log: " + e.getMessage());
        }
    }

    public ProductoCompra getProducto(int id) {

        ProductoCompra producto = null;

        try (SQLiteDatabase db = this.getWritableDatabase(); Cursor cursor = db.query(NOMBRE_TABLA, new String[]{COLUMNA_ID, COLUMNA_NOMBRRE, COLUMNA_CANTIDAD}, COLUMNA_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null)) {

            if (cursor != null) {
                cursor.moveToFirst();

                producto = new ProductoCompra();
                producto.setId(cursor.getLong(0));
                producto.setNombre(cursor.getString(1));
                producto.setCantidad(cursor.getInt(2));
                producto.setIdProductoCompra(cursor.getLong(3));
            }

            return producto;

        } catch (Exception e) {
            Log.e("Error al modificar", "Ha ocurrido un error al intentar modificar el producto " + producto.toString() + " Traza de log: " + e.getMessage());
            return null;
        }

    }

    public List<ProductoCompra> getListaProductos() {

        List<ProductoCompra> listaProductos = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + NOMBRE_TABLA;

        ProductoCompra producto;

        try (SQLiteDatabase db = this.getWritableDatabase(); Cursor cursor = db.rawQuery(selectQuery, null)) {
            if (cursor.moveToFirst()) {
                do {
                    producto = new ProductoCompra();
                    producto.setId(cursor.getLong(0));
                    producto.setNombre(cursor.getString(1));
                    producto.setCantidad(cursor.getInt(2));
                    producto.setIdProductoCompra(cursor.getLong(3));

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

        String CREATE_TABLE = "CREATE TABLE " + NOMBRE_TABLA + "("
                + COLUMNA_ID + " INTEGER PRIMARY KEY,"
                + COLUMNA_NOMBRRE + " TEXT,"
                + COLUMNA_CANTIDAD + " INTEGER,"
                + COLUMNA_ID_LISTA + " INTEGER"
                + ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA);

        onCreate(sqLiteDatabase);
    }

}
