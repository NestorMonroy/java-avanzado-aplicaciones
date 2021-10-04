INSERT INTO `tienda_musical`.`tipoidentificacion`
(`nombre`,
`fechaCreacion`,
`fechaModificacion`,
`estatus`)
VALUES
('INE',now(),now(),1);
SELECT * FROM tienda_musical.tipoidentificacion;


INSERT INTO `tienda_musical`.`rol`
(`nombre`,
`fechaCreacion`,
`fechaModificacion`,
`estatus`)
VALUES
('user',now(),now(),1);

SELECT * FROM tienda_musical.rol;


UPDATE `tienda_musical`.`rol`
SET
`nombre` = 'admin'
WHERE `idRol` = 3;


INSERT INTO `tienda_musical`.`persona`
(`numeroIdentificacion`,
`nombre`,
`primerApellido`,
`segundoApellido`,
`idTipoIdentificacion`,
`usuario`,
`password`,
`idRol`,
`fechaCreacion`,
`fechaModificacion`,
`estatus`)
VALUES
(1234,
'Joel',
'Con',
'',
5,
'joel',
'12345',
4,
now(),
now(),
1);
SELECT * FROM tienda_musical.persona;






SELECT a.*, ar.* 
FROM album a 
INNER JOIN artista ar ON a.idArtista = ar.idArtista
INNER JOIN subgenero sg ON ar.idSubGenero = sg.idSubGenero
INNER JOIN genero g ON sg.idGenero = g.idGenero
WHERE ar.nombre LIKE '%Meta%'
OR g.descripcion LIKE '%Meta%'
OR sg.descripcion LIKE '%Meta%'
OR ar.nombre LIKE '%Meta%'
ORDER BY ar.nombre 