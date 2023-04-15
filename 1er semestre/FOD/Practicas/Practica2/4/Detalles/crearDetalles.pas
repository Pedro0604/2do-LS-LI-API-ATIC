
Program crearDetalles;

Uses 
SysUtils;

Type 
  TRegistro = Record
    cod_usuario: Integer;
    fecha: Integer;
    tiempo_sesion: real;
  End;

Var 
  archivo: file Of TRegistro;
  registro: TRegistro;
  nombreArchivo: string;
  i, j, r, prevR: Integer;

Begin
  Randomize();
  For j:=1 To 5 Do
    Begin
      prevR := 0;
      nombreArchivo := 'detalle'+IntToStr(j)+'.det';
      Assign(archivo, nombreArchivo);
      Rewrite(archivo);
      For i := 0 To 6 Do
        Begin
          r := Random(10);
          While (r<prevR) Do
            Begin
              r := Random(10);
              If (prevR > 8)Then
                r := Random(7)+8;
            End;
          prevR := r;
          registro.cod_usuario := r;
          registro.fecha := i Mod 7 + 1;
          registro.tiempo_sesion := Random*10;
          Write(archivo, registro);
        End;
      Close(archivo);
    End;

  For i:=1 To 5 Do
    Begin
      nombreArchivo := 'detalle'+IntToStr(i)+'.det';
      Assign(archivo, nombreArchivo);
      Reset(archivo);
      writeln('Archivo: ', IntToStr(i));
      read(archivo, registro);
      writeln('cod_usuario = ', registro.cod_usuario, ', fecha = ', registro.fecha
              ,
              ', tiempo_sesion = ', registro.tiempo_sesion:2:2);
      While Not EOF(archivo) Do
        Begin
          read(archivo, registro);
          writeln('cod_usuario = ', registro.cod_usuario, ', fecha = ', registro.
                  fecha,
                  ', tiempo_sesion = ', registro.tiempo_sesion:2:2);
        End;
      writeln();
      Close(archivo);
    End;
End.
