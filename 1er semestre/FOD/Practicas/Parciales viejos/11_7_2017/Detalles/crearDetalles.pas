
Program CrearArchivos;

Uses 
sysutils;

Const 
  CANT_DETALLES = 2;
  MAX_REGISTROS = 50;
  MAX_DNI = 9;
  MAX_COD_CARRERA = 8;

Type 
  regDetalle = Record
    dni : string;
    codCarr: integer;
    montoCuota: real;
  End;

Procedure ImprimirArchivo(nombreArchivo: String);

Var 
  archivo: file Of regDetalle;
  reg: regDetalle;

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
      write(' - Codigo carrera: ', reg.codCarr);
      write(' - MontoCuota: ', reg.montoCuota:2:2);
      writeln;
    End;

  // Cerrar el archivo
  close(archivo);
End;


Var 
  i, j, n, k: integer;
  archivo: file Of regDetalle;
  reg: regDetalle;
  dni: string;
  codCarr, min: integer;
  registros: array[1..MAX_DNI*MAX_COD_CARRERA] Of regDetalle;
  aux: regDetalle;
Begin
  Randomize();
  // Crear CANT_DETALLESarchivos
  For i := 1 To CANT_DETALLES Do
    Begin
      // Generar registros aleatorios
      min := MAX_REGISTROS;
      If (MAX_DNI*MAX_COD_CARRERA<MAX_REGISTROS)Then
        min := MAX_DNI*MAX_COD_CARRERA;
      n := random(min) + 1;
      // cantidad aleatoria de registros entre 1 y MAX_REGISTROS
      //o MAX_DNI*MAX_COD_CARRERA
      For j := 1 To n Do
        Begin
          // Generar códigos aleatorios
          dni := intToStr(random(MAX_DNI) + 1);
          // código de localidad aleatorio entre 1 y MAX_DNI
          codCarr := random(MAX_COD_CARRERA) + 1;
          // código de cepa aleatorio entre 1 y MAX_COD_CARRERA

          // El registro no existe, crearlo
          reg.dni := dni;
          reg.codCarr := codCarr;
          reg.montoCuota := random(1000);
          registros[j] := reg;
        End;

      // Ordenar los registros por código de localidad y código de cepa
      For j := 1 To n-1 Do
        Begin
          For k := j+1 To n Do
            Begin
              If (registros[j].dni > registros[k].dni) Or
                 ((registros[j].dni = registros[k].dni) And (
                 registros[j].codCarr > registros[k].codCarr)) Then
                Begin
                  aux := registros[j];
                  registros[j] := registros[k];
                  registros[k] := aux;
                End;
            End;
        End;

      // Guardar los registros en el archivo
      assign(archivo, 'detalle' + IntToStr(i) + '.det');
      rewrite(archivo);
      For j := 1 To n Do
        Begin
          Write(archivo, registros[j]);
        End;
      close(archivo);
    End;

  ImprimirArchivo('detalle1.det');
  ImprimirArchivo('detalle2.det');


End.
