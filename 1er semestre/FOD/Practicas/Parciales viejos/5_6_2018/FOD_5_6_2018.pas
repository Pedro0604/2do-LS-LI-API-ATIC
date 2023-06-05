
Program Parcial_5_6_2018;

Uses 
sysutils;

Const 
  VALOR_ALTO = 32000;

Type 
  acceso = Record
    anio, mes, dia, idUsu: integer;
    tiempoAcc: real;
  End;

  file_accesos = file Of acceso;

Procedure leer(Var arc_accesos:file_accesos; Var a: acceso);
Begin
  If (Not EOF(arc_accesos))Then
    read(arc_accesos, a)
  Else
    a.anio := VALOR_ALTO;
End;

Procedure corteDeControl(Var arc_accesos:file_accesos; anio: integer);

Var 
  totDia, totMes, totAnio: real;
  mes, dia: integer;
  a: acceso;
Begin
  Reset(arc_accesos);
  leer(arc_accesos, a);
  While ((a.anio<>VALOR_ALTO)And(a.anio <> anio)) Do
    Begin
      leer(arc_accesos, a);
    End;
  seek(arc_accesos, FIlePos(arc_accesos)-1);
  If (a.anio = anio)Then
    Begin
      writeln('Anio: ', a.anio);
      totAnio := 0;
      While (a.anio = anio) Do
        Begin
          writeln('   Mes: ', a.mes);
          totMes := 0;
          mes := a.mes;
          While ((a.anio = anio)And(a.mes = mes)) Do
            Begin
              writeln('      Dia: ', a.dia);
              totDia := 0;
              dia := a.dia;
              While ((a.anio = anio)And(a.mes = mes)And(a.dia = dia)) Do
                Begin
                  writeln('             idUsuario: ', a.idUsu,
                          ' Tiempo total de acceso en el dia ', dia, ' mes ', mes, ': ', a
                          .tiempoAcc:2:2);
                  totDia := totDia + a.tiempoAcc;
                  leer(arc_accesos, a);
                End;
              totMes := totMes + totDia;
              writeln('      Tiempo total acceso dia ', dia, ' mes ', mes, ': ', totDia:2:
                      2);
            End;
          totAnio := totAnio + totMes;
          writeln('   Tiempo total acceso mes ', mes, ': ', totMes:2:2);
        End;
      writeln('Tiempo total acceso anio: ', totAnio:2:2);
    End
  Else
    Begin
      writeln('###################');
      writeln('Anio no encontrado.');
      writeln('###################');
    End;
  Close(arc_accesos);
End;


Var 
  arc_accesos : file_accesos;
  anio : integer;
Begin
  Assign(arc_accesos, 'maestro.dat');
  writeln('Anio a usar: ');
  readln(anio);
  corteDeControl(arc_accesos, anio);
End.
