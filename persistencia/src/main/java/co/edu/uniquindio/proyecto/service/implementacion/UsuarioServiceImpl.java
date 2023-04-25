package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    //se crea variable para acceder a los repo , no se usa el @wit.. poe que el ide nbos recomienda crear un cosntructor
    private final UsuarioRepo usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepo usuarioRepo)
    {
        this.usuarioRepo = usuarioRepo;
    }


    /*--------------------------------*/

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {



        return null;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {

    }

    @Override
    public List<Usuario> listarUsuarios() {
        return null;
    }


    /*--------------------------------*/



    @Override
    public Usuario iniciarSesion(String email, Integer password) throws Exception {

        //llamo al repo para que me busque por medio del email y la contra
        Optional<Usuario> usuario =usuarioRepo.findByEmailAndPassword(email,password);
        //miro si el arreglo esta vacio y si lo esta tiro una exception
        if(usuario.isEmpty())
        {
            throw new Exception("los datos de autenticacion son incorrectos");
        }
        return usuario.get();

    }


/*
    @Override
    public Usuario iniciarSesion(String email, Integer password) throws Exception
    {
        //llamo al repo para que me busque por medio del email y la contra
        Optional<Usuario> usuario =usuarioRepo.findByEmailAndPassword(email,password);
        //miro si el arreglo esta vacio y si lo esta tiro una exception
        if(usuario.isEmpty())
        {
            throw new Exception("los datos de autenticacion son incorrectos");
        }
        return usuario.get();
    }

*/

    @Override
    public Usuario recuperarContrasena() throws Exception {
        return null;
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        return null;
    }
}
