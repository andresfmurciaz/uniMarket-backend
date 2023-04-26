package co.edu.uniquindio.proyecto.service.interfaces;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface UsuarioService {

    /*requerimientos Usuario
-Al olvidar su contraseña puede cambiarla por medio de un link enviado a su correo electrónico.
-Registrarse y loguearse.
     * */

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario) throws  Exception;

    void eliminarUsuario(int codigo)throws Exception;

    List<Usuario> listarUsuarios() throws Exception;

    Usuario obtenerUsuario(int codigo) throws Exception;

    Usuario iniciarSesion(String email, String password) throws Exception;

    Usuario recuperarContrasena(Usuario usuario) throws Exception;

    List <Producto>listaFavoritos(String correo) throws Exception;

}
