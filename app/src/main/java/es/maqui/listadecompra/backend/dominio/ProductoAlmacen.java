package es.maqui.listadecompra.backend.dominio;

public class ProductoAlmacen {

    Long id;
    String nombre;
    Integer cantidad;
    Long idProductoAlmacen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdProductoAlmacen() {
        return idProductoAlmacen;
    }

    public void setIdProductoAlmacen(Long idProductoAlmacen) {
        this.idProductoAlmacen = idProductoAlmacen;
    }
}
