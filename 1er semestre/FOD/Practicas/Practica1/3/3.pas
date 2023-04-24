
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
      writeln('Apellido: ');
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
Procedure ingresarDatos(Var arc_empleados: file_empleados);

Var 
  e: empleado;
Begin
  writeln('');
  writeln('Ingrese un empleado: ');
  ingresarEmpleado(e);
  Rewrite(arc_empleados);
  While (e.apellido<>'fin') Do
    Begin
      write(arc_empleados, e);
      writeln('');
      writeln('Ingrese otro empleado: ');
      ingresarEmpleado(e);
    End;
  Close(arc_empleados);
End;

Procedure crearArchivoEmpleados(Var arc_empleados: file_empleados);

Var 
  nombre_archivo: string[20];
Begin
  writeln('Nombre archivo: ');
  readln(nombre_archivo);
  Assign(arc_empleados, nombre_archivo+'.emp');
  ingresarDatos(arc_empleados);
End;

Function empToString(e:empleado): string;
Begin
  With e Do
    Begin
      empToString := 'Numero: ' + IntToStr(num) + ' - Nombre: ' + nombre +
                     ' - Apellido: ' + apellido + ' - Edad: ' + IntToStr(edad) +
                     ' - DNI: ' + dni;
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
      writeln('----------Empleado encontrado---------');
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
      writeln('----------Empleado encontrado---------');
      writeln('------Empleado no encontrado :( ------');
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

Var 
  finish, asignado: boolean;
  opcion: char;
  arc_empleados: file_empleados;
  st, nombre_archivo: String;
Begin
  finish := false;
  asignado := false;
  While (Not finish) Do
    Begin
      writeln('======================================');
      writeln('======================================');
      writeln('-----------------Menu-----------------');
      writeln('----Crear archivo de empleados (C)----');
      writeln('----Listar empleado con nombre (N)----');
      writeln('---Listar empleado con apellido (S)---');
      writeln('----Listar todos los empleados (A)----');
      writeln('------Listar empleados viejos (O)-----');
      writeln('------Finalizar la ejecucion (Q)------');
      writeln('======================================');
      writeln('======================================');
      readln(opcion);
      writeln('');
      writeln('');
      If ((opcion='c') Or (opcion='C'))Then
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
      If ((opcion = 'n') Or (opcion = 'N'))Then
        Begin
          writeln('Nombre a buscar: ');
          readln(st);
          listarEmpleadoPorString(arc_empleados, st, true);
        End
      Else
        If ((opcion = 's') Or (opcion = 'S'))Then
          Begin
            writeln('Apellido a buscar: ');
            readln(st);
            listarEmpleadoPorString(arc_empleados, st, false);
          End

      Else
        If ((opcion = 'a') Or (opcion = 'A'))Then
          Begin
            writeln('-----Lista de todos los empleados-----');
            listarTodos(arc_empleados);
          End

      Else
        If ((opcion = 'o') Or (opcion = 'o'))Then
          Begin
            writeln('-----Lista de los empleados viejos----');
            listarViejos(arc_empleados);
          End

      Else
        If ((opcion ='q') Or (opcion ='Q'))Then
          Begin
            finish := true;
            writeln('======================================');
            writeln('======================================');
            writeln('-----------------Adios----------------');
            writeln('======================================');
            writeln('======================================');
          End;
      writeln('');
      writeln('');
    End;
End.
