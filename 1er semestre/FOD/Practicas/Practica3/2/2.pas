program dos;
uses
Sysutils;
type
  asistente = record
    nroA: integer;
    nombre, apellido, mail, telefono, dni: string;
  end;

  file_congreso = file of asistente;
  
Procedure leerAsistente(var a: asistente);
begin
  with a do begin
    write('NroA: ');
    readln(nroA);
    if(nroA<>0)then begin
      write('Nombre: ');
      readln(nombre);
      {write('Apellido: ');
      readln(apellido);
      write('Mail: ');
      readln(mail);
      write('Telefono: ');
      readln(telefono);
      write('DNI: ');
      readln(dni);}
    end;
  end;
end;
  
Procedure crearCongreso(var congreso: file_congreso);
var
  a: asistente;
begin
  Rewrite(congreso);
  leerAsistente(a);
  while (a.nroA<>0)do begin
    write(congreso, a);
    leerAsistente(a);
  end;
  Close(congreso);
end;

Procedure imprimirAsistente(var a: asistente);
begin
  with a do begin
    writeln('Nro asistente: ' + intToStr(nroA) + ' - Nombre: ' + nombre {+ ' - Apellido: ' + apellido + ' - Mail: ' + mail + ' - Telefono: ' + telefono + ' - DNI: ' + dni});
  end;
end;

Procedure imprimirCongreso(var congreso: file_congreso);
var
  a: asistente;
begin
  Reset(congreso);
  while not EOF(congreso)do begin
    read(congreso, a);
    if(a.nombre[1]<>'*')then
      imprimirAsistente(a)
    else begin
      a.nombre := copy(a.nombre, 2, 30);
      Seek(congreso, FilePos(congreso)-1);
      write(congreso, a);
    end;
  end;
  Close(congreso);
end;

Procedure eliminarMenoresAMil(var congreso: file_congreso);
var
  a: asistente;
begin
  Reset(congreso);
  while not EOF(congreso)do begin
    read(congreso, a);
    if(a.nroA<1000)then
      a.nombre := '*' + a.nombre;
      Seek(congreso, FilePos(congreso)-1);
      write(congreso, a);
  end;
  Close(congreso);
end;

var
  congreso: file_congreso;
  opc: char;
BEGIN
  Assign(congreso, 'congreso.con');
	writeln('Crear congreso? (s/n) [s]');
  readln(opc);
  if ((opc = 's') or (opc = 'S'))then
    crearCongreso(congreso);
  writeln('Archivo antes de bajas: ');
  imprimirCongreso(congreso);
	eliminarMenoresAMil(congreso);
  writeln('Archivo despues de bajas: ');
  imprimirCongreso(congreso);
END.

