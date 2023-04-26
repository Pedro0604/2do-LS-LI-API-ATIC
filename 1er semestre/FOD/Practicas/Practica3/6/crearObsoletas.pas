
Program crearObsoletas;

Var 
  arc_obsoletas : file Of integer;
  i, x: integer;

Function exists(): boolean;

Var 
  posOg, n: integer;
  existe: boolean;
Begin
  existe := false;
  posOg := FilePos(arc_obsoletas);
  Seek(arc_obsoletas, 0);
  While Not EOF(arc_obsoletas) And Not existe Do
    Begin
      read(arc_obsoletas, n);
      If (x = n)Then
        existe := true;
    End;
  Seek(arc_obsoletas, posOg);
  exists := existe;
End;

Begin
  Randomize();
  Assign(arc_obsoletas, 'obsoletas.obs');
  Rewrite(arc_obsoletas);
  For i:=1 To Random(15)+5 Do
    Begin
      x := Random(50)+1;
      While (exists()) Do
        x := Random(50)+1;
      Write(arc_obsoletas, x);
    End;
  Seek(arc_obsoletas, 0);
  While Not EOF(arc_obsoletas) Do
    Begin
      Read(arc_obsoletas, i);
      writeln('Codigo: ', i);
    End;
  Close(arc_obsoletas);

End.
