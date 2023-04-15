
Program CrearArchivos;

Uses 
sysutils;

Const 
  MAX_REGISTROS = 100;
  MAX_COD_CLIENTE = 100;
  MAX_ANIO = 2023;
  MAX_MES = 12;

Type 
  cliente = Record
    codCliente: integer;
    nombre, apellido: string;
  End;
  regMaestro = Record
    cl: cliente;
    anio, mes, dia: integer;
    monto: real;
  End;


Procedure ImprimirArchivo(nombreArchivo: String);

Var 
  archivo: file Of regMaestro;
  reg: regMaestro;

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
      write(reg.cl.codCliente, ' | ');
      write(reg.cl.nombre, ' ', reg.cl.apellido, ' | ');
      write(reg.anio, '-', reg.mes, '-', reg.dia, ' | ');
      write(reg.monto:0:2);
      writeln();

    End;

  // Cerrar el archivo
  close(archivo);
End;


Var 
  j, n, k: integer;
  archivo: file Of regMaestro;
  reg: regMaestro;
  codCliente, anio, mes: integer;
  registros: array[1..MAX_REGISTROS] Of regMaestro;
  aux: regMaestro;
Begin
  Randomize();
  // Generar registros aleatorios
  n := random(MAX_REGISTROS) + 1;
  // cantidad aleatoria de registros entre 1 y MAX_REGISTROS
  For j := 1 To n Do
    Begin
      // Generar códigos aleatorios
      codCliente := random(MAX_COD_CLIENTE) + 1;
      // código de localidad aleatorio entre 1 y MAX_COD_CLIENTE
      anio := random(24) + MAX_ANIO-23;
      // código de cepa aleatorio entre MAX_ANIO-23 y MAX_ANIO
      mes := random(MAX_MES) + 1;
      // código de cepa aleatorio entre 1 y MAX_MES

      // Verificar si el registro ya existe
      While True Do
        Begin
          If (j = 1) Or ((registros[j-1].cl.codCliente <> codCliente) Or (registros[j-1]
             .anio <> anio) Or (registros[j-1].mes <> mes)) Then
            Begin
              // El registro no existe, crearlo
              reg.cl.codCliente := codCliente;
              reg.anio := anio;
              reg.mes := mes;
              reg.dia := random(28)+1;
              reg.monto := random()*950+50;
              reg.cl.nombre := 'Nombre' + intToStr(j);
              reg.cl.apellido := 'Apellido' + intToStr(j);
              registros[j] := reg;
              break;
            End
          Else
            Begin
              // El registro ya existe, generar nuevos códigos
              codCliente := random(MAX_COD_CLIENTE) + 1;
              anio := random(MAX_ANIO) + 1;
              mes := random(MAX_MES) + 1;
            End;
        End;
    End;

  // Ordenar los registros por código de cliente, año y mes
  For j := 1 To n-1 Do
    Begin
      For k := j+1 To n Do
        Begin
          If (registros[j].cl.codCliente > registros[k].cl.codCliente) Or
             ((registros[j].cl.codCliente = registros[k].cl.codCliente) And ((
             registros[j].anio > registros[k].anio) Or ((registros[j].anio = registros[k
             ].anio) And (registros[j].mes > registros[k].mes)))) Then
            Begin
              aux := registros[j];
              registros[j] := registros[k];
              registros[k] := aux;
            End;
        End;
    End;

  // Guardar los registros en el archivo
  assign(archivo, 'maestro.dat');
  rewrite(archivo);
  For j := 1 To n Do
    Begin
      If ((j=1) Or (registros[j].cl.codCliente <> registros[j-1].cl.codCliente) Or
         (registros[j].anio <> registros[j-1].anio) Or (registros[j].mes<>registros[j-1].
         mes))Then
        Write(archivo, registros[j]);
    End;
  close(archivo);

  ImprimirArchivo('maestro.dat');
End.
