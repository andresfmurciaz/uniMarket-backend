package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModeradorServiceImpl implements ModeradorService
{



    @Override
    public Moderador iniciarSesion(String email, String password) throws Exception {
        return null;
    }

    @Override
    public Producto autorizarProducto() throws Exception {
        return null;
    }

    @Override
    public Producto prohibirProducto() throws Exception {
        return null;
    }

    @Override
    public List<Producto> listaProductosEstado() throws Exception {
        return null;
    }

    @Override
    public Moderador registrarUsuario() throws Exception {
        return null;
    }

    @Override
    public Moderador actualizarUsuario() throws Exception {
        return null;
    }

    @Override
    public void eliminarUsuario() throws Exception {

    }
}