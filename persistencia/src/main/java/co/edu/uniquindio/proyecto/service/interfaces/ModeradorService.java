package co.edu.uniquindio.proyecto.service.interfaces;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface ModeradorService
{

/*requerimientos MODERADOR
-Loguearse.
-Autorizar o prohibir productos.
-La página del moderador (una vez haga login) debe mostrarle la lista de todos los productos según el estado (sin revisar, autorizados y denegados).
*/

    Moderador iniciarSesion(String email, String password) throws Exception;

    Producto autorizarProducto(Producto producto) throws  Exception;

    Producto prohibirProducto(Producto producto) throws  Exception;

    List<Producto> listaProductosEstado() throws Exception;

    Moderador registrarUsuario(Moderador moderador) throws Exception;

    Moderador actualizarUsuario(Moderador moderador) throws  Exception;

    void eliminarUsuario(String codigo)throws Exception;

}
