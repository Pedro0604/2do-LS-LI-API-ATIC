
Program CrearArchivoDistribuciones;

Uses 
Sysutils;

Type 
  distribucion = Record
    nombre, descripcion: string;
    anio, nroK, cantDes: integer;
  End;

  file_distribuciones = file Of distribucion;

Var 
  arc_distribuciones: file_distribuciones;
  distribucion_actual: distribucion;
  i: integer;

Procedure GenerarDistribucionAleatoria(Var d: distribucion);
Begin
  d.nombre := 'Distribucion ' + IntToStr(i);
  d.descripcion := 'Descripcion de la distribucion ' + IntToStr(i);
  d.anio := Random(54) + 1970;
  // Años entre 1970 y 2019
  d.nroK := Random(10000);
  // Números entre 0 y 9999
  d.cantDes := Random(100);
  // Cantidades entre 0 y 99
End;

Procedure ImprimirDistribucionEnLinea(d: distribucion);
Begin
  Write(d.nombre:20, ' | ');
  Write(d.descripcion:30, ' | ');
  Write(d.anio:6, ' | ');
  Write(d.nroK:6, ' | ');
  Write(d.cantDes:6);
  Writeln;
End;

Procedure imprimirArchivoDistribuciones(Var arc_distribuciones: file_distribuciones);

Var 
  d: distribucion;
Begin
  Reset(arc_distribuciones);
  While Not EOF(arc_distribuciones) Do
    Begin
      Read(arc_distribuciones, d);
      ImprimirDistribucionEnLinea(d);
    End;
  Close(arc_distribuciones);
End;

Begin
  Randomize;
  // Inicializar el generador de números aleatorios
  Assign(arc_distribuciones, 'distribucion.dist');
  Rewrite(arc_distribuciones);
  GenerarDistribucionAleatoria(distribucion_actual);
  distribucion_actual.cantDes := 0;
  write(arc_distribuciones, distribucion_actual);
  For i := 1 To 20 Do
    Begin
      GenerarDistribucionAleatoria(distribucion_actual);
      Write(arc_distribuciones, distribucion_actual);
    End;

  Close(arc_distribuciones);

  // Imprimir el archivo en una sola línea con información de cada campo
  Reset(arc_distribuciones);
  Write('Nombre              | Descripcion                   ');
  writeln('     | Anio   | NroK  | CantDes');
  Write('-----------------------------------');
  writeln('-----------------------------------------------');
  Close(arc_distribuciones);
  imprimirArchivoDistribuciones(arc_distribuciones);
End.
