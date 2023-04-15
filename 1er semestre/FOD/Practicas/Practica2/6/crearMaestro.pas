
Program CrearArchivos;

Uses 
sysutils;

Const 
  MAX_COD_LOC = 100;
  MAX_COD_CEPA = 10;

Type 

  regMaestro = Record
    codigoLocalidad: integer;
    nombreLocalidad: string;
    codigoCepa: integer;
    nombreCepa: string;
    casosActivos: integer;
    casosNuevos: integer;
    casosRecuperados: integer;
    casosFallecidos: integer;
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
      writeln('Codigo Localidad: ', reg.codigoLocalidad);
      writeln('Nombre Localidad: ', reg.nombreLocalidad);
      writeln('Codigo Cepa: ', reg.codigoCepa);
      writeln('Nombre Cepa: ', reg.nombreCepa);
      writeln('Casos Activos: ', reg.casosActivos);
      writeln('Casos Nuevos: ', reg.casosNuevos);
      writeln('Casos Recuperados: ', reg.casosRecuperados);
      writeln('Casos Fallecidos: ', reg.casosFallecidos);
      writeln;
    End;

  // Cerrar el archivo
  close(archivo);
End;


Var 
  archivo: file Of RegMaestro;
  reg: RegMaestro;
  codLoc, codCepa: integer;

Begin
  // Abrir el archivo
  assign(archivo, 'maestro.dat');
  rewrite(archivo);

  // Generar registros para cada combinación de código de localidad y código de cepa
  For codLoc := 1 To MAX_COD_LOC Do
    Begin
      For codCepa := 1 To MAX_COD_CEPA Do
        Begin
          reg.codigoLocalidad := codLoc;
          reg.nombreLocalidad := 'Localidad ' + IntToStr(codLoc);
          reg.codigoCepa := codCepa;
          reg.nombreCepa := 'Cepa ' + IntToStr(codCepa);
          reg.casosActivos := Random(1000);
          reg.casosNuevos := Random(100);
          reg.casosRecuperados := Random(500);
          reg.casosFallecidos := Random(100);

          // Escribir el registro en el archivo
          write(archivo, reg);
        End;
    End;

  // Cerrar el archivo
  close(archivo);
  ImprimirArchivo('maestro.dat');
End.
