
Program tres;

Uses SysUtils;

Type 
  empleado = Record
    num, edad: integer;
    apellido, nombre: String;
    dni: string;
  End;

  file_empleados = file Of empleado;

Procedure ingresarEmpleado(Var e:empleado);
Begin
  With e Do
    Begin
      writeln('Apellido (o fin para terminar la modificacion): ');
      readln(apellido);
      If (apellido<>'fin')Then
        Begin
          writeln('Nombre: ');
          readln(nombre);
          writeln('Numero: ');
          readln(num);
          writeln('Edad: ');
          readln(edad);
          writeln('DNI: ');
          readln(dni);
        End;
    End;
End;

Procedure buscarEmp(Var arc_empleados: file_empleados; n: integer;Var pos:
                    integer);

Var 
  posOg: integer;
  e: empleado;
Begin
  posOg := FilePos(arc_empleados);
  pos := -1;
  Seek(arc_empleados, 0);
  While Not EOF(arc_empleados) Do
    Begin
      read(arc_empleados, e);
      If (e.num = n)Then
        Begin
          pos := FilePos(arc_empleados)-1;
        End;
    End;
  Seek(arc_empleados, posOg);
End;

Procedure ingresarDatos(Var arc_empleados: file_empleados);

Var 
  e: empleado;
  pos: integer;
Begin
  pos := 0;
  writeln('');
  writeln('Ingrese un empleado: ');
  ingresarEmpleado(e);
  While (e.apellido<>'fin') Do
    Begin
      writeln('');
      buscarEmp(arc_empleados, e.num, pos);
      If (pos=-1)Then
        Begin
          write(arc_empleados, e);
        End
      Else
        Begin
          writeln('El empleado ingresado ya existe.');
        End;
      writeln('Ingrese otro empleado: ');
      ingresarEmpleado(e);
    End;
End;

Procedure crearArchivoEmpleados(Var arc_empleados: file_empleados);

Var 
  nombre_archivo: string[20];
Begin
  writeln('Nombre archivo: ');
  readln(nombre_archivo);
  Assign(arc_empleados, nombre_archivo+'.emp');
  Rewrite(arc_empleados);
  ingresarDatos(arc_empleados);
  Close(arc_empleados);
End;

Function empToString(e:empleado): string;
Begin
  With e Do
    Begin
      empToString := Format('  %-2d | %-10s | %-10s | %-3d | %-8s', [num, nombre
                     , apellido, edad, dni]);
    End;
End;

Procedure listarEmpleadoPorString(Var arc_empleados: file_empleados; st:String;
                                  nom:boolean);

Var 
  e: empleado;
  foundEmp: boolean;
Procedure imprimirEmp(e: empleado; foundEmp: boolean);
Begin
  If (Not foundEmp)Then
    Begin
      writeln('---------------Empleado encontrado---------------');
    End;
  writeln(empToString(e));
End;
Begin
  foundEmp := false;
  Reset(arc_empleados);
  While (Not eof(arc_empleados)) Do
    Begin
      read(arc_empleados, e);
      If ((e.nombre=st) And (nom))Then
        Begin
          imprimirEmp(e, foundEmp);
          foundEmp := true;
        End
      Else If ((e.apellido=st) And (Not nom))Then
             Begin
               imprimirEmp(e, foundEmp);
               foundEmp := true;
             End;
    End;
  Close(arc_empleados);
  If (Not foundEmp)Then
    Begin
      writeln('---------------Empleado encontrado---------------');
      writeln('-----------Empleado no encontrado :( ------------');
    End;
End;

Procedure listarTodos(Var arc_empleados: file_empleados);

Var 
  e: empleado;
Begin
  Reset(arc_empleados);
  While Not eof(arc_empleados) Do
    Begin
      read(arc_empleados, e);
      writeln(empToString(e));
    End;
  Close(arc_empleados);
End;

Procedure listarViejos(Var arc_empleados: file_empleados);

Var 
  e: empleado;
Begin
  Reset(arc_empleados);
  While Not eof(arc_empleados) Do
    Begin
      read(arc_empleados, e);
      If (e.edad>70)Then
        Begin
          writeln(empToString(e));
        End;
    End;
  Close(arc_empleados);
End;

Procedure anadirEmp(Var arc_empleados: file_empleados);
Begin
  Reset(arc_empleados);
  Seek(arc_empleados, fileSize(arc_empleados));
  ingresarDatos(arc_empleados);
  Close(arc_empleados);
End;

Procedure modificarEdad(Var arc_empleados: file_empleados);

Var 
  n: integer;
  opcion: char;
  pos: integer;
  e: empleado;
Begin
  pos := 0;
  Reset(arc_empleados);
  write('Introduzca el numero de un empleado a modificar su edad ');
  writeln('(o 0 para finalizar la modificacion): ');
  readln(n);
  While (n<>0) Do
    Begin
      buscarEmp(arc_empleados, n, pos);
      While ((n<>0) And (pos=-1)) Do
        Begin
          writeln('El numero del empleado no existe.');
          write('Introduzca un numero de empleado correcto para ');
          write('modificar su edad: ');
          writeln('(o 0 para finalizar la modificacion): ');
          readln(n);
          buscarEmp(arc_empleados, n, pos);
        End;
      If (n<>0)Then
        Begin
          Seek(arc_empleados, pos);
          read(arc_empleados, e);
          writeln(empToString(e));
          writeln('Desea modificar al siguiente empleado? (Y) ');
          readln(opcion);
          If ((opcion = 'y') Or (opcion = 'Y'))Then
            Begin
              writeln('Introduzca la nueva edad del empleado: ');
              readln(n);
              e.edad := n;
              Seek(arc_empleados, pos);
              write(arc_empleados, e);
            End;
          writeln('');
          write('Introduzca el numero de otro empleado a modificar su edad');
          writeln('(o 0 para finalizar la modificacion): ');
          readln(n);
        End;
    End;
  Close(arc_empleados);
