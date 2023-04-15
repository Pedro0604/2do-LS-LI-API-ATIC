
Program crearDetalles;

Uses 
SysUtils;

Const 
  CANT_ARC = 30;

Type 
  TRegistro = Record
    codigo: integer;
    cantV: integer;
  End;

Var 
  archivo: file Of TRegistro;

Procedure inicializarRegistros(Var registros: Array Of TRegistro);

Var 
  i, r: integer;
Begin
  r := Random(CANT_ARC);
  For i := 0 To Length(registros) - 1 Do
    Begin
      registros[i].codigo := CANT_ARC -(r Div (i+1));
      registros[i].cantV := Random(30);
    End;
End;


Var 
  registros: array [1..CANT_ARC] Of array Of TRegistro;
  i, j: integer;
  registro: TRegistro;
Begin
  Randomize();
  For i := 1 To CANT_ARC Do
    Begin
      SetLength(registros[i], Random(5));
      inicializarRegistros(registros[i]);
    End;
  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, 'detalle' + IntToStr(i) + '.det');
      Rewrite(archivo);
      For j := 0 To Length(registros[i]) - 1 Do
        Write(archivo, registros[i][j]);
      Close(archivo);
    End;


  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, 'detalle' + IntToStr(i) + '.det');
      Reset(archivo);
      writeln('Archivo ', i, ':');
      While Not eof(archivo) Do
        Begin
          Read(archivo, registro);
          writeln('   Código: ', registro.codigo);
          writeln('   Cantidad vendida: ', registro.cantV);
          writeln;
        End;
      Close(archivo);
    End;

End.
