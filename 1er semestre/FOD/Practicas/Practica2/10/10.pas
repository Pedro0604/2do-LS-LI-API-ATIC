
Program diez;

Uses 
sysutils;

Const 
  VALOR_ALTO = 32000;
  CANT_CATEGORIAS = 15;

Type 
  empleado = Record
    departamento: integer;
    division: integer;
    numeroEmpleado: integer;
    categoria: integer;
    horasExtras: integer;
  End;

  file_empleado = file Of empleado;

  arrValoresDeHora = array [1..CANT_CATEGORIAS] Of real;

Procedure cargarArrayValoresDeHora(Var vh:arrValoresDeHora);

Var 
  txt: Text;
  m: real;
  c: integer;
Begin
  Assign(txt, 'ValoresDeHora.txt');
  Reset(txt);
  While Not EOF(txt) Do
    Begin
      readln(txt, c, m);
      vh[c] := m;
    End;
  Close(txt);
End;

Procedure leer(Var empleados: file_empleado; Var e: empleado);
Begin
  If Not EOF(empleados)Then
    read(empleados, e)
  Else
    e.departamento := VALOR_ALTO;
End;


Function getMonto(e:empleado; vh:arrValoresDeHora): real;
Begin
  getMonto := e.horasExtras*vh[e.categoria];
End;

Var 
  empleados: file_empleado;
  e, eAct: empleado;
  hsTotales, hsDep, hsDiv: integer;
  formato: string;
  montoTotal, montoDep, montoDiv: real;
  vh: arrValoresDeHora;
Begin
  cargarArrayValoresDeHora(vh);
  formato := '        %8d | %8d | %8.2f | %8d ';
  Assign(empleados, 'empleados.emp');
  Reset(empleados);
  leer(empleados, e);
  montoTotal := 0;
  hsTotales := 0;
  While (e.departamento<>VALOR_ALTO) Do
    Begin
      eAct := e;
      hsDep := 0;
      montoDep := 0;
      writeln('Departamento: ', e.departamento);
      While (e.departamento=eAct.departamento) Do
        Begin
          eAct.division := e.division;
          hsDiv := 0;
          montoDiv := 0;
          writeln('    Division: ', e.division);
          writeln(Format('        %8s | %8s | %8s | %8s ', ['Nro emp', 'Total hs',
                  'Monto', 'Category']));
          While ((e.departamento = eAct.departamento)And(e.division = eAct.division)
                ) Do
            Begin
              hsDiv := e.horasExtras;
              montoDiv := montoDiv + getMonto(e, vh);
              writeln(Format(formato, [e.numeroEmpleado, e.horasExtras, getMonto(e,
                      vh),e.categoria]));
              leer(empleados,e);
            End;
          hsDep := hsDep + hsDiv;
          montoDep := montoDep + montoDiv;
          writeln('    Total de horas division: ', hsDiv);
          writeln('    Monto total por division: ', montoDiv:2:2);
        End;
      hsTotales := hsTotales + hsDep;
      montoTotal := montoTotal + montoDep;
      writeln('Total de horas departamento: ', hsDep);
      writeln('Monto total por departamento: ', montoDep:2:2);
    End;
  writeln('Total de horas: ', hsTotales);
  writeln('Monto total: ', montoTotal:2:2);
  writeln('Promedio de valor de hora extra: ', (montoTotal/hsTotales): 2: 2);
  Close(empleados);
End.
