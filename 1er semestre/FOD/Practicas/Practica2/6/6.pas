
Program seis;

Uses 
sysutils;

Const 
  VALOR_ALTO = 32000;
  CANT_DETALLES = 10;

Type 
  regDetalle = Record
    codigoLocalidad: integer;
    codigoCepa: integer;
    casosActivos: integer;
    casosNuevos: integer;
    casosRecuperados: integer;
    casosFallecidos: integer;
  End;

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

  file_maestro = file Of regMaestro;
  file_detalle = file Of regDetalle;

  arrDetalle = array [1..CANT_DETALLES] Of file_detalle;
  arrRegDetalle = array [1..CANT_DETALLES] Of regDetalle;

Procedure imprimirRegistroMaestro(registro: regMaestro);
Begin
  writeln('Código Localidad: ', registro.codigoLocalidad, '; Nombre Localidad: ',
          registro.nombreLocalidad, '; Código Cepa: ', registro.codigoCepa,
          '; Nombre Cepa: ', registro.nombreCepa, '; Casos Activos: ', registro.
          casosActivos, '; Casos Nuevos: ', registro.casosNuevos, '; Casos Recuperados: ',
          registro.casosRecuperados, '; Casos Fallecidos: ', registro.casosFallecidos);
End;

Procedure imprimirMaestro(Var maestro: file_maestro);

Var 
  regM: regMaestro;
Begin
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      read(maestro, regM);
      imprimirRegistroMaestro(regM);
    End;
  writeln();
  Close(maestro);
End;

Procedure leer(Var detalle: file_detalle; Var regD: regDetalle);
Begin
  If Not EOF(detalle)Then
    read(detalle, regD)
  Else
    regD.codigoLocalidad := VALOR_ALTO;
End;

Procedure minimo(Var detalles: arrDetalle; Var arrRegD: arrRegDetalle; Var min: regDetalle
);

Var 
  i,pos: integer;
Begin
  min.codigoLocalidad := VALOR_ALTO;
  min.codigoCepa := VALOR_ALTO;
  For i:=1 To CANT_DETALLES Do
    Begin
      If (((arrRegD[i].codigoLocalidad=min.codigoLocalidad) And (arrRegD[i].codigoCepa <
         min.codigoCepa))Or(arrRegD[i].codigoLocalidad<min.codigoLocalidad))Then
        Begin
          pos := i;
          min := arrRegD[i];
        End;
    End;
  If (min.codigoLocalidad<>VALOR_ALTO)Then
    leer(detalles[pos], arrRegD[pos]);
End;


Procedure actualizarMaestro(Var maestro: file_maestro; Var detalles: arrDetalle);

Var 
  i: integer;
  aux: regMaestro;
  min: regDetalle;
  arrRegD: arrRegDetalle;
Begin
  Reset(maestro);
  For i:=1 To CANT_DETALLES Do
    Begin
      Reset(detalles[i]);
      leer(detalles[i], arrRegD[i]);
    End;
  minimo(detalles, arrRegD, min);

  While (min.codigoLocalidad<>VALOR_ALTO) Do
    Begin
      read(maestro, aux);
      While (min.codigoLocalidad<>aux.codigoLocalidad) Do
        Begin
          read(maestro, aux);
        End;
      While (min.codigoCepa <> aux.codigoCepa) Do
        Begin
          read(maestro, aux);
        End;
      aux.casosFallecidos := aux.casosFallecidos + min.casosFallecidos;
      aux.casosRecuperados := aux.casosRecuperados + min.casosRecuperados;
      aux.casosActivos := min.casosActivos;
      aux.casosNuevos := min.casosNuevos;
      Seek(maestro, FilePos(maestro)-1);
      write(maestro, aux);
      minimo(detalles, arrRegD, min);
      Seek(maestro, FilePos(maestro)-1);
    End;
  Close(maestro);
  For i:=1 To CANT_DETALLES Do
    Begin
      Close(detalles[i]);
    End;
End;

Procedure informarMayores50(Var maestro:file_maestro);

Var 
  regM: regMaestro;
Begin
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      read(maestro, regM);
      If (regM.casosActivos>50)Then
        imprimirRegistroMaestro(regM);
    End;
  Close(maestro);
End;


Var 
  maestro: file_maestro;
  detalles : arrDetalle;
  i : integer;
Begin
  Assign(maestro, 'maestro.dat');
  For i:=1 To CANT_DETALLES Do
    Begin
      Assign(detalles[i], './Detalles/detalle' + IntToStr(i) + '.det');
    End;
  actualizarMaestro(maestro, detalles);
  informarMayores50(maestro);
End.
