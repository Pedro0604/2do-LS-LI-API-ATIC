
Program CrearArchivo;

Uses 
Sysutils;

Type 
  reg_flor = Record
    nombre: String[45];
    codigo: integer;
  End;

  tArchFlores = File Of reg_flor;

Procedure ImprimirRegistro(registro: reg_flor);
Begin
  writeln('Nombre: ', registro.nombre, ' - Codigo: ', registro.codigo);
End;

Procedure imprimirArchivo(Var arc_flores: tArchFlores);

Var 
  flor: reg_flor;
Begin
  Reset(arc_flores);
  // leer cada registro del archivo y llamar al procedimiento ImprimirRegistro
  While Not eof(arc_flores) Do
    Begin
      read(arc_flores, flor);
      ImprimirRegistro(flor);
      writeln('---------------------');
    End;
  // cerrar el archivo
  Close(arc_flores);

End;

Var 
  arc_flores: tArchFlores;
  // declarar un archivo de registros
  flor: reg_flor;
  // variable auxiliar para almacenar cada registro
  i: integer;
  // variable auxiliar para recorrer los registros

Begin
  Randomize();
  // abrir el archivo para escritura
  Assign(arc_flores, 'flores.fl');
  Rewrite(arc_flores);
  flor.nombre := 'Cabecera';
  flor.codigo := -10;
  write(arc_flores, flor);
  // asignar un valor a cada registro del archivo
  For i := 1 To 3 Do
    Begin
      flor.nombre := 'Flor ' + IntToStr(i);
      flor.codigo := Random(100)+1;
      write(arc_flores, flor);
    End;
  flor.nombre := 'Flor 4';
  flor.codigo := -35;
  write(arc_flores, flor);
  For i := 5 To 9 Do
    Begin
      flor.nombre := 'Flor ' + IntToStr(i);
      flor.codigo := Random(100)+1;
      write(arc_flores, flor);
    End;
  flor.nombre := 'Flor 10';
  flor.codigo := -18;
  write(arc_flores, flor);
  For i := 11 To 17 Do
    Begin
      flor.nombre := 'Flor ' + IntToStr(i);
      flor.codigo := Random(100)+1;
      write(arc_flores, flor);
    End;
  flor.nombre := 'Flor 18';
  flor.codigo := -4;
  write(arc_flores, flor);

  For i := 19 To 34 Do
    Begin
      flor.nombre := 'Flor ' + IntToStr(i);
      flor.codigo := Random(100)+1;
      write(arc_flores, flor);
    End;
  flor.nombre := 'Flor 35';
  flor.codigo := 0;
  write(arc_flores, flor);
  For i := 36 To 50 Do
    Begin
      flor.nombre := 'Flor ' + IntToStr(i);
      flor.codigo := Random(100)+1;
      write(arc_flores, flor);
    End;

  // cerrar el archivo
  Close(arc_flores);
  imprimirArchivo(arc_flores);
End.
