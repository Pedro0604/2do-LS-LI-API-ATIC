
Program Parcial_11_7_2017;

Uses 
sysutils;

Const 
  VALOR_ALTO = 'zzzzzzzzzzzz';
  CANT_ARC = 20;

Type 
  alumno = Record
    dni : string;
    codCarr: integer;
    montoTotal: real;
  End;

  pago = Record
    dni : string;
    codCarr: integer;
    montoCuota: real;
  End;

  file_alumnos = file Of alumno;

  file_pagos = file Of pago;
  arrArcPagos = array [1..CANT_ARC] Of file_pagos;
  arrRegPagos = array [1..CANT_ARC] Of pago;

Procedure leer(Var arc_pagos: file_pagos; Var p:pago);
Begin
  If (Not EOF(arc_pagos))Then
    read(arc_pagos, p)
  Else
    p.dni := VALOR_ALTO;
End;

Procedure minimo(Var pagos: arrArcPagos; Var regsPagos: arrRegPagos; Var min: pago);

Var 
  i, pos: integer;
Begin
  min.dni := VALOR_ALTO;
  For i:=1 To CANT_ARC Do
    Begin
      If ((regsPagos[i].dni<min.dni)Or((regsPagos[i].dni=min.dni)And(regsPagos[i].codCarr<
         min.codCarr)))Then
        Begin
          min := regsPagos[i];
          pos := i;
        End;
    End;
  If (min.dni<>VALOR_ALTO)Then
    leer(pagos[pos], regsPagos[pos]);
End;

Procedure actualizarArcAlumnos(Var arc_alumnos: file_alumnos; Var pagos: arrArcPagos);

Var 
  min: pago;
  al: alumno;
  i: integer;
  regsPagos: arrRegPagos;
Begin
  Reset(arc_alumnos);
  For i:=1 To CANT_ARC Do
    Begin
      Reset(pagos[i]);
      leer(pagos[i], regsPagos[i]);
    End;
  minimo(pagos, regsPagos, min);
  While (min.dni<>VALOR_ALTO) Do
    Begin
      read(arc_alumnos, al);
      While (min.dni<>al.dni) Do
        read(arc_alumnos, al);

      While ((min.dni = al.dni)And(min.codCarr=al.codCarr)) Do
        Begin
          al.montoTotal := al.montoTotal + min.montoCuota;
          minimo(pagos, regsPagos, min);
        End;

      seek(arc_alumnos, FilePos(arc_alumnos)-1);
      write(arc_alumnos, al);
    End;

  Close(arc_alumnos);
  For i:=1 To CANT_ARC Do
    Close(pagos[i]);
End;

Procedure ImprimirArchivo(nombreArchivo: String);

Var 
  archivo: file Of alumno;
  reg: alumno;

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
  arc_alumnos : file_alumnos;
  pagos : arrArcPagos;
  i: integer;
Begin
  Assign(arc_alumnos, 'alumnos.al');
  For i:=1 To CANT_ARC Do
    Assign(pagos[i], './Detalles/detalle' + intToStr(i) + '.det');
  ImprimirArchivo('alumnos.al');
  actualizarArcAlumnos(arc_alumnos, pagos);
  ImprimirArchivo('alumnos.al');
End.
