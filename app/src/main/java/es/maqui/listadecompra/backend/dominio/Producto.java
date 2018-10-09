package es.maqui.listadecompra.backend.dominio;

public class Producto {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private Long idProductoCompra;
    private int cogido;

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

    public int getCogido() {
        return cogido;
    }

    public void setCogido(int cogido) {
        this.cogido = cogido;
    }
}
