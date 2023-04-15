
Program uno;

Const 
  valorAlto = 'zzzz';

Type 
  empleado = Record
    codigo: string[4];
    nombre: string[50];
    montoCom: real;
  End;

  file_empleados = file Of empleado;

Procedure leer(Var arc_emp:file_empleados; Var reg_emp: empleado);
Begin
  If (Not EOF(arc_emp)) Then
    read(arc_emp, reg_emp)
  Else
    reg_emp.codigo := valorAlto;
End;

Procedure imprimirEmp(reg_emp:empleado);
Begin
  write('Codigo: ' + reg_emp.codigo + ' - Nombre: ' + reg_emp.nombre + ' - Monto: ')
  ;
  writeln(reg_emp.montoCom: 2: 2);
  writeln();
End;
Procedure imprimir(Var arc_emp: file_empleados);

Var 
  reg_emp: empleado;
Begin
  Reset(arc_emp);
  While Not EOF(arc_emp) Do
    Begin
      read(arc_emp, reg_emp);
      imprimirEmp(reg_emp);
    End;
  Close(arc_emp);
End;


Procedure compactar(Var arc_emp_og, arc_emp_nuevo:file_empleados);

Var 
  reg_emp, empAct: empleado;
Begin
  Reset(arc_emp_og);
  Rewrite(arc_emp_nuevo);
  leer(arc_emp_og, reg_emp);
  While (reg_emp.codigo<>valorAlto) Do
    Begin
      empAct.nombre := reg_emp.nombre;
      empAct.codigo := reg_emp.codigo;
      empAct.montoCom := 0;
      While (reg_emp.codigo=empAct.codigo) Do
        Begin
          empAct.montoCom := empAct.montoCom + reg_emp.montoCom;
          leer(arc_emp_og, reg_emp);
        End;
      write(arc_emp_nuevo, empAct);
    End;
  Close(arc_emp_og);
  Close(arc_emp_nuevo);
End;

Var 
  arc_emp_og, arc_emp_nuevo: file_empleados;
Begin
  Assign(arc_emp_og, 'comisiones.emp');
  Assign(arc_emp_nuevo, 'nuevo.emp');
  compactar(arc_emp_og, arc_emp_nuevo);
  writeln('Archivo comisiones: ');
  imprimir(arc_emp_og);
  writeln();
  writeln('Archivo compactado: ');
  imprimir(arc_emp_nuevo);

End.
