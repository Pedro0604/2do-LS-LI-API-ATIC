
Program tres;

Uses 
SysUtils;

Const 
  CANT_DETALLES = 30;
  VALOR_ALTO = 32000;

Type 
  producto = Record
    codigo: integer;
    nombre, descripcion: string;
    stockD, stockM : integer;
    precio : real;
  End;

  file_productos = file Of producto;

  regDetalle = Record
    codigo : integer;
    cantV: integer;
  End;

  detalle = file Of regDetalle;

  arrDetalle = array [1..CANT_DETALLES] Of detalle;
  arrRegDetalle = array [1..CANT_DETALLES] Of regDetalle;

Procedure imprimirProducto(p:producto);
Begin
  writeln(Format(

'Codigo: %-4d - Nombre: %-12s - Stock disponible: %-3d - Stock minimo: %-3d - Precio: %-6.2f - Descripcion: %-30s'
          ,[p.codigo,p.nombre,p.stockD,p.stockM,p.precio,p.descripcion]));
End;

Procedure imprimirMaestro(Var maestro: file_productos);

Var 
  p: producto;
Begin
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      read(maestro, p);
      imprimirProducto(p);
    End;
  writeln();
  Close(maestro);
End;

Procedure assignDetalles(Var detalles: arrDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Begin
      Assign(detalles[i],'./Detalles/detalle' + IntToStr(i) + '.det');
    End;
End;

Procedure resetDetalles(Var detalles: arrDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Reset(detalles[i]);
End;

Procedure closeDetalles(Var detalles: arrDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Close(detalles[i]);
End;

Procedure leer(Var detalle: detalle; Var regD: regDetalle);
Begin
  If Not EOF(detalle)Then
    read(detalle, regD)
  Else
    regD.codigo := VALOR_ALTO;
End;

Procedure leerDetalles(Var detalles: arrDetalle; Var arrRegD: arrRegDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Begin
      leer(detalles[i], arrRegD[i]);
    End;
End;

Procedure minimo(Var detalles: arrDetalle; Var arrRegD:arrRegDetalle; Var min: regDetalle)
;

Var 
  i, pos: integer;
Begin
  min.codigo := VALOR_ALTO;
  For i:=1 To CANT_DETALLES Do
    Begin
      If (arrRegD[i].codigo<min.codigo)Then
        Begin
          pos := i;
          min.codigo := arrRegD[i].codigo;
          min.cantV := arrRegD[i].cantV;
        End;
    End;
  If (min.codigo<>VALOR_ALTO)Then
    leer(detalles[pos], arrRegD[pos]);
End;

Procedure actualizarMaestro(Var maestro: file_productos; Var detalles: arrDetalle);

Var 
  p: producto;
  arrRegD: arrRegDetalle;
  min: regDetalle;
Begin
  Reset(maestro);
  resetDetalles(detalles);
  leerDetalles(detalles, arrRegD);
  minimo(detalles, arrRegD, min);
  While (min.codigo<>VALOR_ALTO) Do
    Begin
      read(maestro, p);
      While (p.codigo<>min.codigo) Do
        Begin
          read(maestro, p);
        End;
      While (p.codigo=min.codigo) Do
        Begin
          p.stockD := p.stockD - min.cantV;
          minimo(detalles, arrRegD, min);
        End;
      Seek(maestro, FilePos(maestro)-1);
      write(maestro, p);
    End;
  Close(maestro);
  closeDetalles(detalles);
End;

Procedure exportarTxt(Var maestro: file_productos);

Var 
  p: producto;
  txt: Text;
Begin
  Assign(txt, 'StockMenorAlMinimo.txt');
  Reset(maestro);
  Rewrite(txt);
  While Not EOF(maestro) Do
    Begin
      read(maestro, p);
      If (p.stockD < p.stockM)Then
        Begin
          writeln(txt, 'Nombre: ', p.nombre, ' - Stock disponible: ', p.stockD,
                  ' - Precio: ', p.precio:0:2, ' - Descripcion: ', p.descripcion);
        End;
    End;
  Close(maestro);
  Close(txt);
End;

Var 
  maestro: file_productos;
  detalles : arrDetalle;
Begin
  Assign(maestro, 'maestro.prod');
  assignDetalles(detalles);
  actualizarMaestro(maestro, detalles);
  exportarTxt(maestro);
End.
