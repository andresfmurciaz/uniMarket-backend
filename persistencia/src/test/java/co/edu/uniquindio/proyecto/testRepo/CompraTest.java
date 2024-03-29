package co.edu.uniquindio.proyecto.testRepo;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;

    @Test
    public void registrarTest()
    {
        Compra compra = new Compra(1, LocalDateTime.now(),30000,"credito");
        Compra compraGuardado= compraRepo.save(compra);
        Assertions.assertNotNull(compraGuardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        compraRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Compra compraBuscado = compraRepo.findById(1).orElse(null);
        Assertions.assertNull(compraBuscado);
    }



    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Compra compra1 = compraRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        compra1.setValor_total(31000);
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        compraRepo.save(compra1);
        //busca el usuario con el id indicado
        Compra compraBuscado= compraRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals(31000,compraBuscado.getValor_total());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {

        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Compra> compras = compraRepo.findAll();
        System.out.println(compras);

    }




}
