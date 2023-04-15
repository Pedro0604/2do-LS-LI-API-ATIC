
Program dos;

Const 
  VALOR_ALTO = 32000;

Type 
  alumno = Record
    codalumno: integer;
    ape, nom: string;
    cursadasaprov, finalesaprov: integer;
  End;

  regDetalle = Record
    codalumno: integer;
    info: 0..1;
  End;

  file_detalle = file Of regDetalle;
  file_maestro = file Of alumno;

Procedure imprimirAlumno(a: alumno);
Begin
  write('codalumno: ');
  write(a.codalumno);
  write(' - ape: ' + a.ape + ' - nom: ' + a.nom
        + ' - cursadasaprov: ');
  write(a.cursadasaprov);
  write(' - finalesaprov: ');
  writeln(a.finalesaprov);
  writeln();
End;

Procedure imprimirMaestro(Var maestro: file_maestro);

Var 
  a: alumno;
Begin
  writeln('Maestro: ');
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      read(maestro, a);
      imprimirAlumno(a);
    End;
  Close(maestro);
End;

Procedure imprimirRegDetalle(regD: regDetalle);
Begin
  write('codalumno: ');
  write(regD.codalumno);
  write(' - Aprobo cursada: ');
  If (regD.info=0)Then
    write('Sí')
  Else
    write('No');
  write(' - Aprobo final: ');
  If (regD.info=1)Then
    writeln('Si')
  Else
    writeln('No');
  writeln();
End;

Procedure imprimirDetalle(Var detalle: file_detalle);

Var 
  regD: regDetalle;
Begin
  writeln('Detalle: ');
  Reset(detalle);
  While Not EOF(detalle) Do
    Begin
      read(detalle, regD);
      imprimirRegDetalle(regD);
    End;
  Close(detalle);
End;

Procedure leer(Var detalle: file_detalle; Var regD: regDetalle);
Begin
  If Not EOF(detalle)Then
    read(detalle, regD)
  Else
    regD.codalumno := VALOR_ALTO;
End;

Procedure actualizacionMaestroDetalle(Var maestro: file_maestro; Var detalle: file_detalle
);

Var 
  regD, regDAct: regDetalle;
  a: alumno;
  cursadasaprov, finalesaprov: integer;
Begin
  Reset(maestro);
  Reset(detalle);
  leer(detalle, regD);
  While (regD.codalumno<>VALOR_ALTO) Do
    Begin
      cursadasaprov := 0;
      finalesaprov := 0;
      regDAct.codalumno := regD.codalumno;
      While (regDAct.codalumno=regD.codalumno) Do
        Begin
          If regD.info=0 Then
            cursadasaprov := cursadasaprov + 1;
          If regD.info=1 Then
            finalesaprov := finalesaprov + 1;
          leer(detalle, regD);
        End;
      read(maestro, a);
      While (a.codalumno<>regDAct.codalumno) Do
        Begin
          read(maestro, a);
        End;
      Seek(maestro, FilePos(maestro)-1);
      a.cursadasaprov := a.cursadasaprov + cursadasaprov;
      a.finalesaprov := a.finalesaprov + finalesaprov;
      write(maestro, a);
    End;
  Close(maestro);
  Close(detalle);
End;

Procedure exportarMaestro(Var maestro: file_maestro);

Var 
  a: alumno;
  txt: Text;
Begin
  Assign(txt, 'Alumnos.txt');
  Reset(maestro);
  Rewrite(txt);
  While Not EOF(maestro) Do
    Begin
      read(maestro, a);
      If (a.cursadasaprov>4)Then
        Begin
          writeln(txt,'codalumno: ', a.codalumno, ' - ape: ', a.ape, ' - nom: ', a.nom,
                  ' - cursadasaprov: ', a.cursadasaprov, ' - finalesaprov: ', a.
                  finalesaprov);
        End;
    End;
  Close(maestro);
  Close(txt);
End;

Var 
  maestro: file_maestro;
  detalle: file_detalle;
Begin
  Assign(maestro, 'alumnos.dat');
  Assign(detalle, 'alumnos_detalle.dat');
  imprimirMaestro(maestro);
  imprimirDetalle(detalle);
  actualizacionMaestroDetalle(maestro, detalle);
  imprimirMaestro(maestro);
  exportarMaestro(maestro);
End.
