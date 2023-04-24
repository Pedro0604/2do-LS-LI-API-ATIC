
Program crearPrendas;

Uses 
Sysutils;

Type 
  prenda = Record
    cod_prenda: integer;
    descripcion: string[50];
    colores: string[50];
    tipo_prenda: string[20];
    stock: integer;
    precio_unitario: real;
  End;

Var 
  arc_prendas: file Of prenda;

Procedure ImprimirPrenda(prenda: prenda);
Begin
  writeln('Código: ', prenda.cod_prenda);
  writeln('Descripción: ', prenda.descripcion);
  writeln('Colores: ', prenda.colores);
  writeln('Tipo de prenda: ', prenda.tipo_prenda);
  writeln('Stock: ', prenda.stock);
  writeln('Precio unitario: $', prenda.precio_unitario:0:2);
End;

Procedure ImprimirArchivoPrendas();

Var 
  prenda_actual: prenda;
Begin
  // Abrir el archivo de prendas
  Assign(arc_prendas, 'prendas.dat');
  Reset(arc_prendas);

  // Leer cada registro de prenda y llamar al procedimiento ImprimirPrenda
  While Not EOF(arc_prendas) Do
    Begin
      Read(arc_prendas, prenda_actual);
      ImprimirPrenda(prenda_actual);
      writeln('-----------------------');
    End;

  // Cerrar el archivo de prendas
  Close(arc_prendas);
End;


Var 
  i: integer;
  nueva_prenda: prenda;
Begin


  // Asignar una semilla aleatoria para la función Randomize
  Randomize;

  // Crear el archivo de prendas
  Assign(arc_prendas, 'prendas.pr');
  Rewrite(arc_prendas);

  // Generar 50 registros de prendas con campos aleatorios y escribirlos en el archivo
  For i := 1 To 50 Do
    Begin
      nueva_prenda.cod_prenda := Random(1000);
      nueva_prenda.descripcion := 'Prenda ' + IntToStr(i);
      nueva_prenda.colores := 'Rojo, Verde, Azul';
      nueva_prenda.tipo_prenda := 'Tipo ' + IntToStr(Random(5));
      nueva_prenda.stock := Random(100);
      nueva_prenda.precio_unitario := Random(1000) + 100;
      Write(arc_prendas, nueva_prenda);
    End;

  // Cerrar el archivo de prendas
  Close(arc_prendas);
  ImprimirArchivoPrendas();
End.
