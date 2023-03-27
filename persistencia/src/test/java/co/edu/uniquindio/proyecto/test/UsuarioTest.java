package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    //nos ayuda a instan la class
    @Autowired
    private UsuarioRepo usuarioRepo;
    //mirar vien la import
    @Test
    public void registrarTest()
    {
        Usuario usuario = new Usuario();

        usuario.setNombre("andres");
        usuario.setDireccion("chilacoa");
        usuario.setCodigo(1);
        usuario.setEmail("andresf@gmail.com");
        usuario.setPassword("123");
        usuario.setTelefono("3168836252");

        Usuario usuarioGuardado= usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void EliminarTest()
    {
        Usuario usuario = new Usuario();

        usuario.setNombre("andres");
        usuario.setDireccion("chilacoa");
        usuario.setCodigo(1);
        usuario.setEmail("andresf@gmail.com");
        usuario.setPassword("123");
        usuario.setTelefono("3168836252");

        usuarioRepo.save(usuario);
        usuarioRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Usuario usuarioBuscado = usuarioRepo.findById(1).orElse(null);
        Assertions.assertNull(usuarioBuscado);

    }


    @Test
    public void ActualizarTest()
    {
        Usuario usuario = new Usuario();
        usuario.setNombre("andres");
        usuario.setDireccion("chilacoa");
        usuario.setCodigo(1);
        usuario.setEmail("andresf@gmail.com");
        usuario.setPassword("123");
        usuario.setTelefono("3168836252");
        //creo un usuario para guardar lo que me devuelve el repo . save
       Usuario usuario1 = usuarioRepo.save(usuario);
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
    public void listarTest()
    {
        Usuario usuario = new Usuario();
        usuario.setNombre("andres");
        usuario.setDireccion("chilacoa");
        usuario.setCodigo(1);
        usuario.setEmail("andresf@gmail.com");
        usuario.setPassword("123");
        usuario.setTelefono("3168836252");
        //creo un usuario para guardar lo que me devuelve el repo . save
        Usuario usuario1 = usuarioRepo.save(usuario);

        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Usuario> usuarios = usuarioRepo.findAll();

        System.out.println(usuarios);



    }





}
