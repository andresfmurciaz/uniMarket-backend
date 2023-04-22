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

    Producto autorizarProducto() throws  Exception;

    Producto prohibirProducto() throws  Exception;

    List<Producto> listaProductosEstado() throws Exception;

    Moderador registrarUsuario() throws Exception;

    Moderador actualizarUsuario() throws  Exception;

    void eliminarUsuario()throws Exception;

}
