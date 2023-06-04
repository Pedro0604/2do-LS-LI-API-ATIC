
Program Parcial_6_6_2017;
uses
    Sysutils;
const
    VALOR_ALTO = 32000;

type
    log = record
        nroUsuario, cantM : integer;
        nomUsuario, nombre, apellido: string;
    end;

    correo = record
        nroUsuario: integer;
        cuentaDest, cuerpo : string;
    end;

    file_logs = file of log;
    file_correos = file of correo;

procedure leer(var arc_correos: file_correos; var c: correo);
begin
    if(not EOF(arc_correos))then
        read(arc_correos, c)
    else
        c.nroUsuario:=VALOR_ALTO;
end;

procedure actualizarLogs(var arc_logs: file_logs; var arc_correos: file_correos);
var
    c: correo;
    l: log;
begin
    Reset(arc_logs);
    Reset(arc_correos);
    leer(arc_correos, c);
    while(c.nroUsuario<>VALOR_ALTO)do begin
        read(arc_logs, l);
        while(c.nroUsuario<>l.nroUsuario)do begin
            read(arc_logs, l);
        end;
        Seek(arc_logs, FilePos(arc_logs)-1);
        l.cantM := l.cantM + 1;
        write(arc_logs, l);
        Seek(arc_logs, FilePos(arc_logs)-1);
        leer(arc_correos, c);
    end;
    Close(arc_logs);
    Close(arc_correos);
end;

function logToString(l: log): string;
begin
    logToString:=intToStr(l.nroUsuario) + '   ' + l.nomUsuario + '        ' + intToStr(l.cantM);
end;

procedure imprimirLogs(var arc_logs: file_logs);
var
    l: log;
begin
  Reset(arc_logs);
  While Not eof(arc_logs) Do
    Begin
      Read(arc_logs, l);
      writeln(logToString(l));
      writeln;
    End;
  Close(arc_logs);
end;

procedure exportarLogs(var arc_logs: file_logs; var arc_correos: file_correos);
var
    l: log;
    c: correo;
    txt: Text;
    cant: integer;
begin
    Assign(txt, 'listado.txt');
    Rewrite(txt);
  Reset(arc_logs);
  Reset(arc_correos);
  While Not eof(arc_logs) Do
    Begin
      Read(arc_logs, l);
      cant := 0;
      leer(arc_correos, c);
      while(l.nroUsuario=c.nroUsuario)do begin
        cant := cant + 1;
        leer(arc_correos, c);
      end;
      seek(arc_correos, FilePos(arc_correos)-1);
      l.cantM := cant;
      writeln(txt, logToString(l));
    End;
  Close(arc_logs);
  Close(arc_correos);
  Close(txt);
end;

var
    arc_logs : file_logs;
    arc_correos : file_correos;
begin
    Assign(arc_logs, './var/log/logsmail.dat');
    Assign(arc_correos, './Detalles/6junio2017.dat');
    imprimirLogs(arc_logs);
    actualizarLogs(arc_logs, arc_correos);
    imprimirLogs(arc_logs);
    exportarLogs(arc_logs, arc_correos);
end.