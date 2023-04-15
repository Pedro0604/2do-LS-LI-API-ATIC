
Program dos;

Type 
  numeros = file Of integer;
Procedure verificarNumeros(Var arc_num: numeros);

Var 
  n, cant_num, suma, cant_menores: integer;
Begin
  cant_menores := 0;
  suma := 0;
  cant_num := 0;
  While Not eof(arc_num) Do
    Begin
      Read(arc_num, n);
      writeln('Numero de la posicion ',filePos(arc_num),': ',n);
      cant_num := cant_num+1;
      suma := suma+n;
      If (n<1500)Then
        Begin
          cant_menores := cant_menores+1;
        End;
    End;
  writeln('Menores 1500: ', cant_menores);
  writeln('Promedio: ', suma/cant_num:1:2);
End;

Var 
  arc_num: numeros;
  nombre_fisico: string;
Begin
  writeln('Nombre: ');
  readln(nombre_fisico);
  Assign(arc_num, nombre_fisico);
  Reset(arc_num);
  verificarNumeros(arc_num);
  Close(arc_num);
End.
