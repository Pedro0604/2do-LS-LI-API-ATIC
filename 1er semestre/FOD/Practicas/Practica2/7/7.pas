
Program siete;

Uses 
sysutils;

Const 
  VALOR_ALTO = 32000;

Type 
  regMaestro = Record
    codigo: Integer;
    nombre: string;
    precio: real;
    stockActual: Integer;
    stockMinimo: Integer;
  End;

  regDetalle = Record
    codigo: Integer;
    cantidadV: Integer;
  End;

  file_detalle = file Of regDetalle;
  file_maestro = file Of regMaestro;

Procedure imprimirRegistroMaestro(regM: regMaestro);
Begin
  write('Código: ', regM.codigo, ' | ');
  write('Nombre: ', regM.nombre, ' | ');
  write('Precio de venta: ', regM.precio:0:2, ' | ');
  write('Stock actual: ', regM.stockActual, ' | ');
  writeln('Stock mínimo: ', regM.stockMinimo, ' | ');
  writeln();
End;

Procedure imprimirMaestro(Var maestro: file_maestro);

Var 
  regM: regMaestro;
Begin
  reset(maestro);
  While Not eof(maestro) Do
    Begin
      read(maestro, regM);
      imprimirRegistroMaestro(regM);
    End;
  close(maestro);
End;

Procedure leer(Var detalle: file_detalle; Var regD: regDetalle);
Begin
  If Not EOF(detalle)Then
    read(detalle, regD)
  Else
    regD.codigo := VALOR_ALTO;
End;


Procedure actualizarMaestro(Var maestro: file_maestro; Var detalle: file_detalle);

Var 
  regD: regDetalle;
  regM: regMaestro;
Begin
  Reset(maestro);
  Reset(detalle);
  leer(detalle, regD);
  While (regD.codigo<>VALOR_ALTO) Do
    Begin
      read(maestro, regM);
      While (regM.codigo<>regD.codigo) Do
        Begin
          read(maestro, regM);
        End;
      While ((regD.codigo<>VALOR_ALTO) And (regM.codigo=regD.codigo)) Do
        Begin
          regM.stockActual := regM.stockActual - regD.cantidadV;
          leer(detalle, regD);
        End;
      Seek(maestro, FilePos(maestro)-1);
      write(maestro, regM);
    End;
  Close(maestro);
  Close(detalle);
End;

Procedure exportarStockMinimo(Var maestro: file_maestro);

Var 
  regM: regMaestro;
  txt: Text;
Begin
  Assign(txt, 'stock_minimo.txt');
  Reset(maestro);
  Rewrite(txt);
  While Not EOF(maestro) Do
    Begin
      read(maestro, regM);
      If (regM.stockActual<regM.stockMinimo)Then
        Begin
          write(txt, 'Código: ', regM.codigo, ' | ');
          write(txt, 'Nombre: ', regM.nombre, ' | ');
          write(txt, 'Precio de venta: ', regM.precio:0:2, ' | ');
          write(txt, 'Stock actual: ', regM.stockActual, ' | ');
          writeln(txt, 'Stock mínimo: ', regM.stockMinimo, ' | ');
        End;
    End;
  Close(maestro);
  Close(txt);
End;

Var 
  maestro: file_maestro;
  detalle: file_detalle;
Begin
  Assign(maestro, 'maestro.dat');
  Assign(detalle, 'detalle.det');
  actualizarMaestro(maestro, detalle);
  exportarStockMinimo(maestro);
End.
