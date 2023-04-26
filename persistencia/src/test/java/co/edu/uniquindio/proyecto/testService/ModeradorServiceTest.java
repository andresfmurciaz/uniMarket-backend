package co.edu.uniquindio.proyecto.testService;

import co.edu.uniquindio.proyecto.PersistenciaApplication;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//que clase se esta probando?
@SpringBootTest(classes = PersistenciaApplication.class)
//no afecta la base de datos
@Transactional
public class ModeradorServiceTest {

    @Autowired
    private ModeradorService moderadorService;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void registrarModeradorTest()
    {
        Moderador moderador = new Moderador(1,"andres","andres@gmail.com","2000");
        try {
            Moderador respuesta =  moderadorService.registrarModerador(moderador);
            System.out.println(respuesta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void actualizarModeradorTest()
    {
        Moderador moderador = new Moderador(1,"andres","andres@gmail.com","2000");
        try {
            Moderador respuesta =  moderadorService.actualizarModerador(moderador);
            System.out.println(respuesta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void eliminarModeradorTest()
    {
        try {
            moderadorService.eliminarModerador(3);
        } catch (Exception e) {
            //me imprime la exception
            e.printStackTrace();
            //para forzar un error
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void ListarModeradorTest()
    {
        try {
            List<Moderador> lista = moderadorService.listaModeradores();
            lista.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




}
