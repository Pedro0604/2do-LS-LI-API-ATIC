
Program crearMaestro;

Uses 
SysUtils;

Type 
  producto = Record
    codProd, stockAct, stockMin: integer;
    nombre, descrip, codBarr, categ: string;
  End;

  file_productos = file Of producto;



Procedure inicializarProductos(Var productos: Array Of producto);

Var 
  i: integer;
Begin
  randomize;
  For i := 0 To Length(productos) - 1 Do
    Begin
      productos[i].codProd := i + 1;
      productos[i].nombre := 'Producto ' + IntToStr(i + 1);
      productos[i].descrip := 'Descripcion del producto ' + IntToStr(i + 1);
      productos[i].stockAct := Random(100)+100;
      productos[i].stockMin := Random(70)+50;
      productos[i].codBarr := 'Codigo de barras del producto ' + IntToStr(i + 1);
      productos[i].categ := 'Categoria del producto ' + IntToStr(i + 1);
    End;
End;

Var 
  productos: array [1..30] Of producto;
  i: integer;
  maestro: file_productos;
  prod: producto;
Begin
  Randomize();
  inicializarProductos(productos);
  Assign(maestro, 'productos.prod');
  Rewrite(maestro);
  For i := 1 To 30 Do
    Write(maestro, productos[i]);
  Close(maestro);
  Reset(maestro);
  While Not eof(maestro) Do
    Begin
      Read(maestro, prod);
      writeln('Código: ', prod.codProd);
      writeln('Nombre: ', prod.nombre);
      writeln('Descripción: ', prod.descrip);
      writeln('Stock disponible: ', prod.stockAct);
      writeln('Stock mínimo: ', prod.stockMin);
      writeln('codBarr: ', prod.codBarr);
      writeln('categ: ', prod.categ);
      writeln;
    End;
  Close(maestro);
End.
