package co.edu.uniquindio.proyecto.testRepo;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
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
public class ModeradorTest {

    @Autowired
    private ModeradorRepo moderadorRepo;

    @Test
    public void registrarTest()
    {
        Moderador moderador = new Moderador(1,"andres felipe","andres@gmail.com","123");
        Moderador moderadorGuardado= moderadorRepo.save(moderador);
        Assertions.assertNotNull(moderadorGuardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        moderadorRepo.deleteById(1);
        //buscar el moderador y si no lo encuentra me da null
        Moderador moderadorBuscar = moderadorRepo.findById(1).orElse(null);
        Assertions.assertNull(moderadorBuscar);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Moderador moderador1 = moderadorRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        moderador1.setEmail("andres@gmail.com");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        moderadorRepo.save(moderador1);
        //busca el usuario con el id indicado
        Moderador moderadorBuscado= moderadorRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("andres@gmail.com",moderadorBuscado.getEmail());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {
        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Moderador> moderadors =moderadorRepo.findAll();
        System.out.println("este es todos los moderadores" + moderadors);
    }


}
