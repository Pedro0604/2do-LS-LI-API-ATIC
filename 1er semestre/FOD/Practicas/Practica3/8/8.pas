
Program ocho;

Uses 
sysutils;

Type 
  distribucion = Record
    nombre, descripcion: string;
    anio, nroK, cantDes: integer;
  End;

  file_distribuciones = file Of distribucion;

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

Function existeDistribucion(Var arc_distribuciones: file_distribuciones;
                            nombre: String): boolean;

Var 
  aux: distribucion;
  encontrado: boolean;
Begin
  encontrado := false;
  Reset(arc_distribuciones);
  While (Not EOF(arc_distribuciones)) And (Not encontrado) Do
    Begin
      read(arc_distribuciones, aux);
      If ((aux.cantDes>0) And (nombre = aux.nombre))Then
        encontrado := true;
    End;
  Close(arc_distribuciones);
  existeDistribucion := encontrado;
End;

Procedure altaDistribucion(Var arc_distribuciones: file_distribuciones);

Var 
  d, aux: distribucion;
  pos: integer;
Begin
  write('Ingrese un nombre: ');
  readln(d.nombre);
  If (existeDistribucion(arc_distribuciones, d.nombre))Then
    writeln('Ya existe la distribucion')
  Else
    Begin
      write('Ingrese una descripcion: ');
      readln(d.descripcion);
      write('Ingrese un anio de lanzamiento: ');
      readln(d.anio);
      write('Ingrese un numero de kernel: ');
      readln(d.nroK);
      write('Ingrese una cantidad de desarrolladores: ');
      readln(d.cantDes);
      Reset(arc_distribuciones);
      read(arc_distribuciones, aux);
      If (aux.cantDes = 0)Then
        Begin
          Seek(arc_distribuciones, FileSize(arc_distribuciones));
        End
      Else
        Begin
          pos := aux.cantDes*-1;
          Seek(arc_distribuciones, pos);
          read(arc_distribuciones, aux);
          Seek(arc_distribuciones, 0);
          write(arc_distribuciones, aux);
          Seek(arc_distribuciones, pos);
        End;
      write(arc_distribuciones, d);
      Close(arc_distribuciones);
    End;
End;

Procedure bajaDistribucion(Var arc_distribuciones: file_distribuciones);

Var 
  aux: distribucion;
  nombre: string;
  pos, punteroLista: integer;
Begin
  write('Ingrese un nombre: ');
  readln(nombre);
  If (existeDistribucion(arc_distribuciones, nombre))Then
    Begin
      Reset(arc_distribuciones);
      read(arc_distribuciones, aux);
      While (nombre <> aux.nombre) Do
        Begin
          read(arc_distribuciones, aux);
        End;
      pos := FilePos(arc_distribuciones)-1;
      Seek(arc_distribuciones, 0);
      read(arc_distribuciones, aux);
      punteroLista := aux.cantDes;
      Seek(arc_distribuciones, 0);
      aux.cantDes := pos*-1;
      write(arc_distribuciones, aux);
      Seek(arc_distribuciones, pos);
      aux.cantDes := punteroLista;
      write(arc_distribuciones, aux);
      Close(arc_distribuciones);
    End
  Else
    writeln('Distribucion no existente');
End;

Var 
  arc_distribuciones: file_distribuciones;
  nombre: string;
Begin
  Assign(arc_distribuciones, 'distribucion.dist');
  //   imprimirArchivoDistribuciones(arc_distribuciones);
  //   write('Ingrese un nombre para ver si existe: ');
  //   readln(nombre);
  //   If (existeDistribucion(arc_distribuciones, nombre))Then
  //     writeln('Existe')
  //   Else
  //     writeln('No existe');
  //   writeln;
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Pre alta');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  imprimirArchivoDistribuciones(arc_distribuciones);
  altaDistribucion(arc_distribuciones);
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Post alta');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  imprimirArchivoDistribuciones(arc_distribuciones);
  bajaDistribucion(arc_distribuciones);
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Post baja');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  imprimirArchivoDistribuciones(arc_distribuciones);
End.
