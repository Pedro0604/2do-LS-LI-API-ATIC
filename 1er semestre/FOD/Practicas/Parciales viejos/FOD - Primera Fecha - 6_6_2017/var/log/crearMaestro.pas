
Program crearMaestro;

Uses
  SysUtils;

Const
  CANT_REG = 20;

Type 
  log = Record
        nroUsuario, cantM : integer;
        nomUsuario, nombre, apellido: string;
  End;

  file_logs = file Of log;



Procedure inicializarlogs(Var logs: Array Of log);

Var 
  i: integer;
Begin
  randomize;
  For i := 0 To Length(logs) - 1 Do
    Begin
      logs[i].nroUsuario := i + 1;
      logs[i].nomUsuario := 'NombreUsuario' + IntToStr(i + 1);
      logs[i].nombre := 'Nombre' + IntToStr(i + 1);
      logs[i].cantM := Random(15)+Random(4);
      logs[i].apellido := 'Apellido' + IntToStr(i + 1);
    End;
End;

Var 
  logs: array [1..CANT_REG] Of log;
  i: integer;
  maestro: file_logs;
  l: log;
Begin
  Randomize();
  inicializarlogs(logs);
  Assign(maestro, 'logsmail.dat');
  Rewrite(maestro);
  For i := 1 To CANT_REG Do
    Write(maestro, logs[i]);
  Close(maestro);
  Reset(maestro);
  While Not eof(maestro) Do
    Begin
      Read(maestro, l);
      writeln('nroUsuario: ', l.nroUsuario);
      writeln('nomUsuario: ', l.nomUsuario);
      writeln('nombre: ', l.nombre);
      writeln('apellido: ', l.apellido);
      writeln('CantM: ', l.cantM);
      writeln;
    End;
  Close(maestro);
End.
