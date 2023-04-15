
Program uno;

Type 
  numeros = file Of integer;
Procedure ingresarNumeros(Var arc_num : numeros);

Var 
  num: integer;
Begin
  writeln('Ingrese un numero: ');
  readln(num);
  While (num<>30000) Do
    Begin
      write(arc_num, num);
      writeln('Ingrese un numero: ');
      readln(num);
    End;
End;

Var 
  arc_num: numeros;
  nombre_fisico: string;
Begin
  writeln('Ingrese el nombre del archivo: ');
  readln(nombre_fisico);
  Assign(arc_num, nombre_fisico+'.dat');
  Rewrite(arc_num);
  ingresarNumeros(arc_num);
  Close(arc_num);
End.
