package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.service.interfaces.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {


    @Override
    public Producto publicarProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public void comentarProducto(Comentario comentario) throws Exception {

    }

    @Override
    public void guardarProductoListaFav(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void eliminarProductoListaFav(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void agregarAlcarrito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void eliminarDelCarrito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void comprarProductosDeCarrito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public List<Producto> buscarProductoXNombre(String nombre) throws Exception {
        return null;
    }

    @Override
    public List<Producto> buscarProductoXRangoDePrecio(float rangoMayor, float rangoMneor) throws Exception {
        return null;
    }

    @Override
    public List<Producto> buscarProductoXCategoria(Categoria categoria) throws Exception {
        return null;
    }

    @Override
    public Producto buscarProductoXcodigo(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public List<Compra> ListarCompras(Usuario usuario) throws Exception {
        return null;
    }
}
