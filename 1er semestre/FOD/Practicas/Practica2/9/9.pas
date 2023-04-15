
Program nueve;

Uses 
sysutils;

Const 
  VALOR_ALTO = 32000;

Type 
  mesa = Record
    codProvincia, codLocalidad, nroMesa, cantVotos: integer;
  End;

  file_mesas = file Of mesa;

Procedure leer(Var mesas: file_mesas; Var regMesa: mesa);
Begin
  If Not EOF(mesas)Then
    read(mesas, regMesa)
  Else
    regMesa.codProvincia := VALOR_ALTO;
End;

Var 
  mesas: file_mesas;
  totalLocalidad, totalProvincia, totalVotos: integer;
  regMesa, mesaAct: mesa;
Begin
  Assign(mesas, 'mesas.votos');
  Reset(mesas);
  leer(mesas, regMesa);
  totalVotos := 0;
  While (regMesa.codProvincia<>VALOR_ALTO) Do
    Begin
      mesaAct := regMesa;
      writeln('Codigo Provincia ', mesaAct.codProvincia);
      writeln('  Cod loc      Total votos');
      totalProvincia := 0;
      While (mesaAct.codProvincia=regMesa.codProvincia) Do
        Begin
          totalLocalidad := 0;
          mesaAct.codLocalidad := regMesa.codLocalidad;
          While ((mesaAct.codProvincia=regMesa.codProvincia) And (mesaAct.codLocalidad=
                regMesa.codLocalidad)) Do
            Begin
              totalLocalidad := totalLocalidad + regMesa.cantVotos;
              leer(mesas, regMesa);
            End;
          totalProvincia := totalProvincia + totalLocalidad;
          writeln('  ', mesaAct.codLocalidad, '            ', totalLocalidad);
        End;
      totalVotos :=  totalVotos + totalProvincia;
      writeln('Total de votos provincia: ', totalProvincia);
    End;
  writeln('Total general de votos: ', totalVotos);
  Close(mesas);
End.
