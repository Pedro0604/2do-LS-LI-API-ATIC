
Program Parcial_27_6_2017;

Uses 
sysutils;

Const 
  VALOR_ALTO = 'zzzzzzzzzzz';

Type 
  sistema = Record
    cantInst : integer;
    nombre, tipoLicencia : string;
    esCodAb : boolean;
  End;

  file_sistemas = file Of sistema;

Procedure cargarSistema(Var sist: sistema);
Begin
  With sist Do
    Begin
      writeln('Nombre: ');
      readln(nombre);
      writeln('Cant instalaciones: ');
      readln(cantInst);
    End;
End;

Procedure leer(Var arc_sist: file_sistemas; Var sist: sistema);
Begin
  If (Not EOF(arc_sist))Then
    read(arc_sist, sist)
  Else
    sist.nombre := VALOR_ALTO;
End;

Procedure alta(Var arc_sist: file_sistemas; sist: sistema);

Var 
  aux: sistema;
  pos: integer;
Begin
  Reset(arc_sist);
  leer(arc_sist, aux);
  If (aux.cantInst = 0)Then
    Begin
      seek(arc_sist, FileSize(arc_sist));
    End
  Else
    Begin
      pos := aux.cantInst * -1;
      seek(arc_sist, pos);
      read(arc_sist, aux);
      seek(arc_sist, 0);
      write(arc_sist, aux);
      seek(arc_sist, pos);
    End;
  write(arc_sist, sist);
  Close(arc_sist);
End;

Procedure baja(Var arc_sist: file_sistemas; nom: String);

Var 
  aux: sistema;
  posElim, enlCabec: integer;
Begin
  Reset(arc_sist);
  leer(arc_sist, aux);
  leer(arc_sist, aux);
  While ((aux.nombre <> VALOR_ALTO)And(aux.nombre<>nom)) Do
    Begin
      leer(arc_sist, aux);
    End;
  If (aux.nombre = nom)Then
    Begin
      posElim := FilePos(arc_sist)-1;
      seek(arc_sist, 0);
      read(arc_sist, aux);
      enlCabec := aux.cantInst;
      aux.cantInst := posElim * -1;
      seek(arc_sist, 0);
      write(arc_sist, aux);
      seek(arc_sist, posElim);
      aux.cantInst := enlCabec;
      write(arc_sist, aux);
    End
  Else
    writeln('ERROR #### El nombre ' + nom +
            ' no corresponde a ningun sistema operativo. #### ERROR');
  Close(arc_sist);
End;

Procedure imprimirSistemas(Var arc_sist: file_sistemas);

Var 
  sist: sistema;
Begin
  Reset(arc_sist);
  While (Not EOF(arc_sist)) Do
    Begin
      read(arc_sist, sist);
      writeln('Nombre: ' + sist.nombre + ' - Cant instalaciones: ' + intToStr(sist.
              cantInst));
    End;
  Close(arc_sist);
End;

Var 
  arc_sist: file_sistemas;
  sist: sistema;
  fin: boolean;
  c: char;
  nom: String;
Begin
  fin := false;

  Assign(arc_sist, 'sistemas.sist');

  writeln('Crear archivo?(S/N)');
  readln(c);
  If ((c = 's') Or (c='S'))Then
    Begin
      Rewrite(arc_sist);
      sist.cantInst := 0;
      sist.nombre := 'Cabecera';
      write(arc_sist, sist);
      Close(arc_sist);
    End
  Else
    imprimirSistemas(arc_sist);
  writeln('Hacer altas?(S/N)');
  readln(c);
  If ((c = 'n') Or (c='N'))Then
    fin := true;
  While (Not fin) Do
    Begin
      cargarSistema(sist);
      alta(arc_sist, sist);
      imprimirSistemas(arc_sist);
      writeln('Seguir haciendo altas?(S/N)');
      readln(c);
      If ((c = 'n') Or (c='N'))Then
        fin := true;
    End;

  fin := false;
  writeln('Hacer bajas?(S/N)');
  readln(c);
  If ((c = 'n') Or (c='N'))Then
    fin := true;
  While (Not fin) Do
    Begin
      writeln('Nombre: ');
      readln(nom);
      baja(arc_sist, nom);
      imprimirSistemas(arc_sist);
      writeln('Seguir haciendo bajas?(S/N)');
      readln(c);
      If ((c = 'n') Or (c='N'))Then
        fin := true;
    End;
End.
