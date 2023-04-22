package co.edu.uniquindio.proyecto.testRepo;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ImagenRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
//se usa para que se conecto conla configuraciond de la BD
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImagenTest {


    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private ImagenRepo imagenRepo;


    @Test
    @Sql("classpath:usuarios.sql")
    public void registrarTest() {
        //llamo producto y compra del data set para mad¿ndarlo al detalle compra
        Producto producto1 = productoRepo.findById(1).orElse(null);

       Imagen imagen= new Imagen(1,"img_ruta",producto1);
        Imagen imagenGuardado= imagenRepo.save(imagen);
        Assertions.assertNotNull(imagenGuardado);
    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void EliminarTest()
    {
        imagenRepo.deleteById(1);
        //buscar el usuario y si no lo encuentra me da null
        Imagen categoriaBuscado = imagenRepo.findById(1).orElse(null);
        Assertions.assertNull(categoriaBuscado);
    }



    @Test
    @Sql("classpath:usuarios.sql")
    public void ActualizarTest()
    {
        //se busca el usuario en el data setb
        Imagen compra1 = imagenRepo.findById(1).orElse(null);
        //le mando el cambio a ese objeto
        compra1.setRuta("rutaimgactuali");
        //vuelvo y lo guardo en el repositorio lo busca y si encuentra con el mismo id lo reemplaza
        imagenRepo.save(compra1);
        //busca el usuario con el id indicado
        Imagen imagenBuscado= imagenRepo.findById(1).orElse(null);
        //compara si se realizo el cambio
        Assertions.assertEquals("rutaimgactuali",imagenBuscado.getRuta());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarTest()
    {
        //lista por medio de la clase del repo a todo lo que tenga en la base de datos
        List<Imagen> imagenes = imagenRepo.findAll();
        System.out.println(imagenes);
    }




}
