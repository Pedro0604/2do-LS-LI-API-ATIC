
Program CrearArchivos;

Uses 
sysutils;

Const 
  MAX_REGISTROS = 10000;
  MAX_DEPARTAMENTO = 100;
  MAX_DIVISION = 100;
  MAX_NRO_EMPLEADO = 100;
  CANT_CATEGORIAS = 15;

Type 
  empleado = Record
    departamento: integer;
    division: integer;
    numeroEmpleado: integer;
    categoria: integer;
    horasExtras: integer;
  End;

Procedure ImprimirArchivo(nombreArchivo: String);

Var 
  archivo: file Of empleado;
  reg: empleado;

Begin
  Randomize();
  // Abrir el archivo
  assign(archivo, nombreArchivo);
  reset(archivo);

  // Leer los registros del archivo y mostrarlos por pantalla
  writeln('Contenido del archivo "', nombreArchivo, '":');
  While Not eof(archivo) Do
    Begin
      read(archivo, reg);
      write('Departamento: ', reg.departamento, ' | ');
      write('División: ', reg.division, ' | ');
      write('Nro emp: ', reg.numeroEmpleado, ' | ');
      write('Categoría: ', reg.categoria, ' | ');
      write('Total Hs: ', reg.horasExtras, ' | ');
      writeln();
    End;

  // Cerrar el archivo
  close(archivo);
End;


Var 
  j, n, k: integer;
  archivo: file Of empleado;
  reg: empleado;
  dep, divis, nroEmp: integer;
  registros: array[1..MAX_REGISTROS] Of empleado;
  aux: empleado;
Begin
  Randomize();
  n := random(MAX_REGISTROS) + 1;
  For j := 1 To n Do
    Begin
      dep := random(MAX_DEPARTAMENTO) + 1;
      divis := random(24) + MAX_DIVISION-23;
      nroEmp := random(MAX_NRO_EMPLEADO) + 1;
      reg.departamento := dep;
      reg.division := divis;
      reg.numeroEmpleado := nroEmp;
      reg.categoria := random(CANT_CATEGORIAS)+1;
      reg.horasExtras := random(15)+1;
      registros[j] := reg;
    End;

  For j := 1 To n-1 Do
    Begin
      For k := j+1 To n Do
        Begin
          If (registros[j].departamento > registros[k].departamento) Or
             ((registros[j].departamento = registros[k].departamento) And ((
             registros[j].division > registros[k].division) Or ((registros[j].division =
             registros[
             k].division) And (registros[j].numeroEmpleado > registros[k].numeroEmpleado))
             )) Then
            Begin
              aux := registros[j];
              registros[j] := registros[k];
              registros[k] := aux;
            End;
        End;
    End;

  assign(archivo, 'empleados.emp');
  rewrite(archivo);
  For j := 1 To n Do
    Begin
      If ((j=1) Or (registros[j].departamento <> registros[j-1].departamento) Or
         (registros[j].division <> registros[j-1].division) Or (registros[j].
         numeroEmpleado <>registros[j-1].numeroEmpleado))Then
        Write(archivo, registros[j]);
    End;
  close(archivo);

  ImprimirArchivo('empleados.emp');
  writeln('n: ', n);
End.
