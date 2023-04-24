
Program siete;

Uses Sysutils;

Type 
  novela = Record
    codigo: integer;
    precio: real;
    genero, nombre: string;
  End;

  file_novela = file Of novela;

Procedure crearBinario(Var arc_novelas: file_novela);

Var 
  novelas: Text;
  n: novela;
Begin
  Assign(novelas, 'novelas.txt');
  Reset(novelas);
  Rewrite(arc_novelas);
  While Not EOF(novelas) Do
    Begin
      With n Do
        Begin
          readln(novelas, codigo, precio, genero);
          readln(novelas, nombre);
        End;
      write(arc_novelas, n);
    End;
  Close(novelas);
  Close(arc_novelas);
End;

Procedure buscarNovela(Var arc_novelas: file_novela; c:integer; Var pos:integer);

Var 
  n: novela;
  found: boolean;
  posOg: integer;
Begin
  pos := -1;
  found := false;
  posOg := FilePos(arc_novelas);
  Seek(arc_novelas, 0);
  While Not EOF(arc_novelas) And (Not found) Do
    Begin
      read(arc_novelas, n);
      If (n.codigo=c)Then
        Begin
          found := true;
          pos := FilePos(arc_novelas)-1;
        End;
    End;
  Seek(arc_novelas, posOg);
End;

Procedure agregarNovela(Var arc_novelas: file_novela);

Var 
  n: novela;
  pos: integer;
Begin
  Reset(arc_novelas);
  writeln('Codigo: ');
  readln(n.codigo);
  buscarNovela(arc_novelas, n.codigo, pos);
  While (pos=-1) Do
    Begin
      writeln('El codigo ingresado ya existe');
      writeln('Codigo: ');
      readln(n.codigo);
      buscarNovela(arc_novelas, n.codigo, pos);
    End;
  writeln('Precio: ');
  readln(n.precio);
  writeln('Genero: ');
  readln(n.genero);
  writeln('Nombre: ');
  readln(n.nombre);
  Seek(arc_novelas, FileSize(arc_novelas));
  write(arc_novelas, n);
  Close(arc_novelas);
End;

Procedure modificarNovela(Var arc_novelas: file_novela);

Var 
  pos: integer;
  n: novela;
Begin
  writeln('Codigo a modificar: ');
  readln(n.codigo);
  Reset(arc_novelas);
  buscarNovela(arc_novelas, n.codigo, pos);
  While (pos<>-1) Do
    Begin
      writeln('El codigo ingresado no existe');
      writeln('Codigo a modificar: ');
      readln(n.codigo);
      buscarNovela(arc_novelas, n.codigo, pos);
    End;
  writeln('Datos modificados: ');
  writeln('Precio: ');
  readln(n.precio);
  writeln('Genero: ');
  readln(n.genero);
  writeln('Nombre: ');
  readln(n.nombre);
  Seek(arc_novelas, pos);
  write(arc_novelas, n);
  Close(arc_novelas);
End;

Function novelaToString(n: novela): string;
Begin
  With n Do
    Begin
      novelaToString := Format('%-6d | %-6:2f | %-15s | %-40s', [codigo, precio, genero,
                        nombre]);
    End;
End;

Procedure mostrarNovelas(Var arc_novelas: file_novela);

Var 
  n: novela;
Begin
  Reset(arc_novelas);
  writeln('Novelas: ');
  writeln(Format('%-6s | %-6s | %-15s | %-40s',['Codigo', 'Precio', 'Genero', 'Nombre']));
  While Not EOF(arc_novelas) Do
    Begin
      read(arc_novelas, n);
      writeln(novelaToString(n));
    End;
  Close(arc_novelas);
End;

Var 
  arc_novelas: file_novela;
Begin
  crearBinario(arc_novelas);
  mostrarNovelas(arc_novelas);
  agregarNovela(arc_novelas);
  mostrarNovelas(arc_novelas);
  modificarNovela(arc_novelas);
  mostrarNovelas(arc_novelas);
End.
