package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Detalle_Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleCompraTest {


    @Autowired
    private ProductoRepo productoRepo;
    //nos ayuda a instan la class
    @Autowired
    private CompraRepo compraRepo;
    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest() {
        //llamo producto y compra del data set para mad¿ndarlo al detalle compra
        Producto producto1 = productoRepo.findById(1).orElse(null);
        Compra compra1= compraRepo.findById(1).orElse(null);
        Detalle_Compra detalleCompra = new Detalle_Compra(1,20000,3,producto1,compra1);
        Detalle_Compra detalleGuardado= detalleCompraRepo.save(detalleCompra);
        Assertions.assertNotNull(detalleGuardado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        detalleCompraRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Detalle_Compra detalleCompraBuscado = detalleCompraRepo.findById(1).orElse(null);
        Assertions.assertNull(detalleCompraBuscado);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Detalle_Compra detalle1 = detalleCompraRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        detalle1.setPrecio_producto(15000);
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        detalleCompraRepo.save(detalle1);
        //busca el usuario con el id indicado
        Detalle_Compra detallebuscarlo= detalleCompraRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals(15000,detallebuscarlo.getPrecio_producto());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {
        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Detalle_Compra> detalle_compras = detalleCompraRepo.findAll();
        System.out.println(detalle_compras);

    }






}
