package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Detalle_Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaTest {



    @Autowired
    private CategoriaRepo categoriaRepo;


    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest() {

       Categoria categoria= new Categoria(1,"juguetes");
        Categoria categoriaGuardado= categoriaRepo.save(categoria);
        Assertions.assertNotNull(categoriaGuardado);
    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        categoriaRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Categoria categoriaBuscado = categoriaRepo.findById(1).orElse(null);
        Assertions.assertNull(categoriaBuscado);
    }



    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Categoria compra1 = categoriaRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        compra1.setNombre("ropa");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        categoriaRepo.save(compra1);
        //busca el usuario con el id indicado
        Categoria compraBuscado= categoriaRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("ropa",compraBuscado.getNombre());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {

        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Categoria> categorias = categoriaRepo.findAll();
        System.out.println(categorias);

    }





}
