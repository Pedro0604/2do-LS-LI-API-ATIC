
Program CrearArchivos;

Uses 
sysutils;

Const 
  MAX_REGISTROS = 10000;
  MAX_COD_PROV = 23;
  MAX_COD_LOC = 100;

Type 

  regMaestro = Record
    codProvincia, codLocalidad, nroMesa, cantVotos: integer;
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
      write('Codigo de Provincia: ', reg.codProvincia, ' | ');
      write('Codigo de Localidad: ', reg.codLocalidad, ' | ');
      write('Numero de Mesa: ', reg.nroMesa, ' | ');
      write('Cantidad de Votos: ', reg.cantVotos);
      writeln();
    End;
  // Cerrar el archivo
  close(archivo);
End;


Var 
  j, n, k: integer;
  archivo: file Of regMaestro;
  reg: regMaestro;
  codProv, codLoc: integer;
  registros: array[1..MAX_REGISTROS] Of regMaestro;
  aux: regMaestro;
Begin
  Randomize();
  n := random(MAX_REGISTROS) + 1;
  For j := 1 To n Do
    Begin
      codProv := random(MAX_COD_PROV) + 1;
      codLoc := random(MAX_COD_LOC) + 1;
      reg.codProvincia := codProv;
      reg.codLocalidad := codLoc;
      reg.nroMesa := j;
      reg.cantVotos := random(1000);
      registros[j] := reg;
      codProv := random(MAX_COD_PROV) + 1;
      codLoc := random(MAX_COD_LOC) + 1;
    End;


  For j := 1 To n-1 Do
    Begin
      For k := j+1 To n Do
        Begin
          If (registros[j].codProvincia > registros[k].codProvincia) Or
             ((registros[j].codProvincia = registros[k].codProvincia) And (
             registros[j].codLocalidad > registros[k].codLocalidad)) Then
            Begin
              aux := registros[j];
              registros[j] := registros[k];
              registros[k] := aux;
            End;
        End;
    End;

  // Guardar los registros en el archivo
  assign(archivo, 'mesas.votos');
  rewrite(archivo);
  For j := 1 To n Do
    Begin
      Write(archivo, registros[j]);
    End;
  close(archivo);

  ImprimirArchivo('mesas.votos');
  writeln('n: ', n);
End.
