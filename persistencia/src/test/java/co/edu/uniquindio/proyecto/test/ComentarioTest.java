package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {


    @Autowired
    private ProductoRepo productoRepo;
    //nos ayuda a instan la class
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest() {

        Producto producto1 = productoRepo.findById(1).orElse(null);
        Usuario usuario1 = usuarioRepo.findById(1).orElse(null);


        Comentario comentario = new Comentario(1,"hola este es un comentario al producto", LocalDate.of(2023, 4, 7),producto1,usuario1);
        Comentario comentarioGuardado= comentarioRepo.save(comentario);
        Assertions.assertNotNull(comentarioGuardado);
    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        comentarioRepo.deleteById(1);
        //buscar el comentario y si no lo encuentra me da null
        Comentario comentario = comentarioRepo.findById(1).orElse(null);
        Assertions.assertNull(comentario);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Comentario detalle1 = comentarioRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        detalle1.setMensaje("mensaje de actuali");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        comentarioRepo.save(detalle1);
        //busca el usuario con el id indicado
        Comentario detallebuscarlo=comentarioRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("mensaje de actuali",detallebuscarlo.getMensaje());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {
        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Comentario> detalle_compras = comentarioRepo.findAll();
        System.out.println(detalle_compras);

    }



}
