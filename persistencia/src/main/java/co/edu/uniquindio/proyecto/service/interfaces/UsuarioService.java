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

    List<Usuario> listarUsuarios();


    List <Producto>listaFavoritos(String correo);






    Usuario iniciarSesion(String email, Integer password) throws Exception;

    Usuario recuperarContrasena() throws Exception;

    Usuario obtenerUsuario(String codigo) throws Exception;
}
