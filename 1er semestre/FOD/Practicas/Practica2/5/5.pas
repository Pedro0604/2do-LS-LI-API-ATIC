
Program cinco;

Uses 
SysUtils, crt;

Const 
  CANT_DELEGACIONES = 10;
  VALOR_ALTO = 32000;

Type 

  fecha = Record
    dia, mes, anio, hora, minuto: integer;
  End;

  nacimiento = Record
    nroPartida : integer;
    nombre, apellido, direccion: string;
    matriculaNacim : integer;
    nombreM, apellidoM, dniM, nombreP, apellidoP, dniP: string;
  End;

  fallecimiento = Record
    nroPartida: integer;
    dni, nombre, apellido: string;
    matriculaFall: integer;
    f: fecha;
    lugar: string;
  End;


  file_nacimiento = file Of nacimiento;
  file_fallecimiento = file Of fallecimiento;

  arrNaciemientos = array [1..CANT_DELEGACIONES] Of file_nacimiento;
  arrRegNacimientos = array [1..CANT_DELEGACIONES] Of nacimiento;
  arrFallecimientos = array [1..CANT_DELEGACIONES] Of file_fallecimiento;
  arrRegFallecimientos = array [1..CANT_DELEGACIONES] Of fallecimiento;


  regMaestro = Record
    nroPartida : integer;
    nombre, apellido, direccion: string;
    matriculaNacim : integer;
    nombreM, apellidoM, dniM, nombreP, apellidoP, dniP: string;
    murio: boolean;
    matriculaFall: integer;
    f: fecha;
    lugar: string;
  End;

  file_maestro = file Of regMaestro;

Procedure imprimirRegMaestro(regM: regMaestro);

Var 
  st: string;
Begin
  With regM Do
    Begin
      st := 'Nro Partida: ' + intToStr(nroPartida) + ' - Nombre: ' + nombre +
            ' - Apellido ' + apellido + ' - Direccion: ' + direccion +
            ' - Matricula nacimiento: ' + intToStr(matriculaNacim) +
            ' - Nombre madre: ' + nombreM + ' - Apellido madre: ' + apellidoM +
            ' - DNI madre ' + dniM + ' - Nombre padre: ' + nombreP + ' - Apellido padre:';
      write(st);
      st := ' ' + apellidoP + ' - DNI padre ' + dniP + ' - Muerto: ';
      If (murio)Then
        st := st + 'Si - Matricula fallecimiento: ' + intToStr(matriculaFall) +
              ' - Fecha: ' + intToStr(f.hora) + ':' + intToStr(f.minuto) + ' ' +
              intToStr(f.dia) + '/' +intToStr(f.mes) + '/' + intToStr(f.anio) +
              ' - Lugar de fallecimiento: ' + lugar + '.'
      Else
        st := st + 'No.';
      writeln(st);
      writeln;
    End;
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
  Close(maestro);
End;

Procedure leerNacimiento(Var nac: file_nacimiento; Var regNac: nacimiento);
Begin
  If (Not EOF(nac))Then
    read(nac, regNac)
  Else
    regNac.nroPartida := VALOR_ALTO;
End;

Procedure leerFallecimiento(Var fall: file_fallecimiento; Var regFall: fallecimiento);
Begin
  If (Not EOF(fall))Then
    read(fall, regFall)
  Else
    regFall.nroPartida := VALOR_ALTO;
End;


Procedure minimoNacimientos(Var arrNac: arrNaciemientos; Var arrRegNac: arrRegNacimientos;
                            Var min:nacimiento);

Var 
  i, pos: integer;
Begin
  min.nroPartida := VALOR_ALTO;
  For i:=1 To CANT_DELEGACIONES Do
    Begin
      If (arrRegNac[i].nroPartida<min.nroPartida)Then
        Begin
          pos := i;
          min := arrRegNac[i];
        End;
    End;
  If (min.nroPartida<>VALOR_ALTO)Then
    leerNacimiento(arrNac[pos], arrRegNac[pos]);
End;

Procedure minimoFallecimientos(Var arrFall: arrFallecimientos; Var arrRegFall:
                               arrRegFallecimientos; Var min:fallecimiento);

Var 
  i, pos: integer;
Begin
  min.nroPartida := VALOR_ALTO;
  For i:=1 To CANT_DELEGACIONES Do
    Begin
      If (arrRegFall[i].nroPartida<min.nroPartida)Then
        Begin
          pos := i;
          min := arrRegFall[i];
        End;
    End;
  If (min.nroPartida<>VALOR_ALTO)Then
    leerFallecimiento(arrFall[pos], arrRegFall[pos]);
End;

