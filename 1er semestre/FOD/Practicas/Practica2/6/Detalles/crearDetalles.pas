
Program CrearArchivos;

Uses 
sysutils;

Const 
  CANT_DETALLES = 10;
  MAX_REGISTROS = 50;
  MAX_COD_LOC = 100;
  MAX_COD_CEPA = 10;

Type 
  regDetalle = Record
    codigoLocalidad: integer;
    codigoCepa: integer;
    casosActivos: integer;
    casosNuevos: integer;
    casosRecuperados: integer;
    casosFallecidos: integer;
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
      writeln('Codigo Localidad: ', reg.codigoLocalidad);
      writeln('Codigo Cepa: ', reg.codigoCepa);
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
  i, j, n, k: integer;
  archivo: file Of regDetalle;
  reg: regDetalle;
  codLoc, codCepa, min: integer;
  registros: array[1..MAX_COD_LOC*MAX_COD_CEPA] Of regDetalle;
  aux: regDetalle;
Begin
  Randomize();
  // Crear CANT_DETALLESarchivos
  For i := 1 To CANT_DETALLES Do
    Begin
      // Generar registros aleatorios
      min := MAX_REGISTROS;
      If (MAX_COD_LOC*MAX_COD_CEPA<MAX_REGISTROS)Then
        min := MAX_COD_LOC*MAX_COD_CEPA;
      n := random(min) + 1;
      // cantidad aleatoria de registros entre 1 y MAX_REGISTROS
      //o MAX_COD_LOC*MAX_COD_CEPA
      For j := 1 To n Do
        Begin
          // Generar códigos aleatorios
          codLoc := random(MAX_COD_LOC) + 1;
          // código de localidad aleatorio entre 1 y MAX_COD_LOC
          codCepa := random(MAX_COD_CEPA) + 1;
          // código de cepa aleatorio entre 1 y MAX_COD_CEPA

          // Verificar si el registro ya existe
          While True Do
            Begin
              If (j = 1) Or ((registros[j-1].codigoLocalidad <> codLoc) Or (registros[j-1]
                 .codigoCepa <> codCepa)) Then
                Begin
                  // El registro no existe, crearlo
                  reg.codigoLocalidad := codLoc;
                  reg.codigoCepa := codCepa;
                  reg.casosActivos := random(1000);
                  reg.casosNuevos := random(100);
                  reg.casosRecuperados := random(500);
                  reg.casosFallecidos := random(100);
                  registros[j] := reg;
                  break;
                End
              Else
                Begin
                  // El registro ya existe, generar nuevos códigos
                  codLoc := random(MAX_COD_LOC) + 1;
                  codCepa := random(MAX_COD_CEPA) + 1;
                End;
            End;
        End;

      // Ordenar los registros por código de localidad y código de cepa
      For j := 1 To n-1 Do
        Begin
          For k := j+1 To n Do
            Begin
              If (registros[j].codigoLocalidad > registros[k].codigoLocalidad) Or
                 ((registros[j].codigoLocalidad = registros[k].codigoLocalidad) And (
                 registros[j].codigoCepa > registros[k].codigoCepa)) Then
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
          If ((j=1) Or (registros[j].codigoLocalidad <> registros[j-1].codigoLocalidad) Or
             (registros[j].codigoCepa <> registros[j-1].codigoCepa))Then
            Write(archivo, registros[j]);
        End;
      close(archivo);
    End;

  ImprimirArchivo('detalle1.det');
End.
