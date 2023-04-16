package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {


    @Autowired
    private ProductoRepo productoRepo;
    //nos ayuda a instan la class
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Autowired
    private CompraRepo compraRepo;


    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest() {

        Categoria categoria1= categoriaRepo.findById(1).orElse(null);
        Usuario usuario1 = usuarioRepo.findById(1).orElse(null);
        Producto producto = new Producto(8,"celular redmi 8",1,"celular redmi con 30 pixeles y 8 g de ram",660000, 1, LocalDate.of(2023, 4, 7),LocalDate.of(2023, 5, 7),usuario1,categoria1);
        Producto productoGuardado= productoRepo.save(producto);
        Assertions.assertNotNull(productoGuardado);

    }
    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        productoRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Producto productoBuscado = productoRepo.findById(1).orElse(null);
        Assertions.assertNull(productoBuscado);

    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Producto producto1 = productoRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        producto1.setDescripcion("es un carro con 4 llantas de madera");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        productoRepo.save(producto1);
        //busca el usuario con el id indicado
        Producto productobuscarlo= productoRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("es un carro con 4 llantas de madera",productobuscarlo.getDescripcion());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {
        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Producto> productos = productoRepo.findAll();
        System.out.println(productos);
    }





    //lista los productos comprados por cada personas en este caso se le mando el codigo  7 que es el usuario "Lola"
    @Test
    @Sql("classpath:usuarios.sql")
    public void ListarProductosComprados()
    {
        List<Producto> productos = compraRepo.obtenerListaProductosComprados(7);
        productos.forEach(System.out::println);
    }




}
