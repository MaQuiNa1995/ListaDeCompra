package es.maqui.listadecompra.backend.dominio;

public class ProductoCompra {

    Long id;
    String nombre;
    Integer cantidad;
    Long idProductoCompra;

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

    public Long getIdProductoCompra() {
        return idProductoCompra;
    }

    public void setIdProductoCompra(Long idProductoCompra) {
        this.idProductoCompra = idProductoCompra;
    }
}
