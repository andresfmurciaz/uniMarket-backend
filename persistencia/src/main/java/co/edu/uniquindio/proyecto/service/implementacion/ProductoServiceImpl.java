package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.service.interfaces.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {

    @Override
    public Producto publicarProducto() throws Exception {
        return null;
    }

    @Override
    public void comentarProducto() throws Exception {

    }

    @Override
    public void guardarProductoListaFav() throws Exception {

    }

    @Override
    public void eliminarProductoListaFav() throws Exception {

    }

    @Override
    public void agregarAlcarrito() throws Exception {

    }

    @Override
    public void eliminarDelCarrito() throws Exception {

    }

    @Override
    public void comprarProductosDeCarrito() throws Exception {

    }

    @Override
    public List<Producto> buscarProductoXNombre() throws Exception {
        return null;
    }

    @Override
    public List<Producto> buscarProductoXRangoDePrecio() throws Exception {
        return null;
    }

    @Override
    public List<Producto> buscarProductoXCategoria() throws Exception {
        return null;
    }

    @Override
    public Producto buscarProductoXcodigo() throws Exception {
        return null;
    }

    @Override
    public List<Compra> ListarCompras() throws Exception {
        return null;
    }
}
