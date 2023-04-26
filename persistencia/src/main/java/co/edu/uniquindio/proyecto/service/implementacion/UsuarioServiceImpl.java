package co.edu.uniquindio.proyecto.service.implementacion;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    //se crea variable para acceder a los repo , no se usa el @wit.. poe que el ide nbos recomienda crear un cosntructor

    //no funciona el autocompletado
    //@Autowired
    //private JavaMailSender mailSender;

    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 10;

    public UsuarioServiceImpl(UsuarioRepo usuarioRepo, ProductoRepo productoRepo)
    {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
    }

    /*
    public void sendEmail(String toEmail, String username, String password) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Nueva contraseña");
        message.setText("Tu usuario es: " + username + "\nTu nueva contraseña es: " + password);

        mailSender.send(message);
    }
*/
    private static final Random RANDOM = new SecureRandom();

    public static String generarRandomString()
    {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }






    /*--------------------------------*/

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception
    {
        //busca el usuario para que valide que la cedula y email no este repetida
        Optional<Usuario> buscado = usuarioRepo.findById(usuario.getCodigo());
        if(buscado.isPresent()) {throw  new Exception("el codigo del usuairo ya existe");}

        buscado = usuarioRepo.findByEmail(usuario.getEmail());
        if(buscado.isPresent()) {throw  new Exception("el email del usuario ya existe");}

        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception
    {
        //busca el usuario para que valide  email no este repetida

        Optional<Usuario> buscado = usuarioRepo.findByEmail(usuario.getEmail());
        if(buscado.isPresent()) {throw  new Exception("el email del usuario ya existe");}

        return usuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(int codigo) throws Exception
    {
        //busca el usuario para que valide que la cedula si exista
        Optional<Usuario> buscado = usuarioRepo.findByCodigo(codigo);
        if(buscado.isEmpty()) {throw  new Exception("el codigo del usuario no existe");}

        usuarioRepo.deleteById(codigo);
    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioRepo.findAll();
    }



    @Override
    public List<Producto> listaFavoritos(String correo) throws Exception
    {
        Optional <Usuario> buscado = usuarioRepo.findByEmail(correo);
        if(buscado.isEmpty()) {throw  new Exception("el email del usuario no existe");}

        return productoRepo.obtenerProductosFavoritos(correo);

    }

    @Override
    public Usuario obtenerUsuario(int codigo) throws Exception
    {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()) {throw  new Exception("el codigo del usuairo no existe");}

        //se usa para obtener el usuario del optional
        return buscado.get();
    }


    /*--------------------------------*/



    @Override
    public Usuario iniciarSesion(String email, String password) throws Exception {

        //llamo al repo para que me busque por medio del email y la contra
        Optional<Usuario> usuario =usuarioRepo.findByEmailAndPassword(email,password);

        //miro si el arreglo esta vacio y si lo esta tiro una exception
        if(usuario.isEmpty())
        {
            throw new Exception("los datos de autenticacion son incorrectos");
        }

        return usuario.get();

    }



    @Override
    public Usuario recuperarContrasena(Usuario usuario) throws Exception
    {
        Optional <Usuario> buscado = usuarioRepo.findByEmail(usuario.getEmail());
        if(buscado.isEmpty()) {throw  new Exception("el email del usuario no existe");}

        String password= generarRandomString();
        usuario.setPassword(password);
        usuarioRepo.save(usuario);
        //metodo que me manda la contra nueva por el correo
        //mandarContraseñaCorreo(usuario.getEmail(),usuario.getPassword());
        return usuario;
    }


}
