
Program crearDetalles;

Uses 
SysUtils;

Const 
  CANT_ARC = 1;
  CANT_MAX_REG = 50;

Type 
  TRegistro = Record
        nroUsuario: integer;
        cuentaDest, cuerpo : string;
  End;

Var 
  archivo: file Of TRegistro;

Procedure inicializarRegistros(Var registros: Array Of TRegistro);

Var 
  i, r, cant: integer;
Begin
  cant := 0;
  For i := 0 To 19 Do
    Begin
      r := random(10);
      while((r>0)and(cant<Length(registros)))do begin
        r := r - 1;
        registros[cant].nroUsuario := i+1;
        registros[cant].cuentaDest := 'Cuenta destino' + IntToStr(cant);
        registros[cant].cuerpo := 'Cuerpo' + IntToStr(cant);
        cant := cant + 1;
      end;
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
      SetLength(registros[i], Random(CANT_MAX_REG));
      inicializarRegistros(registros[i]);
    End;
  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, '6junio2017.dat');
      Rewrite(archivo);
      For j := 0 To Length(registros[i]) - 1 Do
        Write(archivo, registros[i][j]);
      Close(archivo);
    End;


  For i := 1 To CANT_ARC Do
    Begin
      Assign(archivo, '6junio2017.dat');
      Reset(archivo);
      writeln('Archivo ', i, ':');
      While Not eof(archivo) Do
        Begin
          Read(archivo, registro);
          writeln('   NroUsuario: ', registro.nroUsuario);
          writeln('   Cuenta destino: ', registro.cuentaDest);
          writeln('   Cuerpo: ', registro.cuerpo);
          writeln;
        End;
      Close(archivo);
    End;

End.
