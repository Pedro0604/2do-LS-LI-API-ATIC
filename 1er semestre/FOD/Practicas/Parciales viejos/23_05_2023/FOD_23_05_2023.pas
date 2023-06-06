
Program Parcial_23_05_2023;

Uses 
sysutils;

Type 

  profesional = Record
    dni: integer;
    nombre, apellido: string;
    sueldo: integer;
  End;

  tArchivo = file Of profesional;

Procedure imprimirArchivo(Var arch: tArchivo);

Var 
  p: profesional;
Begin
  Reset(arch);
  While (Not EOF(arch)) Do
    Begin
      read(arch, p);
      writeln('DNI: ',p.dni,' - Nombre y apellido: ',p.nombre,' ',p.apellido,' - Sueldo: '
              ,p.
              sueldo);
    End;
  writeln();
  Close(arch);
End;


Procedure crear(Var arch: tArchivo; Var info: Text);

Var 
  p: profesional;
Begin
  p.dni := 0;
  p.nombre := '***';
  p.apellido := '***';
  p.sueldo := 0;
  Rewrite(arch);
  Reset(info);
  write(arch, p);
  While (Not EOF(info)) Do
    Begin
      readln(info, p.dni, p.sueldo, p.nombre);
      readln(info, p.apellido);
      write(arch, p);
    End;
  Close(arch);
  Close(info);
End;

Procedure agregar(Var arch: tArchivo; p: profesional);

Var 
  aux: profesional;
  pos: integer;
Begin
  Reset(arch);
  read(arch, aux);
  If (aux.dni=0)Then
    Begin
      seek(arch, FileSize(arch));
    End
  Else
    Begin
      pos := aux.dni * -1;
      seek(arch, pos);
      read(arch, aux);
      seek(arch, 0);
      write(arch, aux);
      seek(arch, pos);
    End;
  write(arch, p);
  Close(arch);
End;

Procedure eliminar(Var arch: tArchivo; dni: integer; Var bajas: Text);

Var 
  aux, p, cabecera: profesional;
  posAux: integer;
Begin
  Reset(arch);
  read(arch, cabecera);
  read(arch, aux);
  While ((Not EOF(arch))And(aux.dni<>dni)) Do
    Begin
      read(arch, aux);
    End;
  If (aux.dni = dni)Then
    Begin
      p := aux;
      posAux := FilePos(arch)-1;
      aux.dni := cabecera.dni;
      seek(arch, FilePos(arch)-1);
      write(arch, aux);
      seek(arch, 0);
      cabecera.dni := posAux * -1;
      write(arch, cabecera);
      Append(bajas);
      writeln(bajas, p.dni,' ',p.sueldo,' ',p.nombre);
      writeln(bajas, p.apellido);
      Close(bajas);
    End
  Else
    Begin
      writeln('DNI no encontrado.');
    End;
  Close(arch);
End;


Var 
  arch : tArchivo;
  info, bajas : Text;
  p: profesional;
Begin
  Assign(arch, 'profesionales.prof');
  Assign(info, 'info.txt');
  Assign(bajas, 'bajas.txt');
  Rewrite(bajas);
  Close(bajas);

  crear(arch, info);
  imprimirArchivo(arch);

  p.dni := 6666;
  p.nombre := 'Pedro';
  p.apellido := 'Spadari';
  p.sueldo := 60;
  agregar(arch, p);
  imprimirArchivo(arch);

  eliminar(arch, 6666, bajas);
  imprimirArchivo(arch);

  eliminar(arch, 4444, bajas);
  imprimirArchivo(arch);

  eliminar(arch, 9999, bajas);

  eliminar(arch, 3333, bajas);
  imprimirArchivo(arch);

  p.dni := 7777;
  p.nombre := 'Tomas';
  p.apellido := 'Gando';
  p.sueldo := 70;
  agregar(arch, p);
  imprimirArchivo(arch);

  p.dni := 8888;
  p.nombre := 'Tomas';
  p.apellido := 'Prieto de Francia';
  p.sueldo := 80;
  agregar(arch, p);
  imprimirArchivo(arch);

  p.dni := 9999;
  p.nombre := 'Juan Domingo';
  p.apellido := 'El primer trabajador';
  p.sueldo := 90;
  agregar(arch, p);
  imprimirArchivo(arch);

p.dni := 10000;
p.nombre := 'Joselon';
p.apellido := 'Joselun';
p.sueldo := 100;
agregar(arch, p);
imprimirArchivo(arch);

End.
