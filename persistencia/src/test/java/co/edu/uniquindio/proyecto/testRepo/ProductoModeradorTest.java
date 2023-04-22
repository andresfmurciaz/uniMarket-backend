package co.edu.uniquindio.proyecto.testRepo;

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
public class ProductoModeradorTest {

    @Autowired
    private ProductoRepo productoRepo;
    //nos ayuda a instan la class
    @Autowired
    private ModeradorRepo moderadorRepo;
    @Autowired
    private EstadoRepo estadoRepo;
    @Autowired
    private ProductoModeradorRepo productoModeradorRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest() {
        //llamo producto , moderador y estado del data set para mad¿ndarlo al detalle compra
        Producto producto1 = productoRepo.findById(1).orElse(null);
        Moderador moderador1= moderadorRepo.findById(1).orElse(null);
        Estado estado1=estadoRepo.findById(1).orElse(null);


        Producto_Moderador productoModerador = new Producto_Moderador(1,"organizar publicacion legal mente", LocalDate.of(2023, 4, 7),producto1,estado1,moderador1);

        Producto_Moderador productoModeradorGuardado= productoModeradorRepo.save( productoModerador);
        Assertions.assertNotNull(productoModeradorGuardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        productoModeradorRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Producto_Moderador productoModerador = productoModeradorRepo.findById(1).orElse(null);
        Assertions.assertNull(productoModerador);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Producto_Moderador moderadorProductoDetalle = productoModeradorRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        moderadorProductoDetalle.setMotivo("actualizacion de prueba");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        productoModeradorRepo.save(moderadorProductoDetalle);
        //busca el usuario con el id indicado
        Producto_Moderador detallebuscarlo= productoModeradorRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("actualizacion de prueba",detallebuscarlo.getMotivo());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {
        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Producto_Moderador> detalle_compras = productoModeradorRepo.findAll();
        System.out.println(detalle_compras);

    }



}
