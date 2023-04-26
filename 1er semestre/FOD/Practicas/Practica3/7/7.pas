
Program siete;

Uses 
sysutils;

Type 
  especie = Record
    codigo: integer;
    nombre, familia, descripcion, zona: string;
  End;

  file_especies = file Of especie;

Procedure ImprimirEspecieEnLinea(e: especie);
Begin
  Write(e.codigo:6, ' | ');
  Write(e.nombre:10, ' | ');
  Write(e.familia:10, ' | ');
  Write(e.descripcion:15, ' | ');
  Write(e.zona:5);
  Writeln;
End;

Procedure imprimirArchivoEspecies(Var arc_especies: file_especies);

Var 

  e: especie;
Begin
  Reset(arc_especies);

  Writeln('Codigo | Nombre     | Familia    | Descripcion     | Zona');
  Writeln('-----------------------------------------------------------');

  While Not EOF(arc_especies) Do
    Begin
      Read(arc_especies, e);
      ImprimirEspecieEnLinea(e);
    End;

  Close(arc_especies);
End;


Procedure bajaLogicaEspecies(Var arc_especies: file_especies);

Var 
  cod: integer;
  encontrado: boolean;
  aux: especie;
Begin
  Reset(arc_especies);
  write('Ingrese el codigo de la especie a eliminar: ');
  readln(cod);
  While (cod<>5000) Do
    Begin
      If (cod > 0)Then
        Begin
          encontrado := false;
          Seek(arc_especies, 0);
          While (Not EOF(arc_especies)) And (Not encontrado) Do
            Begin
              read(arc_especies, aux);
              If (cod = aux.codigo)Then
                Begin
                  encontrado := true;
                  aux.codigo := aux.codigo*-1;
                  Seek(arc_especies, FilePos(arc_especies)-1);
                  write(arc_especies, aux);
                End;
            End;
          If (encontrado)Then
            writeln('Especie eliminada correctamente')
          Else
            Begin
              write('###ERROR### No existe ninguna especie ');
              write('de aves con ese nombre ###ERROR###');
            End;
        End
      Else
        writeln('###ERROR### El codigo debe ser mayor a cero ###ERROR###');
      writeln;
      write('Ingrese el codigo de la especie a eliminar: ');
      readln(cod);
    End;
  Close(arc_especies);
End;

Procedure compactacion(Var arc_especies: file_especies);

Var 
  aux: especie;
  pos, cantEliminados: integer;
Begin
  cantEliminados := 0;
  writeln('Compactando archivo...');
  Reset(arc_especies);
  While ((Not EOF(arc_especies)) And (FilePos(arc_especies)<FileSize(arc_especies)-
        cantEliminados)) Do
    Begin
      read(arc_especies, aux);
      If (aux.codigo<0)Then
        Begin
          cantEliminados := cantEliminados+1;
          pos := FilePos(arc_especies)-1;
          Seek(arc_especies, FileSize(arc_especies)-cantEliminados);
          writeln('Cant elim: ', cantEliminados);
          writeln('aux.codigo: ', aux.codigo);
          read(arc_especies, aux);
          writeln('aux.codigo superponedor: ', aux.codigo);
          writeln('Pos: ', pos);
          writeln('FilePos: ', FilePos(arc_especies));
          While (aux.codigo<0) And (FileSize(arc_especies)-cantEliminados+1>=0) And (pos<>
                FilePos(arc_especies)-1) Do
            Begin
              cantEliminados := cantEliminados+1;
              Seek(arc_especies, FileSize(arc_especies)-cantEliminados);
              read(arc_especies, aux);
              writeln('Cant elim: ', cantEliminados);
              writeln('aux.codigo superponedor: ', aux.codigo);
              writeln('FilePos: ', FilePos(arc_especies));
            End;
          Seek(arc_especies, pos);
          write(arc_especies, aux);
        End;
    End;
  Seek(arc_especies, FileSize(arc_especies)-cantEliminados);
  Truncate(arc_especies);
  Close(arc_especies);
  writeln('Archivo compactado');
End;

Var 
  arc_especies: file_especies;
Begin
  Assign(arc_especies, 'especies.ave');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Pre bajas');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  imprimirArchivoEspecies(arc_especies);
  bajaLogicaEspecies(arc_especies);
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Post bajas');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  imprimirArchivoEspecies(arc_especies);
  compactacion(arc_especies);
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Post compactacion');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  imprimirArchivoEspecies(arc_especies);
End.
