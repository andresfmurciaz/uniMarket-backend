package co.edu.uniquindio.proyecto.testService;

import co.edu.uniquindio.proyecto.PersistenciaApplication;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;

//que clase se esta probando?
@SpringBootTest(classes = PersistenciaApplication.class)
//no afecta la base de datos
@Transactional
public class UsuarioServiceTest
{

    //lo que el usuario final va llamar por eso no es igual a los test de los repo

    @Autowired
    private UsuarioService usuarioService;


    @Test
    public void registrarTest()
    {
        Usuario usuario = new Usuario(1,"andres","andres@gmail.com","2000","chilacoa","3224977434");
        try {
          Usuario respuesta =  usuarioService.registrarUsuario(usuario);
          System.out.println(respuesta);
          Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




}
