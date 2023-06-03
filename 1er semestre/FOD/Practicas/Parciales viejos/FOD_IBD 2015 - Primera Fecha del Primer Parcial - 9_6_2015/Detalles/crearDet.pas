
Program crearDetalles;

Uses 
SysUtils;

Const 
  CANT_ARC = 3;

Type 
  TRegistro = Record
    codProd, cantPed: integer;
    descrip: string;
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
      registros[i].codProd := i+1;
      registros[i].cantPed := Random(100);
      registros[i].descrip := 'Descrip' + IntToStr(i);
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
      SetLength(registros[i], Random(30));
      inicializarRegistros(registros[i]);
    End;
  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, 'pedido' + IntToStr(i) + '.ped');
      Rewrite(archivo);
      For j := 0 To Length(registros[i]) - 1 Do
        Write(archivo, registros[i][j]);
      Close(archivo);
    End;


  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, 'pedido' + IntToStr(i) + '.ped');
      Reset(archivo);
      writeln('Archivo ', i, ':');
      While Not eof(archivo) Do
        Begin
          Read(archivo, registro);
          writeln('   Código: ', registro.codProd);
          writeln('   Cantidad pedida: ', registro.cantPed);
          writeln('   Descripcion: ', registro.descrip);
          writeln;
        End;
      Close(archivo);
    End;

End.
