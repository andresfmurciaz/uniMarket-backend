package co.edu.uniquindio.proyecto.service.interfaces;

import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface UsuarioService {

    /*requerimientos Usuario
-Al olvidar su contraseña puede cambiarla por medio de un link enviado a su correo electrónico.
-Registrarse y loguearse.
     * */

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario) throws  Exception;

    void eliminarUsuario(String codigo)throws Exception;

    Usuario iniciarSesion(String email,String password) throws Exception;

    Usuario recuperarContrasena() throws Exception;

    Usuario obtenerUsuario(String codigo) throws Exception;
}
