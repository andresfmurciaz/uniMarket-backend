package co.edu.uniquindio.proyecto.service.interfaces;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;

import java.util.List;

public interface ProductoService {

/*
* Requerimientos de los productos
-Publicar un producto para vender.
-Comentar en un producto
-Guardar productos en su lista de favoritos y quitar productos de dicha lista.
-Comprar un producto o varios. Este proceso requiere un carrito de compr
-Buscar productos (nombre y/o precio).
-Listar sus propias compras.
-Listar sus propios productos, eliminarlos o actualizarlos.
-Listar sus propios favoritos.
* */


    Producto publicarProducto () throws Exception;

    void comentarProducto( ) throws Exception;

    void guardarProductoListaFav() throws  Exception;

    void eliminarProductoListaFav() throws  Exception;

    void agregarAlcarrito() throws Exception;

    void eliminarDelCarrito() throws Exception;

    void comprarProductosDeCarrito() throws Exception;

    List<Producto> buscarProductoXNombre() throws Exception;

    List<Producto> buscarProductoXRangoDePrecio() throws Exception;

    List<Producto> buscarProductoXCategoria() throws Exception;

    Producto buscarProductoXcodigo() throws Exception;

    List<Compra> ListarCompras() throws Exception;



}
