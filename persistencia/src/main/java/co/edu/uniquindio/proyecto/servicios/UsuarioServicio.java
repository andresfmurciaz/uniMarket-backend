package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;

// interfas de seervicio de usuario
public interface UsuarioServicio {

    // se crea el metodo registrar usuario
    int registraUsuario(Usuario usuario);

    Usuario actualizarUsuario( int codigo, Usuario usuario);

    int eliminarUsuario(int codigo);


    Usuario obtenerUsuario(int codigo);


}
