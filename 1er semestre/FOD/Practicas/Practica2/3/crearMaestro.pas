
Program crearMaestro;

Uses 
SysUtils;

Type 
  producto = Record
    codigo: integer;
    nombre, descripcion: string;
    stockD, stockM : integer;
    precio : real;
  End;

  file_productos = file Of producto;



Procedure inicializarProductos(Var productos: Array Of producto);

Var 
  i: integer;
Begin
  randomize;
  For i := 0 To Length(productos) - 1 Do
    Begin
      productos[i].codigo := i + 1;
      productos[i].nombre := 'Producto ' + IntToStr(i + 1);
      productos[i].descripcion := 'Descripción del producto ' + IntToStr(i + 1);
      productos[i].stockD := Random(1400)+100;
      productos[i].stockM := Random(900)+100;
      productos[i].precio := Random(1000) + 30 + Random;
    End;
End;

Var 
  productos: array [1..30] Of producto;
  i: integer;
  maestro: file_productos;
  prod: producto;
Begin
  inicializarProductos(productos);
  Assign(maestro, 'maestro.prod');
  Rewrite(maestro);
  For i := 1 To 30 Do
    Write(maestro, productos[i]);
  Close(maestro);
  Reset(maestro);
  While Not eof(maestro) Do
    Begin
      Read(maestro, prod);
      writeln('Código: ', prod.codigo);
      writeln('Nombre: ', prod.nombre);
      writeln('Descripción: ', prod.descripcion);
      writeln('Stock disponible: ', prod.stockD);
      writeln('Stock mínimo: ', prod.stockM);
      writeln('Precio: ', prod.precio:2:2);
      writeln;
    End;
  Close(maestro);
End.