Procedure copiarInfoNac(minNac: nacimiento; Var aux: regMaestro);
Begin
  aux.nroPartida := minNac.nroPartida;
  aux.nombre := minNac.nombre;
  aux.apellido := minNac.apellido;
  aux.direccion := minNac.direccion;
  aux.matriculaNacim := minNac.matriculaNacim;
  aux.nombreM := minNac.nombreM;
  aux.apellidoM := minNac.apellidoM;
  aux.dniM := minNac.dniM;
  aux.nombreP := minNac.nombreP;
  aux.apellidoP := minNac.apellidoP;
  aux.dniP := minNac.dniP;
End;

Procedure copiarInfoFall(minFall: fallecimiento; Var aux: regMaestro; murio:boolean);
Begin
  aux.murio := murio;
  If (murio)Then
    Begin
      aux.matriculaFall := minFall.matriculaFall;
      aux.f := minFall.f;
      aux.lugar := minFall.lugar;
    End
  Else
    Begin
      aux.matriculaFall := -1;
      aux.f.hora := -1;
      aux.f.minuto := -1;
      aux.f.dia := -1;
      aux.f.mes := -1;
      aux.f.anio := -1;
      aux.lugar := '-';
    End;
End;

Procedure crearMaestro(Var maestro: file_maestro; Var arrNac: arrNaciemientos; Var
                       arrFall
                       :arrFallecimientos);

Var 
  arrRegNac: arrRegNacimientos;
  arrRegFall: arrRegFallecimientos;
  minNac: nacimiento;
  minFall: fallecimiento;
  aux: regMaestro;
  i: integer;
Begin
  Rewrite(maestro);
  For i := 1 To CANT_DELEGACIONES Do
    Begin
      Reset(arrNac[i]);
      Reset(arrFall[i]);
      leerNacimiento(arrNac[i], arrRegNac[i]);
      leerFallecimiento(arrFall[i], arrRegFall[i]);
    End;
  minimoNacimientos(arrNac, arrRegNac, minNac);
  minimoFallecimientos(arrFall, arrRegFall, minFall);

  While (minNac.nroPartida<>VALOR_ALTO) Do
    Begin
      copiarInfoNac(minNac, aux);
      If (minNac.nroPartida = minFall.nroPartida)Then
        Begin
          copiarInfoFall(minFall, aux, true);
          minimoFallecimientos(arrFall, arrRegFall, minFall);
        End
      Else
        copiarInfoFall(minFall, aux, false);
      write(maestro, aux);
      minimoNacimientos(arrNac, arrRegNac, minNac);
    End;
  Close(maestro);
  For i := 1 To CANT_DELEGACIONES Do
    Begin
      Close(arrNac[i]);
      Close(arrFall[i]);
    End;
End;

Procedure exportarTxt (Var maestro: file_maestro);

Var 
  regM: regMaestro;
  txt: Text;
  st: string;
Begin
  Assign(txt, 'info.txt');
  Rewrite(txt);
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      read(maestro, regM);
      With regM Do
        Begin
          st := 'Nro Partida: ' + intToStr(nroPartida) + ' - Nombre: '
                + nombre + ' - Apellido ' + apellido + ' - Direccion: ' +
                direccion + ' - Matricula nacimiento: ' + intToStr(matriculaNacim) +
                ' - Nombre madre: ' + nombreM + ' - Apellido madre: ' + apellidoM +
                ' - DNI madre ' + dniM + ' - Nombre padre: ' + nombreP +
                ' - Apellido padre:';
          write(txt, st);
          st := ' ' + apellidoP + ' - DNI padre ' + dniP + ' - Muerto: ';
          If (murio)Then
            st := st + 'Si - Matricula fallecimiento: ' + intToStr(matriculaFall) +
                  ' - Fecha: ' + intToStr(f.hora) + ':' + intToStr(f.minuto) + ' ' +
                  intToStr(f.dia) + '/' +intToStr(f.mes) + '/' + intToStr(f.anio) +
                  ' - Lugar de fallecimiento: ' + lugar + '.'
          Else
            st := st + 'No.';
          writeln(txt, st);
        End;
    End;
  Close(txt);
End;

Var 
  maestro : file_maestro;
  arrNac : arrNaciemientos;
  arrFall : arrFallecimientos;
  i: integer;
Begin
  Assign(maestro, 'maestro.dat');
  For i:=1 To CANT_DELEGACIONES Do
    Begin
      Assign(arrNac[i], './Nacimientos/nacimientos' + intToStr(i) + '.nacim');
      Assign(arrFall[i], './Fallecimientos/fallecimientos' + intToStr(i) + '.fall');
    End;
  crearMaestro(maestro, arrNac, arrFall);
  exportarTxt(maestro);
End.
