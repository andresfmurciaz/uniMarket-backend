# uniMarket
uniMarket es una tienda en línea donde se comercializan diferentes tipos de productos, un usuario puede tanto publicar productos que desee vender como comprar los productos que le interesen.

## Sobre el Proyecto

Este proyecto está desarrollado en Java y utiliza una base de datos MySQL para almacenar y gestionar los datos. La estructura del proyecto sigue una arquitectura basada en capas, con las siguientes carpetas principales:

- **DTO:** En esta carpeta encontrarás los Data Transfer Objects que facilitan la comunicación entre diferentes capas del proyecto.

- **Controladores:** Aquí se encuentran los controladores encargados de gestionar las solicitudes y respuestas HTTP.

- **Entidades:** Contiene las clases que representan las entidades en la base de datos, lo que facilita la interacción con la misma.

- **Repositorios:** En esta carpeta se encuentran las clases responsables de interactuar con la base de datos mediante consultas SQL.

- **Servicios:** Aquí se implementa la lógica de negocio y se orquesta la comunicación entre controladores y repositorios.

## Tecnologías Utilizadas

- **Lenguaje de Programación:** Java
- **Base de Datos:** MySQL
- **Estructura del Proyecto:** Arquitectura basada en capas (DTO, Controladores, Entidades, Repositorios, Servicios)

## Ejemplo de Código Destacado

```java
// Inserta un nuevo registro en la base de datos
public void insertarNuevoRegistro(Entidad entidad) {
    // Código de inserción en la base de datos
}
