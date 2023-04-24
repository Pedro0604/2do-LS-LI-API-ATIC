
Program cuatro;

Uses 
Sysutils;

Type 
  reg_flor = Record
    nombre: String[45];
    codigo: integer;
  End;
  tArchFlores = file Of reg_flor;


Procedure agregarFlor (Var a: tArchFlores ; nombre: String; codigo:integer);

Var 
  aux: reg_flor;
  pos: integer;
Begin
  Reset(a);
  read(a, aux);
  If (aux.codigo = 0)Then
    Begin
      Seek(a, FileSize(a));
    End
  Else
    Begin
      pos := aux.codigo*-1;
      Seek(a, pos);
      read(a, aux);
      Seek(a, 0);
      aux.nombre := 'Cabecera';
      write(a, aux);
      Seek(a, pos);
    End;
  aux.codigo := codigo;
  aux.nombre := nombre;
  write(a, aux);
  Close(a);
End;


Procedure ImprimirRegistro(registro: reg_flor);
Begin
  writeln('Nombre: ', registro.nombre, ' - Codigo: ', registro.codigo);
End;

Procedure imprimirArchivo(Var arc_flores: tArchFlores);

Var 
  flor: reg_flor;
Begin
  Reset(arc_flores);
  // leer cada registro del archivo y llamar al procedimiento ImprimirRegistro
  While Not eof(arc_flores) Do
    Begin
      read(arc_flores, flor);
      If (flor.codigo>0)Then
        Begin
          ImprimirRegistro(flor);
          writeln('---------------------');
        End;
    End;
  // cerrar el archivo
  Close(arc_flores);

End;


Var 
  arc_flores: tArchFlores;
  nombre: string[45];
  codigo: integer;
Begin
  Assign(arc_flores, 'flores.fl');
  writeln('Ingrese el nombre de la flor:');
  readln(nombre);
  writeln('Ingrese el codigo de la flor:');
  readln(codigo);
  agregarFlor(arc_flores, nombre, codigo);
  imprimirArchivo(arc_flores);
End.
