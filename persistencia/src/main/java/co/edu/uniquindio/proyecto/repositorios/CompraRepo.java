package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra,Integer>
{

    //consulta que nos retorna todo el objeto del producto en una lista
    @Query("select d.producto from Compra c join c.detalle_compras d where c.usuario.codigo = :codigo")
    List<Producto> obtenerListaProductosComprados(int codigo);

    //consulta que nos retorna el numero de compras que hizo el usuario sin tener en cuenta los repetidos
    @Query("select count ( distinct d.producto) from Compra c join c.detalle_compras d where c.usuario.codigo = :codigo")
    Long obtenerNumeroProductosComprados(int codigo);





}
