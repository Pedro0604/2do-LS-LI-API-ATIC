
Program crearDetalles;

Uses 
SysUtils;

Const 
  CANT_ARC = 1;

Type 
  TRegistro = Record
    codigo: integer;
    cantidadV: integer;
  End;

Var 
  archivo: file Of TRegistro;
  cod: integer;

Procedure inicializarRegistros(Var registros: Array Of TRegistro);

Var 
  i: integer;
Begin
  For i := 0 To Length(registros) - 1 Do
    Begin
      registros[i].codigo := cod;
      registros[i].cantidadV := Random(30)+1;
      If ((Random(11)>4) And (cod<30)) Then
        cod := cod+1;
    End;
End;


Var 
  registros: array [1..CANT_ARC] Of array Of TRegistro;
  i, j: integer;
  registro: TRegistro;
Begin
  Randomize();
  cod := 1;
  For i := 1 To CANT_ARC Do
    Begin
      SetLength(registros[i], Random(50));
      inicializarRegistros(registros[i]);
    End;
  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, 'detalle.det');
      Rewrite(archivo);
      For j := 0 To Length(registros[i]) - 1 Do
        Write(archivo, registros[i][j]);
      Close(archivo);
    End;


  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, 'detalle.det');
      Reset(archivo);
      writeln('Archivo :');
      While Not eof(archivo) Do
        Begin
          Read(archivo, registro);
          writeln('   Código: ', registro.codigo);
          writeln('   Cantidad vendida: ', registro.cantidadV);
          writeln;
        End;
      Close(archivo);
    End;

End.
