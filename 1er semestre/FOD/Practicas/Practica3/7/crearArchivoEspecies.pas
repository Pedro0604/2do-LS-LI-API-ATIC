
Program CrearArchivoEspeciesAleatorias;

Uses 
sysutils;

Type 
  especie = Record
    codigo: integer;
    nombre, familia, descripcion, zona: string;
  End;

  file_especies = file Of especie;

Var 
  arc_especies: file_especies;
  especie_actual: especie;
  i: integer;

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

Begin
  Reset(arc_especies);

  Writeln('Codigo | Nombre     | Familia    | Descripcion     | Zona');
  Writeln('-----------------------------------------------------------');

  While Not EOF(arc_especies) Do
    Begin
      Read(arc_especies, especie_actual);
      ImprimirEspecieEnLinea(especie_actual);
    End;

  Close(arc_especies);
End;


Begin
  Randomize;
  // Inicializar el generador de números aleatorios

  Assign(arc_especies, 'especies.ave');
  Rewrite(arc_especies);

  For i := 1 To 5 Do
    Begin
      especie_actual.codigo := i;
      especie_actual.nombre := 'Especie ' + IntToStr(i);
      especie_actual.familia := 'Familia ' + IntToStr(Random(10) + 1);
      especie_actual.descripcion := 'Descripcion ' + IntToStr(Random(100) + 1);
      especie_actual.zona := 'Zona ' + IntToStr(Random(5) + 1);

      Write(arc_especies, especie_actual);
    End;
  Close(arc_especies);
  imprimirArchivoEspecies(arc_especies);
End.
