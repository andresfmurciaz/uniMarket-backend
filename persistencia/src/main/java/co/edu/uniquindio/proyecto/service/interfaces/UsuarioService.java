package co.edu.uniquindio.proyecto.service.interfaces;

import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface UsuarioService {

    /*requerimientos Usuario
-Al olvidar su contraseña puede cambiarla por medio de un link enviado a su correo electrónico.
-Registrarse y loguearse.
     * */

    Usuario registrarUsuario() throws Exception;
    Usuario actualizarUsuario() throws  Exception;
    void eliminarUsuario()throws Exception;
    Usuario iniciarSesion() throws Exception;
    Usuario recuperarContrasena() throws Exception;

}
