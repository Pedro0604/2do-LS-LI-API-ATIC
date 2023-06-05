
Program Parcial_6_6_2017;

Uses 
Sysutils;

Const 
  VALOR_ALTO = 32000;

Type 
  log = Record
    nroUsuario, cantM : integer;
    nomUsuario, nombre, apellido: string;
  End;

  correo = Record
    nroUsuario: integer;
    cuentaDest, cuerpo : string;
  End;

  file_logs = file Of log;
  file_correos = file Of correo;

Procedure leer(Var arc_correos: file_correos; Var c: correo);
Begin
  If (Not EOF(arc_correos))Then
    read(arc_correos, c)
  Else
    c.nroUsuario := VALOR_ALTO;
End;

Procedure actualizarLogs(Var arc_logs: file_logs; Var arc_correos: file_correos);

Var 
  c: correo;
  l: log;
Begin
  Reset(arc_logs);
  Reset(arc_correos);
  leer(arc_correos, c);
  While (c.nroUsuario<>VALOR_ALTO) Do
    Begin
      read(arc_logs, l);
      While (c.nroUsuario<>l.nroUsuario) Do
        Begin
          read(arc_logs, l);
        End;
      Seek(arc_logs, FilePos(arc_logs)-1);
      l.cantM := l.cantM + 1;
      write(arc_logs, l);
      Seek(arc_logs, FilePos(arc_logs)-1);
      leer(arc_correos, c);
    End;
  Close(arc_logs);
  Close(arc_correos);
End;

Function logToString(l: log): string;
Begin
  logToString := intToStr(l.nroUsuario) + '   ' + l.nomUsuario + '        ' + intToStr(l.
                 cantM);
End;

Procedure imprimirLogs(Var arc_logs: file_logs);

Var 
  l: log;
Begin
  Reset(arc_logs);
  While Not eof(arc_logs) Do
    Begin
      Read(arc_logs, l);
      writeln(logToString(l));
      writeln;
    End;
  Close(arc_logs);
End;

Procedure exportarLogs(Var arc_logs: file_logs; Var arc_correos: file_correos);

Var 
  l: log;
  c: correo;
  txt: Text;
  cant: integer;
Begin
  Assign(txt, 'listado.txt');
  Rewrite(txt);
  Reset(arc_logs);
  Reset(arc_correos);
  While Not eof(arc_logs) Do
    Begin
      Read(arc_logs, l);
      cant := 0;
      leer(arc_correos, c);
      While (l.nroUsuario=c.nroUsuario) Do
        Begin
          cant := cant + 1;
          leer(arc_correos, c);
        End;
      seek(arc_correos, FilePos(arc_correos)-1);
      l.cantM := cant;
      writeln(txt, logToString(l));
    End;
  Close(arc_logs);
  Close(arc_correos);
  Close(txt);
End;

Var 
  arc_logs : file_logs;
  arc_correos : file_correos;
Begin
  Assign(arc_logs, './var/log/logsmail.dat');
  Assign(arc_correos, './Detalles/6junio2017.dat');
  imprimirLogs(arc_logs);
  actualizarLogs(arc_logs, arc_correos);
  imprimirLogs(arc_logs);
  exportarLogs(arc_logs, arc_correos);
End.