End;

Procedure listarDespuesDeModificar(Var arc_empleados: file_empleados);

Var 
  opcion: char;
Begin
  writeln('Desdea listar el archivo con los empleados nuevos? (Y)');
  readln(opcion);
  If ((opcion = 'y') Or (opcion = 'Y'))Then
    Begin
      writeln('----------Lista de todos los empleados-----------');
      listarTodos(arc_empleados);
    End;

End;

Procedure exportarContenido(Var arc_empleados: file_empleados);

Var 
  e: empleado;
  t: Text;
Begin
  Reset(arc_empleados);
  Assign(t, 'todos_empleados.txt');
  Rewrite(t);
  While Not EOF(arc_empleados) Do
    Begin
      read(arc_empleados, e);
      writeln(t, empToString(e));
    End;
  Close(t);
  Close(arc_empleados);
End;

Procedure exportarFaltantes(Var arc_empleados: file_empleados);

Var 
  e: empleado;
  t: Text;
Begin
  Reset(arc_empleados);
  Assign(t, 'faltaDNIEmpleado.txt');
  Rewrite(t);
  While Not EOF(arc_empleados) Do
    Begin
      read(arc_empleados, e);
      If (e.dni = '00')Then
        Begin
          writeln(t, empToString(e));
        End;
    End;
  Close(t);
  Close(arc_empleados);
End;

Procedure darDeBaja(Var arc_empleados: file_empleados);

Var 
  e: empleado;
  pos, num: integer;
Begin
  Reset(arc_empleados);
  write('Ingrese el numero de empleado a eliminar: ');
  readln(num);
  buscarEmp(arc_empleados, num, pos);
  If (pos<>-1)Then
    Begin
      Seek(arc_empleados, FileSize(arc_empleados)-1);
      read(arc_empleados, e);
      Seek(arc_empleados, pos);
      write(arc_empleados, e);
      Seek(arc_empleados, FileSize(arc_empleados)-1);
      Truncate(arc_empleados);
      writeln('Empleado eliminado exitosamente');
    End
  Else
    writeln('###ERROR### El empleado con numero de empleado ', num,
            ' no existe ###ERROR###');
  writeln();
  Close(arc_empleados);
End;


Var 
  finish, asignado: boolean;
  opcion: integer;
  arc_empleados: file_empleados;
  st, nombre_archivo: String;
Begin
  finish := false;
  asignado := false;
  While (Not finish) Do
    Begin
      writeln('=================================================');
      writeln('=================================================');
      writeln('----------------------Menu-----------------------');
      writeln('---------Crear archivo de empleados (1)----------');
      writeln('---------Listar empleado con nombre (2)----------');
      writeln('--------Listar empleado con apellido (3)---------');
      writeln('---------Listar todos los empleados (4)----------');
      writeln('-----------Listar empleados viejos (5)-----------');
      writeln('--------------Anadir Empleado/s (6)--------------');
      writeln('---------------Modificar edad (7)----------------');
      writeln('-------------Exportar contenido (8)--------------');
      writeln('-------------Exportar faltantes (9)--------------');
      writeln('----------Dar de baja un empleado (10)-----------');
      writeln('-----------Finalizar la ejecucion (-1)-----------');
      writeln('=================================================');
      writeln('=================================================');
      readln(opcion);
      writeln('');
      writeln('');
      If (opcion=1)Then
        Begin
          crearArchivoEmpleados(arc_empleados);
          asignado := true;
        End
      Else
        If (Not asignado)Then
          Begin
            writeln('Introduzca el nombre del archivo a utilizar: ');
            readln(nombre_archivo);
            Assign(arc_empleados, nombre_archivo + '.emp');
            asignado := true;
            writeln('');
          End;
      If (opcion = 2)Then
        Begin
          writeln('Nombre a buscar: ');
          readln(st);
          listarEmpleadoPorString(arc_empleados, st, true);
        End
      Else
        If (opcion = 3)Then
          Begin
            writeln('Apellido a buscar: ');
            readln(st);
            listarEmpleadoPorString(arc_empleados, st, false);
          End

      Else
        If (opcion = 4)Then
          Begin
            writeln('----------Lista de todos los empleados-----------');
            listarTodos(arc_empleados);
          End

      Else
        If (opcion = 5)Then
          Begin
            writeln('----------Lista de los empleados viejos----------');
            listarViejos(arc_empleados);
          End

      Else
        If (opcion = 6)Then
          Begin
            writeln('----------------Anadir Empleado/s----------------');
            anadirEmp(arc_empleados);
            listarDespuesDeModificar(arc_empleados);
          End

      Else
        If (opcion = 7)Then
          Begin
            writeln('-----------------Modificar edad------------------');
            modificarEdad(arc_empleados);
            listarDespuesDeModificar(arc_empleados);
          End

      Else
        If (opcion = 8)Then
          Begin
            exportarContenido(arc_empleados);
            writeln('----Contenido exportado a todos_empleados.txt----');
          End

      Else
        If (opcion = 9)Then
          Begin
            exportarFaltantes(arc_empleados);
            writeln('---Faltantes exportados a faltaDNIEmpleado.txt---');
          End
      Else
        If (opcion = 10)Then
          Begin
            darDeBaja(arc_empleados);
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
