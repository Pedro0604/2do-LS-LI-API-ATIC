
Program ocho;

Uses 
sysutils;

Const 
  VALOR_ALTO = 32000;

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

  file_maestro = file Of regMaestro;

Function clienteToString(cl: cliente): string;
Begin
  clienteToString := 'Codigo cliente: ' + intToStr(cl.codCliente) + ' - Nombre: ' + cl.
                     nombre + ' - Apellido: ' + cl.apellido;
End;

Procedure leer(Var maestro: file_maestro; Var regM: regMaestro);
Begin
  If Not EOF(maestro)Then
    read(maestro, regM)
  Else
    regM.cl.codCliente := VALOR_ALTO;
End;

Var 
  maestro: file_maestro;
  regM: regMaestro;
  totalMes, totalAnio, totalCliente, totalEmpresa: real;
  regMAct: regMaestro;
Begin
  Assign(maestro, 'maestro.dat');
  Reset(maestro);
  leer(maestro, regM);
  totalEmpresa := 0;
  writeln('Empresa pepito');
  While (regM.cl.codCliente<>VALOR_ALTO) Do
    Begin
      regMAct := regM;
      writeln('    '+clienteToString(regMAct.cl));
      totalCliente := 0;
      While (regMAct.cl.codCliente=regM.cl.CodCliente) Do
        Begin
          writeln('        Anio ', regM.anio);
          regMAct.anio := regM.anio;
          totalAnio := 0;
          While ((regMAct.cl.codCliente=regM.cl.CodCliente)And(regMAct.anio=regM.anio)) Do
            Begin
              writeln('            Mes ', regM.mes);
              regMAct.mes := regM.mes;
              totalMes := 0;
              While ((regMAct.cl.codCliente=regM.cl.CodCliente)And(regMAct.anio=regM.anio)
                    And (regMAct.mes=regM.mes)) Do
                Begin
                  writeln('                Monto: ', regM.monto:2:2);
                  totalMes := totalMes + regM.monto;
                  leer(maestro, regM);
                End;
              writeln('            En el mes ', regMAct.mes,
                      ' el cliente hizo un gasto de ',
                      totalMes:2:2, ' pesos.');
              totalAnio := totalAnio + totalMes;
            End;
          writeln('        En el anio ', regMAct.anio, ' el cliente hizo un gasto de ',
                  totalAnio:2:2, ' pesos.');
          totalCliente := totalCliente + totalAnio;
        End;
      writeln('    El cliente tuvo un gasto total de ', totalCliente:2:2, ' pesos.');
      totalEmpresa := totalEmpresa + totalAnio;
    End;
  writeln('La empresa tuvo un ingreso total de ', totalEmpresa:2:2, ' pesos.');
  Close(maestro);
End.
