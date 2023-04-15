
Program once;

Uses 
sysutils;

Const 
  VALOR_ALTO = 'zzzzzz';

Type 
  regMaestro = Record
    nombreProvincia: string;
    cantidadAlfabetizados: integer;
    totalEncuestados: integer;
  End;

  regDetalle = Record
    nombreProvincia: string;
    codigoLocalidad: integer;
    cantidadAlfabetizados: integer;
    cantidadEncuestados: integer;
  End;

  file_maestro = file Of regMaestro;
  file_detalle = file Of regDetalle;

Procedure imprimirregMaestro(registro: regMaestro);
Begin
  write('Nombre provincia: ', registro.nombreProvincia:15, ' | ');
  write('Personas alfabetizadas: ', registro.cantidadAlfabetizados:5, ' | ');
  writeln('Total encuestados: ', registro.totalEncuestados:5);
End;

Procedure imprimirMaestro(Var maestro: file_maestro);

Var 
  regM: regMaestro;
Begin
  While Not EOF(maestro) Do
    Begin
      read(maestro, regM);
      imprimirregMaestro(regM);
    End;
End;

Procedure leer(Var detalle: file_detalle; Var regD: regDetalle);
Begin
  If Not EOF(detalle)Then
    read(detalle, regD)
  Else
    regD.nombreProvincia := VALOR_ALTO;
End;

Procedure minimo(Var detalle1, detalle2: file_detalle; Var regD1, regD2, min: regDetalle;)
;
Begin
  If (regD1.nombreProvincia<regD2.nombreProvincia)Then
    Begin
      min := regD1;
      read(detalle1, regD1);
    End
  Else
    Begin
      min := regD2;
      read(detalle2, regD2);
    End;
End;

Var 
  maestro: file_maestro;
  detalle1, detalle2: file_detalle;
  regD1, regD2, min: regDetalle;
  regM: regMaestro;
Begin
  Assign(maestro, 'maestro.dat');
  Assign(detalle1, 'detalle1.det');
  Assign(detalle2, 'detalle2.det');
  Reset(maestro);
  Rewrite(detalle1);
  Rewrite(detalle2);
  read(maestro, regM);
  leer(detalle1, regD1);
  leer(detalle2, regD2);
  minimo(detalle1, detalle2, regD1, regD2, min);
  While (min.nombreProvincia<>VALOR_ALTO) Do
    Begin
      While (min.nombreProvincia<>regM.nombreProvincia) Do
        Begin
          read(maestro, regM);
        End;
      While (min.nombreProvincia=regM.nombreProvincia) Do
        Begin
          regM.cantidadAlfabetizados := regM.cantidadAlfabetizados + min.
                                        cantidadAlfabetizados;
          regM.totalEncuestados := regM.totalEncuestados + min.cantidadEncuestados;
          minimo(detalle1, detalle2, regD1, regD2, min);
        End;
      Seek(maestro, FilePos(maestro)-1);
      write(maestro, regM);
    End;
  Close(maestro);
  Close(detalle1);
  Close(detalle2);
End;
