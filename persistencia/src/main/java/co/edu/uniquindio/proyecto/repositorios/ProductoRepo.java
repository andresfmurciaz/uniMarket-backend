package co.edu.uniquindio.proyecto.repositorios;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {


    //consulta que me retorna el numero de productos que hay por cada tipo
    @Query("select c.nombre,count(p) from Producto p join p.categoria c group by c")
    List<Object[]> obtenerTotalProductosCategoria();


    //obtener productos sin comentarios-me devolvera loaproductos cuya lista de comentarios este vacia
    @Query("select p from  Producto p where p.comentarios is empty ")
    List<Producto> obtenerProductosSinComentarios();


    //obtener productos con comentarios-me devolvera loaproductos 
    @Query("select p.comentarios from  Producto p  ")
    List<Producto> obtenerProductosConComentarios();




    //obtener los productos que en el nombre contenga el sring digitado
    List<Producto> findByNombreContains(String nombre);


    //obter los productos fav
    @Query("select p from Usuario u , IN (u.productos) p where u.email = :email")
    List<Producto> obtenerProductosFavoritos(String email);


    Optional<Producto> findByCodigo(int codigo);


}
