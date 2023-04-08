
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
 insert into moderador values(2,"Raquel","Raquel@gmail.com","123");
 insert into moderador values(3,"Mario","mario@gmail.com","123");

/*-----------PRODUCTO---------------------*/
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (1,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',1);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (2,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',1);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (3,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',2);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (4,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',2);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (5,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',3);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (6,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',4);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (7,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',5);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (8,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',5);
insert into producto (codigo,nombre,unidades,descripcion,precio,activo,fecha_creado,fecha_limite,usuario_codigo) values (9,"carro juguete",3,"jueguete de madera con 4 ruedas",20000,1,'2023-04-08','2023-05-08',6);

/*-----------COMPRA---------------------*/
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(1,'2023-04-08 13:30:00',30000,"efectivo",1);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(2,'2023-04-08 13:30:00',30000,"efectivo",2);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(3,'2023-04-08 13:30:00',30000,"efectivo",3);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(4,'2023-04-08 13:30:00',30000,"efectivo",4);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(5,'2023-04-08 13:30:00',30000,"efectivo",5);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(6,'2023-04-08 13:30:00',30000,"efectivo",6);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(7,'2023-04-08 13:30:00',30000,"efectivo",7);
insert into compra (codigo ,fecha_creacion,valor_total,medio_pago,usuario_codigo)values(8,'2023-04-08 13:30:00',30000,"efectivo",8);


/*-----------DETALLE-COMPRA---------------------*/
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(1,30000,3,1,1);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(2,30000,3,2,2);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(3,30000,3,3,3);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(4,30000,3,4,4);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(5,30000,3,5,5);
insert into detalle_compra (codigo,precio_producto,unidades,producto_codigo,compra_codigo)values(6,30000,3,6,6);

/*-----------CATEGORIA---------------------*/

insert into categoria(codigo,nombre,producto_codigo)values (1,"juguetes",1);
insert into categoria(codigo,nombre,producto_codigo)values (2,"hogar",1);
insert into categoria(codigo,nombre,producto_codigo)values (3,"zapatos",1);
insert into categoria(codigo,nombre,producto_codigo)values (4,"vehiculos",1);
insert into categoria(codigo,nombre,producto_codigo)values (5,"ropa",1);






/*





insert into favorito values (1,1);

insert into comentario values (1,"hola este producto es muy bueno","2000/10/09",1,1);

insert into producto_moderador values (1,"mirar si esta bien","2000/10/09",1,1,1);

insert into estado values(1,"activo");
insert into stado values (2,"inactivo");



insert into imagen values(1,20,"www.hola.png",1);
*/


