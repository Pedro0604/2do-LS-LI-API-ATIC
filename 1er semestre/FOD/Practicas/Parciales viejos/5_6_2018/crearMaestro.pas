
Program CrearArchivos;

Uses 
sysutils;

Const 
  MAX_REGISTROS = 100000;
  MAX_ANIO = 2023;
  MAX_MES = 12;
  MAX_DIA = 28;
  MAX_ID_USUARIO = 100;


Type 
  regMaestro = Record
    anio, mes, dia, idUsu: integer;
    tiempoAcc: real;
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
      write('idUsuario: ', reg.idUsu,' | ');
      write(reg.anio, '-', reg.mes, '-', reg.dia, ' | ');
      write('Tiempo de acceso: ', reg.tiempoAcc:0:2);
      writeln();

    End;

  // Cerrar el archivo
  close(archivo);
End;


Var 
  j, n, k: longint;
  archivo: file Of regMaestro;
  reg: regMaestro;
  idUsu, anio, mes, dia: integer;
  registros: array[1..MAX_REGISTROS] Of regMaestro;
  aux: regMaestro;
Begin
  Randomize();
  // Generar registros aleatorios
  n := MAX_REGISTROS;
  // cantidad aleatoria de registros entre 1 y MAX_REGISTROS
  For j := 1 To n Do
    Begin
      // Generar códigos aleatorios
      idUsu := random(MAX_ID_USUARIO) + 1;
      // código de localidad aleatorio entre 1 y MAX_ID_USUARIO
      anio := random(24) + MAX_ANIO-23;
      // código de cepa aleatorio entre MAX_ANIO-23 y MAX_ANIO
      mes := random(MAX_MES) + 1;
      // código de cepa aleatorio entre 1 y MAX_MES
      dia := random(MAX_DIA) + 1;

      // Verificar si el registro ya existe
      While True Do
        Begin
          If ((j = 1) Or ((registros[j-1].idUsu <> idUsu) Or (registros[j-1].anio <> anio)
             Or (registros[j-1].mes <> mes)Or((registros[j-1].dia <> dia))))Then
            Begin
              // El registro no existe, crearlo
              reg.idUsu := idUsu;
              reg.anio := anio;
              reg.mes := mes;
              reg.dia := dia;
              reg.tiempoAcc := random()*100+50;
              registros[j] := reg;
              break;
            End
          Else
            Begin
              // El registro ya existe, generar nuevos códigos
              idUsu := random(MAX_ID_USUARIO) + 1;
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
          If ((registros[j].anio > registros[k].anio) Or
             ((registros[j].anio = registros[k].anio) And ((
             registros[j].mes > registros[k].mes) Or ((registros[j].mes = registros[k
             ].mes) And ((registros[j].dia > registros[k].dia)Or(registros[j].dia =
             registros[k].dia)And(registros[j].idUsu > registros[k].idUsu)))))) Then
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
      If ((j=1) Or (registros[j].idUsu <> registros[j-1].idUsu) Or
         (registros[j].anio <> registros[j-1].anio) Or (registros[j].mes<>registros[j-1].
         mes)Or(registros[j].dia<>registros[j-1].dia))Then
        Write(archivo, registros[j]);
    End;
  close(archivo);

  ImprimirArchivo('maestro.dat');
End.
