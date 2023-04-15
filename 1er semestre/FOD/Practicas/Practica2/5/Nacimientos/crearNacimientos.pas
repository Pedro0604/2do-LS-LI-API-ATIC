
Program CrearArchivosDeNacimientos;

Uses 
SysUtils;

Const 
  CANTIDAD_ARCHIVOS = 10;
  CANTIDAD_NACIMIENTOS = 10;

Type 
  nacimiento = Record
    nroPartida : integer;
    nombre, apellido, direccion: string;
    matriculaNacim : integer;
    nombreM, apellidoM, dniM, nombreP, apellidoP, dniP: string;
  End;

Procedure ImprimirArchivoDeNacimientos(nombreArchivo: String);

Var 
  archivo: file Of nacimiento;
  nac: nacimiento;
Begin
  // Abrir el archivo en modo lectura
  Assign(archivo, nombreArchivo);
  Reset(archivo);

  // Imprimir los encabezados de las columnas
  WriteLn('Nro Partida':15, 'Nombre':20, 'Apellido':20, 'Direccion':20, 'Matricula Nacim':
          20, 'Nombre Madre':20, 'Apellido Madre':20, 'DNI Madre':20, 'Nombre Padre':20,
          'Apellido Padre':20, 'DNI Padre':20);
  WriteLn(StringOfChar('-', 215));

  // Leer y mostrar cada registro del archivo
  While Not EOF(archivo) Do
    Begin
      Read(archivo, nac);
      WriteLn(nac.nroPartida:15, nac.nombre:20, nac.apellido:20, nac.direccion:20, nac.
              matriculaNacim:20, nac.nombreM:20, nac.apellidoM:20, nac.dniM:20, nac.
              nombreP:20, nac.apellidoP:20, nac.dniP:20);
    End;
  writeln();

  // Cerrar el archivo
  Close(archivo);
End;


Var 
  i, j: integer;
  archivo: file Of nacimiento;
  nac: nacimiento;
  nombreArchivo: string;

Begin
  // Inicializar el generador de números aleatorios
  Randomize;

  // Generar los archivos
  For i := 1 To CANTIDAD_ARCHIVOS Do
    Begin
      // Generar el nombre del archivo
      nombreArchivo := 'nacimientos' + IntToStr(i) + '.nacim';

      // Crear el archivo
      Assign(archivo, nombreArchivo);
      Rewrite(archivo);

      // Generar los nacimientos y escribirlos en el archivo
      For j := 1 To CANTIDAD_NACIMIENTOS Do
        Begin
          nac.nroPartida := (i-1)*CANTIDAD_NACIMIENTOS+j;
          nac.nombre := 'Nombre' + IntToStr(j);
          nac.apellido := 'Apellido' + IntToStr(j);
          nac.direccion := 'Direccion' + IntToStr(j);
          nac.matriculaNacim := Random(10000)+1;
          nac.nombreM := 'NombreM' + IntToStr(j);
          nac.apellidoM := 'ApellidoM' + IntToStr(j);
          nac.dniM := 'DNIM' + IntToStr(j);
          nac.nombreP := 'NombreP' + IntToStr(j);
          nac.apellidoP := 'ApellidoP' + IntToStr(j);
          nac.dniP := 'DNIP' + IntToStr(j);
          Write(archivo, nac);
        End;

      // Cerrar el archivo
      Close(archivo);
    End;

  ImprimirArchivoDeNacimientos('nacimientos1.nacim');
  ImprimirArchivoDeNacimientos('nacimientos2.nacim');
End.
