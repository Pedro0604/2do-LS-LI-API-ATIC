
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
  Assign (t, 'celulares.txt');
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

Procedure buscarCelular (Var arc_celulares:file_celulares; nombre: String; Var pos:
                         integer);

Var 
  c: celular;
  found: boolean;
  posOg: integer;
Begin
  found := false;
  pos := -1;
  posOg := FilePos(arc_celulares);
  seek(arc_celulares,0);
  While Not EOF(arc_celulares) And (Not found) Do
    Begin
      read(arc_celulares, c);
      If (c.nombre = nombre)Then
        Begin
          pos := FilePos(arc_celulares)-1;
        End;
    End;
  seek(arc_celulares,posOg);
End;

Procedure ingresarCelular(Var c: celular);
Begin
  With c Do
    Begin
      writeln('Codigo (0 para terminar la modificacion): ');
      readln(codigo);
      If (codigo<>0)Then
        Begin
          writeln('Nombre: ');
          readln(nombre);
          writeln('Marca: ');
          readln(marca);
          writeln('Precio: ');
          readln(precio);
          writeln('Stock disponible: ');
          readln(stockD);
          writeln('Stock minimo: ');
          readln(stockM);
          writeln('Descripcion: ');
          readln(descripcion);
        End;
    End;

End;

Procedure ingresarDatos(Var arc_celulares:file_celulares);

Var 
  c: celular;
  pos: integer;
Begin
  pos := 0;
  writeln('');
  writeln('Ingrese un celular: ');
  ingresarCelular(c);
  While (c.codigo<>0) Do
    Begin
      writeln('');
      buscarCelular(arc_celulares, c.nombre, pos);
      If (pos=-1)Then
        Begin
          write(arc_celulares, c);
        End
      Else
        Begin
          writeln('El celular ingresado ya existe.');
        End;
      writeln('Ingrese otro celular: ');
      ingresarCelular(c);
    End;
End;

Procedure aniadirCelulares(Var arc_celulares:file_celulares);
Begin
  Reset(arc_celulares);
  seek(arc_celulares,FileSize(arc_celulares));
  ingresarDatos(arc_celulares);
  Close(arc_celulares);
End;

Procedure modificarStock(Var arc_celulares: file_celulares);

Var 
  n: integer;
  nom: string;
  opcion: char;
  pos: integer;
  c: celular;
Begin
  pos := 0;
  Reset(arc_celulares);
  write('Introduzca el nombre de un celular a modificar su stock ');
  writeln('(o nada para finalizar la modificacion): ');
  readln(nom);
  While (nom<>'') Do
    Begin
      buscarCelular(arc_celulares, nom, pos);
      While ((nom<>'') And (pos=-1)) Do
        Begin
          writeln('El nombre del celular no existe.');
          write('Introduzca un nombre de celular correcto para ');
          write('modificar su stock: ');
          writeln('(o nada para finalizar la modificacion): ');
          readln(nom);
          buscarCelular(arc_celulares, nom, pos);
        End;
      If (nom<>'')Then
        Begin
          Seek(arc_celulares, pos);
          read(arc_celulares, c);
          writeln('Desea modificar al siguiente celular? (Y) ');
          writeln(celularToString(c));
          readln(opcion);
          If ((opcion = 'y') Or (opcion = 'Y'))Then
            Begin
              writeln('Introduzca el nuevo stock del celular: ');
              readln(n);
              c.stockD := n;
              Seek(arc_celulares, pos);
              write(arc_celulares, c);
            End;
          writeln('');
          write('Introduzca el codigo de otro celular a modificar su stock');
          writeln('(o nada para finalizar la modificacion): ');
          readln(nom);
        End;
    End;
  Close(arc_celulares);
End;

Procedure listarTodosLosCelulares(Var arc_celulares: file_celulares);
Begin
  writeln('----------Lista de todos los celulares-----------');
  writeln(Format(' %-4s | %-24s | %-8s | %-7s | %-2s | %-2s | %-12s',
          ['Cod', 'Nombre', 'Marca', 'Precio', 'SD', 'SM', 'Descripcion']));
  listarCelularesPorString(arc_celulares, ' ');
End;

Procedure listarDespuesDeModificar(Var arc_celulares: file_celulares);

Var 
  opcion: char;
Begin
  writeln('Desdea listar el archivo con los celulares nuevos? (Y)');
  readln(opcion);
  If ((opcion = 'y') Or (opcion = 'Y'))Then
    Begin
      listarTodosLosCelulares(arc_celulares);
    End;
End;

Procedure exportarSinStock(Var arc_celulares: file_celulares);

Var 
  c: celular;
  t: Text;
Begin
  Assign(t, 'sinStock.txt');
  Reset(arc_celulares);
  Rewrite(t);
  While Not EOF(arc_celulares) Do
    Begin
      read(arc_celulares, c);
      If (c.stockD=0)Then
        Begin
          With c Do
            Begin
              writeln(t,codigo,' ',precio,' ',marca);
              writeln(t,stockD,' ',stockM,' ',descripcion);
              writeln(t, nombre);
            End;
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
      writeln('--------------Aniadir celulares (5)--------------');
      writeln('---------------Modificar stock (6)---------------');
      writeln('--------Exportar celulares sin stock (7)---------');
      writeln('---------Listar todos los celulares (8)----------');
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
        If (opcion = 5)Then
          Begin
            writeln('----------------Aniadir celulares----------------');
            aniadirCelulares(arc_celulares);
            listarDespuesDeModificar(arc_celulares);
          End

      Else
        If (opcion = 6)Then
          Begin
            writeln('-----------------Modificar stock-----------------');
            modificarStock(arc_celulares);
            listarDespuesDeModificar(arc_celulares);
          End

      Else
        If (opcion = 7)Then
          Begin
            exportarSinStock(arc_celulares);
            writeln('-------Contenido exportado a sinStock.txt-------');
          End

      Else
        If (opcion = 8)Then
          Begin
            listarTodosLosCelulares(arc_celulares);
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
