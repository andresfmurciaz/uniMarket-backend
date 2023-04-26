package co.edu.uniquindio.proyecto.testService;

import co.edu.uniquindio.proyecto.PersistenciaApplication;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;
import java.util.List;

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

    @Test
    public void actualizarTest()
    {
        Usuario usuario = new Usuario(1,"andrea","andres@gmail.com","2000","chilacoaa","3224977434");
        try {
            Usuario respuesta =  usuarioService.actualizarUsuario(usuario);
            System.out.println(respuesta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void eliminarUsuario()
    {
        try {
            usuarioService.eliminarUsuario(3);
        } catch (Exception e) {
            //me imprime la exception
            e.printStackTrace();
            //para forzar un error
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void ListarUsuario()
    {
        try {
            List<Usuario> lista = usuarioService.listarUsuarios();
            lista.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void iniciarSesion()
    {
        try
        {
            Usuario usuario = usuarioService.iniciarSesion("Andres Felipe","123");
            System.out.println(usuario);
            Assertions.assertNotNull(usuario);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void listaProductosFav(){
        try {
            List<Producto> productosFavoritos =usuarioService.listaFavoritos("Andres felipe");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
