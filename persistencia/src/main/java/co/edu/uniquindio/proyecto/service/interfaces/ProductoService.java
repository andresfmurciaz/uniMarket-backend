package co.edu.uniquindio.proyecto.service.interfaces;

import co.edu.uniquindio.proyecto.entidades.*;

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


    Producto publicarProducto (Producto producto) throws Exception;

    void comentarProducto(Comentario comentario) throws Exception;

    void guardarProductoListaFav(Producto producto, Usuario usuario) throws  Exception;

    void eliminarProductoListaFav(Producto producto, Usuario usuario) throws  Exception;

    void agregarAlcarrito(Producto producto, Usuario usuario) throws Exception;

    void eliminarDelCarrito(Producto producto, Usuario usuario) throws Exception;

    void comprarProductosDeCarrito(Producto producto, Usuario usuario) throws Exception;

    List<Producto> buscarProductoXNombre(String nombre) throws Exception;

    List<Producto> buscarProductoXRangoDePrecio(float rangoMayor,float rangoMneor) throws Exception;

    List<Producto> buscarProductoXCategoria(Categoria categoria) throws Exception;

    Producto buscarProductoXcodigo(Integer codigo) throws Exception;

    List<Compra> ListarCompras(Usuario usuario) throws Exception;



}
