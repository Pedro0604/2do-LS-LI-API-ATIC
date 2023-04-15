
Program cuatro;

Uses 
SysUtils;

Const 
  CANT_DETALLES = 5;
  VALOR_ALTO = 32000;

Type 
  regDetalle = Record
    cod_usuario : integer;
    fecha: integer;
    tiempo_sesion: real;
  End;

  regMaestro = Record
    cod_usuario : integer;
    fecha: integer;
    tiempo_total_de_sesiones_abiertas: real;
  End;

  file_detalle = file Of regDetalle;

  file_maestro = file Of regMaestro;

  arrDetalle = array [1..CANT_DETALLES] Of file_detalle;
  arrRegDetalle = array [1..CANT_DETALLES] Of regDetalle;


Procedure imprimirRegMaestro(regM: regMaestro);

Var 
  st: string;
Begin
  st := 'Codigo de usuario: %-2d - Dia de la semana: %-1d -';
  st := st + ' Tiempo total de sesiones abiertas: %-6.2f';
  writeln(Format(st,[regM.cod_usuario,regM.fecha,regM.tiempo_total_de_sesiones_abiertas]))
  ;
End;

Procedure imprimirMaestro(Var maestro: file_maestro);

Var 
  regM: regMaestro;
Begin
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      read(maestro, regM);
      imprimirRegMaestro(regM);
    End;
  writeln();
  Close(maestro);
End;


Procedure assignDetalles(Var detalles: arrDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Begin
      Assign(detalles[i],'./Detalles/detalle' + IntToStr(i) + '.det');
    End;
End;

Procedure resetDetalles(Var detalles: arrDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Reset(detalles[i]);
End;

Procedure closeDetalles(Var detalles: arrDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Close(detalles[i]);
End;

Procedure leer(Var detalle: file_detalle; Var regD: regDetalle);
Begin
  If Not EOF(detalle)Then
    read(detalle, regD)
  Else
    regD.cod_usuario := VALOR_ALTO;
End;

Procedure leerDetalles(Var detalles: arrDetalle; Var arrRegD: arrRegDetalle);

Var 
  i: integer;
Begin
  For i:=1 To CANT_DETALLES Do
    Begin
      leer(detalles[i], arrRegD[i]);
    End;
End;

Procedure minimo(Var detalles: arrDetalle; Var arrRegD:arrRegDetalle; Var min: regDetalle)
;

Var 
  i, pos: integer;
Begin
  min.cod_usuario := VALOR_ALTO;
  min.fecha := VALOR_ALTO;
  For i:=1 To CANT_DETALLES Do
    Begin
      If (((arrRegD[i].cod_usuario=min.cod_usuario)And (arrRegD[i].fecha < min.fecha)) Or
         (arrRegD[i].cod_usuario<min.cod_usuario))Then
        Begin
          pos := i;
          min.cod_usuario := arrRegD[i].cod_usuario;
          min.fecha := arrRegD[i].fecha;
          min.tiempo_sesion := arrRegD[i].tiempo_sesion;
        End;
    End;
  If (min.cod_usuario<>VALOR_ALTO)Then
    leer(detalles[pos], arrRegD[pos]);
End;

Procedure crearMaestro(Var maestro: file_maestro; Var detalles: arrDetalle);

Var 
  arrRegD: arrRegDetalle;
  min: regDetalle;
  aux: regMaestro;
  totalTiempoSesiones: real;
Begin
  Rewrite(maestro);
  resetDetalles(detalles);
  leerDetalles(detalles, arrRegD);
  minimo(detalles, arrRegD, min);
  While (min.cod_usuario<>VALOR_ALTO) Do
    Begin
      aux.cod_usuario := min.cod_usuario;
      aux.fecha := min.fecha;
      totalTiempoSesiones := 0;
      While ((min.cod_usuario = aux.cod_usuario) And (min.fecha = aux.fecha)) Do
        Begin
          totalTiempoSesiones := totalTiempoSesiones + min.tiempo_sesion;
          minimo(detalles, arrRegD, min);
        End;
      aux.tiempo_total_de_sesiones_abiertas := totalTiempoSesiones;
      write(maestro, aux);
    End;
  Close(maestro);
  closeDetalles(detalles);
End;

Var 
  detalles: arrDetalle;
  maestro: file_maestro;
Begin
  Assign(maestro, './var/log/maestro.log');
  assignDetalles(detalles);
  crearMaestro(maestro, detalles);
  imprimirMaestro(maestro);
End.
