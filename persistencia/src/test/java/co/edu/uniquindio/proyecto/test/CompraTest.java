package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;

    @Test
    public void registrarTest()
    {
        Compra compra = new Compra(1, LocalDateTime.now(),30000,"credito");
        Compra compraGuardado= compraRepo.save(compra);
        Assertions.assertNotNull(compraGuardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        compraRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Compra compraBuscado = compraRepo.findById(1).orElse(null);
        Assertions.assertNull(compraBuscado);
    }
/*

    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Usuario usuario1 = usuarioRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        usuario1.setEmail("andres@gmail.com");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        usuarioRepo.save(usuario1);
        //busca el usuario con el id indicado
        Usuario usuarioBuscado= usuarioRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("andres@gmail.com",usuarioBuscado.getEmail());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {

        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Usuario> usuarios = usuarioRepo.findAll();

        System.out.println(usuarios);

    }


*/

}
