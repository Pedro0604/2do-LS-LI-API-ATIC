
Program CrearArchivos;

Uses 
sysutils;

Const 
  MAX_DNI = 9;
  MAX_COD_CARRERA = 8;

Type 

  regMaestro = Record
    dni : string;
    codCarr: integer;
    montoTotal: real;
  End;


Procedure ImprimirArchivo(nombreArchivo: String);

Var 
  archivo: file Of regMaestro;
  reg: regMaestro;

Begin
  // Abrir el archivo
  assign(archivo, nombreArchivo);
  reset(archivo);

  // Leer los registros del archivo y mostrarlos por pantalla
  writeln('Contenido del archivo "', nombreArchivo, '":');
  While Not eof(archivo) Do
    Begin
      read(archivo, reg);
      write('DNI: ', reg.dni);
      write(' - codCarrera: ', reg.codCarr);
      writeln(' - montoTotal: ', reg.montoTotal:2:2);
      writeln;
    End;

  // Cerrar el archivo
  close(archivo);
End;


Var 
  archivo: file Of RegMaestro;
  reg: RegMaestro;
  dni, codCarr: integer;

Begin
  // Abrir el archivo
  assign(archivo, 'alumnos.al');
  rewrite(archivo);

  // Generar registros para cada combinación de dni y codigo de carrera
  For dni := 1 To MAX_DNI Do
    Begin
      For codCarr := 1 To MAX_COD_CARRERA Do
        Begin
          reg.dni := intToStr(dni);
          reg.codCarr := codCarr;
          reg.montoTotal := Random(1000);

          // Escribir el registro en el archivo
          write(archivo, reg);
        End;
    End;

  // Cerrar el archivo
  close(archivo);
  ImprimirArchivo('alumnos.al');
End.
