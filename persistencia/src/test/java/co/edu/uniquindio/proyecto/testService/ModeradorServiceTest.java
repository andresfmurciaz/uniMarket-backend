package co.edu.uniquindio.proyecto.testService;

import co.edu.uniquindio.proyecto.PersistenciaApplication;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
//que clase se esta probando?
@SpringBootTest(classes = PersistenciaApplication.class)
//no afecta la base de datos
@Transactional
public class ModeradorServiceTest {

    @Autowired
    private ModeradorService moderadorService;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void obtenerModerador(){


    }



}
