package co.edu.uniquindio.proyecto.testService;

import co.edu.uniquindio.proyecto.PersistenciaApplication;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import co.edu.uniquindio.proyecto.service.interfaces.ProductoService;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

//que clase se esta probando?
@SpringBootTest(classes = PersistenciaApplication.class)
//no afecta la base de datos
@Transactional
public class ProductoServiceTest
{
    @Autowired
    private ModeradorService moderadorService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProductoService productoService;

    @Test
    public void registrarProductoTest()
    {
        //el error era por que no encontraba la categoria creada en la BD
        Usuario usuario1 = new Usuario(1,"andres","andres@gmail.com","2000","chilacoa","3224977434");
        Categoria categoria1 = new Categoria(1,"juguetes");
        Producto producto = new Producto(8,"celular redmi 8",1,"celular redmi con 30 pixeles y 8 g de ram",660000, 1, LocalDate.of(2023, 4, 7),LocalDate.of(2023, 5, 7),usuario1,categoria1);

        try {
            Producto respuesta =  productoService.registrarProducto(producto);
            System.out.println(respuesta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarProductoTest()
    {
        Usuario usuario1 = new Usuario(1,"andres","andres@gmail.com","2000","chilacoa","3224977434");
//el error era por que no encontraba la categoria creada en la BD
        Categoria categoria1 = new Categoria(1,"juguetes");

        Producto producto = new Producto(8,"celular redmi 8",1,"celular redmi con 30 pixeles y 8 g de ram",660000, 1, LocalDate.of(2023, 4, 7),LocalDate.of(2023, 5, 7),usuario1,categoria1);

        try {
            Producto respuesta =  productoService.registrarProducto(producto);
            System.out.println(respuesta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eliminarProductoTest()
    {

        try {
            productoService.eliminarProducto(1);
        } catch (Exception e) {
            //me imprime la exception
            e.printStackTrace();
            //para forzar un error
            Assertions.assertTrue(false);
        }

    }

    @Test
    public void ListarProductoTest() {
        try {
            List<Producto> lista = productoService.listarProductos();
            lista.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
