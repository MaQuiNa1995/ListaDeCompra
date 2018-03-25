package es.maqui.listadecompra.backend.dominio;

public class Producto {

    private long id;
    private String nombre;
    private int cantidad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                " nombre='" + nombre +
                " cantidad=" + cantidad +
                '}';
    }
}
