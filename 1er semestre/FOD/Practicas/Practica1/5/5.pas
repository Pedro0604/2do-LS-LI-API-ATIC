
Program cinco;

Uses SysUtils;

Type 
  celular  = Record
    codigo, stockM, stockD : integer;
    nombre, descripcion, marca : string;
    precio: real;
  End;
  file_celulares = file Of celular;

Procedure cargarDatos(Var arc_celulares: file_celulares);

Var 
  c: celular;
  t: Text;
Begin
  Assign(t, 'celulares.txt');
  Reset(t);
  While Not EOF(t) Do
    Begin
      With c Do
        Begin
          readln(t, codigo, precio, marca);
          readln(t, stockD, stockM, descripcion);
          readln(t, nombre);
          write(arc_celulares, c);
        End;
    End;
  writeln('-----------------Archivo cargado-----------------');
  Close(t);
End;

Procedure crearArchivoCelulares(Var arc_celulares: file_celulares);

Var 
  nombre_archivo: String[20];
Begin
  writeln('Nombre del archivo .cel a crear: ');
  readln(nombre_archivo);
  Assign(arc_celulares, nombre_archivo+'.cel');
  Rewrite(arc_celulares);
  cargarDatos(arc_celulares);
  Close(arc_celulares);
End;

Function celularToString(c: celular): string;
Begin

  With c Do
    Begin
      celularToString := Format(' %-4d | %-24s | %-8s | %-7.2f | %-2d | %-2d | %-240s',
                         [codigo, nombre, marca, precio, stockD, stockM, descripcion]);
    End;
End;

Procedure listarStock(Var arc_celulares: file_celulares);

Var 
  c: celular;
Begin
  Reset(arc_celulares);
  While Not EOF(arc_celulares) Do
    Begin
      read(arc_celulares, c);
      If (c.stockD<c.stockM)Then
        Begin
          writeln(celularToString(c));
        End;
    End;
  Close(arc_celulares);
End;

Procedure listarCelularesPorString(Var arc_celulares: file_celulares; descr: String);

Var 
  c: celular;
Begin
  Reset(arc_celulares);
  While Not EOF(arc_celulares) Do
    Begin
      read(arc_celulares, c);
      If (Pos(descr, c.descripcion)<>0)Then
        Begin
          writeln(celularToString(c));
        End;
    End;
  Close(arc_celulares);
End;

Procedure exportarContenido(Var arc_celulares: file_celulares);

Var 
  c: celular;
  t: Text;
Begin
  Assign(t, 'celulares.txt');
  Reset(arc_celulares);
  Rewrite(t);
  While Not EOF(arc_celulares) Do
    Begin
      read(arc_celulares, c);
      With c Do
        Begin
          writeln(t,codigo,' ',precio,' ',marca);
          writeln(t,stockD,' ',stockM,' ',descripcion);
          writeln(t, nombre);
        End;
    End;
  writeln('----------------Archivo exportado----------------');
  Close(arc_celulares);
  Close(t)
End;


Var 
  finish, asignado: boolean;
  opcion: integer;
  arc_celulares: file_celulares;
  st: String;
Begin
  finish := false;
  asignado := false;
  While (Not finish) Do
    Begin
      writeln('=================================================');
      writeln('=================================================');
      writeln('----------------------Menu-----------------------');
      writeln('---------Crear archivo de celulares (1)----------');
      writeln('--------Listar stock menor al minimo (2)---------');
      writeln('------Listar celulares por descripcion (3)-------');
      writeln('-------------Exportar celulares (4)--------------');
      writeln('-----------Finalizar la ejecucion (-1)-----------');
      writeln('=================================================');
      writeln('=================================================');
      readln(opcion);
      writeln('');
      writeln('');
      If (opcion=1)Then
        Begin
          crearArchivoCelulares(arc_celulares);
          asignado := true;
        End
      Else
        If (Not asignado)Then
          Begin
            crearArchivoCelulares(arc_celulares);
            asignado := true;
            writeln('');
          End;
      If (opcion = 2)Then
        Begin
          writeln('--------------Stock menor al minimo--------------');
          listarStock(arc_celulares);
        End
      Else
        If (opcion = 3)Then
          Begin
            writeln('Descripcion a buscar: ');
            readln(st);
            writeln('----------Celulares con la descripcion '+st+'---------');
            listarCelularesPorString(arc_celulares, st);
          End

      Else
        If (opcion = 4)Then
          Begin
            exportarContenido(arc_celulares);
            writeln('-------Contenido exportado a celulares.txt-------');
          End

      Else
        If (opcion = -1)Then
          Begin
            finish := true;
            writeln('=================================================');
            writeln('=================================================');
            writeln('----------------------Adios----------------------');
            writeln('=================================================');
            writeln('=================================================');
          End;
      writeln('');
      writeln('');
    End;
End.
