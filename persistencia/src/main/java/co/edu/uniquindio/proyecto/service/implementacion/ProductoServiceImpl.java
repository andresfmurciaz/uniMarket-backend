package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import co.edu.uniquindio.proyecto.service.interfaces.ProductoService;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {


    //se crea variable para acceder a los repo , no se usa el @wit.. poe que el ide nbos recomienda crear un cosntructor
    private final UsuarioRepo usuarioRepo;
    private final ModeradorRepo moderadorRepo;
    private final ProductoRepo productoRepo;

    public ProductoServiceImpl(UsuarioRepo usuarioRepo, ProductoRepo productoRepo,ModeradorRepo moderadorRepo)
    {
        this.moderadorRepo=moderadorRepo;
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public Producto registrarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if(buscado.isPresent()) {throw  new Exception("el codigo del producto ya existe");}
        return productoRepo.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {
        Optional<Producto> buscado = productoRepo.findById(producto.getCodigo());
        if(buscado.isPresent()) {throw  new Exception("el codigo del producto ya existe");}

        return productoRepo.save(producto);
    }

    @Override
    public void eliminarProducto(int codigo) throws Exception {

        Optional<Producto> buscado = productoRepo.findByCodigo(codigo);
        if(buscado.isEmpty()) {throw  new Exception("el codigo del producto no existe");}

        productoRepo.deleteById(codigo);
    }

    @Override
    public List<Producto> listarProductos() throws Exception {
        return productoRepo.findAll();
    }




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

    @Override
    public Producto obtenerProducto(int codigo) throws Exception {
        return null;
    }
}
