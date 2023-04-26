package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeradorServiceImpl implements ModeradorService
{
    //se crea variable para acceder a los repo , no se usa el @wit.. poe que el ide nbos recomienda crear un cosntructor
    private final UsuarioRepo usuarioRepo;
    private final ModeradorRepo moderadorRepo;
    private final ProductoRepo productoRepo;

    public ModeradorServiceImpl(UsuarioRepo usuarioRepo, ProductoRepo productoRepo,ModeradorRepo moderadorRepo)
    {
        this.moderadorRepo=moderadorRepo;
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
    }


    @Override
    public Moderador registrarModerador(Moderador moderador) throws Exception {
        //busca el usuario para que valide que la cedula y email no este repetida
        Optional<Moderador> buscado = moderadorRepo.findById(moderador.getCodigo());
        if(buscado.isPresent()) {throw  new Exception("el codigo del moderador ya existe");}

        buscado = moderadorRepo.findByEmail(moderador.getEmail());
        if(buscado.isPresent()) {throw  new Exception("el email del moredador ya existe");}

        return moderadorRepo.save(moderador);
    }

    @Override
    public Moderador actualizarModerador(Moderador moderador) throws Exception {
        Optional<Moderador> buscado = moderadorRepo.findByEmail(moderador.getEmail());
        if(buscado.isPresent()) {throw  new Exception("el email del moderador ya existe");}

        return moderadorRepo.save(moderador);
    }

    @Override
    public void eliminarModerador(int codigo) throws Exception {
        Optional<Moderador> buscado = moderadorRepo.findByCodigo(codigo);
        if(buscado.isEmpty()) {throw  new Exception("el codigo del moderador no existe");}

        moderadorRepo.deleteById(codigo);
    }

    @Override
    public List<Moderador> listaModeradores() throws Exception {
        return moderadorRepo.findAll();

    }

    @Override
    public Moderador obtenerModerador(int codigo) throws Exception {
        return null;
    }


    @Override
    public Moderador iniciarSesion(String email, String password) throws Exception {
        return null;
    }

    @Override
    public Producto autorizarProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public Producto prohibirProducto(Producto producto) throws Exception {
        return null;
    }


    @Override
    public List<Producto> listaProductosEstado() throws Exception {
        return null;
    }


}
