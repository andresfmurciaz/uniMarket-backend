
/*-----------USUARIO---------------------*/
 insert into usuario values(1,"Andres Felipe","andres@gmail.com","123","chilacoa 12","3224977434");
 insert into usuario values(2,"Andrea Sanchez","andrea@gmail.com","123","chilacoa 13","3254977434");
 insert into usuario values(3,"Juan","juan@gmail.com","123","chilacoa 14","323977434");
 insert into usuario values(4,"Camila","camila@gmail.com","123","chilacoa 15","3214977434");
 insert into usuario values(5,"Juliana","juliana@gmail.com","123","chilacoa 16","3254977434");
 insert into usuario values(6,"Carlos","carlos@gmail.com","123","chilacoa 17","3264977434");
 insert into usuario values(7,"Lola","lola@gmail.com","123","chilacoa 18","3274977434");
 insert into usuario values(8,"Luis","luis@gmail.com","123","chilacoa 19","3244977434");
 insert into usuario values(9,"Raquel","Raquel@gmail.com","123","chilacoa 20","3223477434");
 insert into usuario values(10,"Mario","mario@gmail.com","123","chilacoa 21","4224977434");

/*-----------MODERADOR---------------------*/
 insert into moderador values(1,"Luis","luis@gmail.com","123");
 insert into moderador values(2,"Raquel","Raquel@gmail.com","1234");
 insert into moderador values(3,"Mario","mario@gmail.com","12345");

/*-----------CATEGORIA---------------------*/

insert into categoria(codigo,nombre)values (1,"juguetes");
insert into categoria(codigo,nombre)values (2,"hogar");
insert into categoria(codigo,nombre)values (3,"zapatos");
insert into categoria(codigo,nombre)values (4,"vehiculos");
insert into categoria(codigo,nombre)values (5,"ropa");

/*-----------PRODUCTO---------------------*/
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (1,"carro juguete",5,"jueguete de madera con 4 ruedas",20000,1,'2021-04-08','2024-05-08',1,1);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (2,"avion de juguete",6,"jueguete de madera con dos alas",10000,1,'2021-04-08','2024-05-08',1,1);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (3,"lamp luz blanca",10,"lampara de fibra de vidrio de color blanco",50000,1,'2021-04-08','2024-05-08',2,2);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (4,"biblioteca para libros",3,"biblioteca para 10-20 librose madera",130000,1,'2021-04-08','2024-05-08',2,2);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (5,"Zapatos adidas hombre",4,"Zapatos adidas para hombre talla 39 color blanco",150000,1,'2021-04-08','2024-05-08',3,3);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (6,"Zapatos adidad mujer",3,"Zapatos adidas para hombre talla 36 color blanco",130000,1,'2021-04-08','2024-05-08',4,3);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (7,"forro para carro",5,"forro para carro ancho 1.20 largo 3",180000,1,'2021-04-08','2024-05-08',5,4);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (8,"Limpiador interno para carros",4,"liquido para limpiar la tapiceria del carro",40000,1,'2021-04-08','2024-05-08',5,4);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo,categoria_codigo) values (9,"chaqueta marca nike hombre",1,"chaqueta nike talla L para hombre color negro",230000,1,'2021-04-08','2024-05-08',6,5);

/*-----------COMPRA---------------------*/
/* -1- el usuario 7 compro 3 productos diferentes con un valor total de $120.000 y los pago en efectivo*/
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(1,'2023-04-08 13:30:00',120000,"efectivo",7);

/* -2- el usuario 8 compro 1 producto  con un valor total de $30.000 y los pago a credito*/
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(2,'2023-03-08 13:30:00',30000,"credito",8);

/* -3- el usuario 9 compro 2 productos  con un valor total de $280.000 y los pago a credito*/
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(3,'2023-03-08 13:30:00',280000,"credito",9);

/* -4- el usuario 10 compro 1 producto  con un valor total de $230.000 y los pago con sistecredito*/
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(4,'2023-02-08 13:30:00',230000,"sistecredito",10);

/* -5- el usuario 7 compro 1 producto con un valor total de $230.000 y los pago en efectivo*/
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(5,'2023-02-08 13:30:00',150000,"efectivo",7);

insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(6,'2023-01-08 13:30:00',130000,"efectivo",7);

insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(7,'2023-01-08 13:30:00',120000,"efectivo",10);

insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(8,'2022-08-08 13:30:00',230000,"credito",8);


/*-----------DETALLE-COMPRA---------------------*/
/* -1- el usuario 7 compro 3 productos diferentes con un valor total de $120.000 y los pago en efectivo*/
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(1,20000,2,1,1);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(2,10000,3,2,1);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(3,50000,1,3,1);

/* -2- el usuario 8 compro 1 producto  con un valor total de $30.000 y los pago a credito*/
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(4,10000,3,2,2);

/* -3- el usuario 9 compro 2 productos  con un valor total de $280.000 y los pago a credito*/
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(5,150000,1,5,3);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(6,130000,1,6,3);

/* -4- el usuario 10 compro 1 producto  con un valor total de $230.000 y los pago con sistecredito*/
insert into detalle_compra (codigo,precio_producto,unidaes,producto_codigo,compra_codigo)values(7,230000,1,9,4);

/* -5- el usuario 7 compro 1 producto con un valor total de $230.000 y los pago en efectivo*/
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(8,230000,1,9,5);





/*-----------IMAGEN---------------------*/
insert into imagen(id_imagen,ruta,producto_codigo)values (1,"rutaimg",1);
insert into imagen(id_imagen,ruta,producto_codigo)values (2,"rutaimg",1);
insert into imagen(id_imagen,ruta,producto_codigo)values (3,"rutaimg",1);

/*-----------COMENTARIO---------------------*/
insert into comentario(codigo,fecha_creacion,mensaje,producto_codigo,usuario_codigo) values (1,'2023-04-08',"hola este producto es muy bueno",1,7);;
insert into comentario(codigo,fecha_creacion,mensaje,producto_codigo,usuario_codigo) values (2,'2023-04-08',"hola este producto es muy bueno",2,8);;
insert into comentario(codigo,fecha_creacion,mensaje,producto_codigo,usuario_codigo) values (3,'2023-04-08',"hola este producto es muy bueno",3,9);;
insert into comentario(codigo,fecha_creacion,mensaje,producto_codigo,usuario_codigo) values (4,'2023-04-08',"hola este producto es muy bueno",4,9);;

/*-----------ESTADO---------------------*/

insert into estado values(1,"activo");
insert into estado values (2,"inactivo");

/*-----------PRODUCTO-MODERADOR---------------------*/
insert into producto_moderador(codigo,fecha,motivo,estado_codigo,moderador_codigo,producto_codigo) values (1,'2023-04-08',"mirar si esta bien",1,1,1);
insert into producto_moderador(codigo,fecha,motivo,estado_codigo,moderador_codigo,producto_codigo) values (2,'2023-04-08',"mirar si esta bien",1,1,2);
insert into producto_moderador(codigo,fecha,motivo,estado_codigo,moderador_codigo,producto_codigo) values (3,'2023-04-08',"mirar si esta bien",1,2,3);






