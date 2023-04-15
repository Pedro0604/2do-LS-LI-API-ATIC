
Program CrearArchivosDeFallecimientos;

Uses 
SysUtils;

Const 
  CANTIDAD_ARCHIVOS = 10;
  CANTIDAD_FALLECIMIENTOS = 7;

Type 
  fecha = Record
    dia, mes, anio, hora, minuto: integer;
  End;

  fallecimiento = Record
    nroPartida: integer;
    dni, nombre, apellido: string;
    matriculaFall: integer;
    f: fecha;
    lugar: string;
  End;


Procedure ImprimirArchivoDeFallecimientos(nombreArchivo: String);

Var 
  archivo: file Of fallecimiento;
  fall: fallecimiento;
Begin
  // Abrir el archivo en modo lectura
  Assign(archivo, nombreArchivo);
  Reset(archivo);

  // Imprimir los encabezados de las columnas
  WriteLn('Nro Partida':15,'DNI':20, 'Nombre':20, 'Apellido':20, 'Matricula Nacim':
          20, 'Hora':7, 'Minuto':7, 'Dia':7, 'Mes':7, 'Anio':7, 'Lugar':20);
  WriteLn(StringOfChar('-', 150));

  // Leer y mostrar cada registro del archivo
  While Not EOF(archivo) Do
    Begin
      Read(archivo, fall);
      WriteLn(fall.nroPartida:15, fall.nombre:20, fall.apellido:20, fall.dni:20,
              fall.matriculaFall:20, fall.f.hora:7, fall.f.minuto:7, fall.f.dia:7, fall.f.
              mes:7, fall.f.anio:7, fall.lugar:20);
    End;
  writeln();

  // Cerrar el archivo
  Close(archivo);
End;

Var 
  i, j: integer;
  archivo: file Of fallecimiento;
  fall: fallecimiento;
  nombreArchivo: string;

Begin
  // Inicializar el generador de números aleatorios
  Randomize;

  // Generar los archivos
  For i := 1 To CANTIDAD_ARCHIVOS Do
    Begin
      // Generar el nombre del archivo
      nombreArchivo := 'fallecimientos' + IntToStr(i) + '.fall';

      // Crear el archivo
      Assign(archivo, nombreArchivo);
      Rewrite(archivo);

      // Generar los fallecimientos y escribirlos en el archivo
      For j := 1 To CANTIDAD_FALLECIMIENTOS Do
        Begin
          fall.nroPartida := (i-1)*CANTIDAD_FALLECIMIENTOS+j;
          fall.dni := 'DNI' + IntToStr(j);
          fall.nombre := 'Nombre' + IntToStr(j);
          fall.apellido := 'Apellido' + IntToStr(j);
          fall.matriculaFall := Random(10000)+1;
          fall.f.hora := Random(24)+1;
          fall.f.minuto := Random(60)+1;
          fall.f.dia := Random(28)+1;
          fall.f.mes := Random(12)+1;
          fall.f.anio := Random(100)+1924;
          fall.lugar := 'Lugar' + IntToStr(j);
          Write(archivo, fall);
        End;
      // Cerrar el archivo
      Close(archivo);
    End;

  ImprimirArchivoDeFallecimientos('fallecimientos1.fall');
  ImprimirArchivoDeFallecimientos('fallecimientos2.fall');

End.
