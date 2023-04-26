
Program seis;

Uses 
Sysutils;

Const 
  VALOR_ALTO = 32000;

Type 
  prenda = Record
    cod_prenda: integer;
    descripcion: string[50];
    colores: string[50];
    tipo_prenda: string[20];
    stock: integer;
    precio_unitario: real;
  End;

  file_prendas = file Of prenda;
  file_obsoletas = file Of integer;

Procedure ImprimirPrenda(prenda: prenda);
Begin
  writeln('Código: ', prenda.cod_prenda);
  writeln('Descripción: ', prenda.descripcion);
  writeln('Colores: ', prenda.colores);
  writeln('Tipo de prenda: ', prenda.tipo_prenda);
  writeln('Stock: ', prenda.stock);
  writeln('Precio unitario: $', prenda.precio_unitario:0:2);
End;

Procedure ImprimirArchivoPrendas(Var arc_prendas: file_prendas);

Var 
  prenda_actual: prenda;
Begin
  Reset(arc_prendas);

  // Leer cada registro de prenda y llamar al procedimiento ImprimirPrenda
  While Not EOF(arc_prendas) Do
    Begin
      Read(arc_prendas, prenda_actual);
      ImprimirPrenda(prenda_actual);
      writeln('-----------------------');
    End;

  // Cerrar el archivo de prendas
  Close(arc_prendas);
End;


Procedure leer(Var arc_obsoletas: file_obsoletas; Var cod:integer);
Begin
  If (Not EOF(arc_obsoletas))Then
    read(arc_obsoletas, cod)
  Else
    cod := VALOR_ALTO;
End;

Procedure bajaLogica(Var arc_prendas: file_prendas; Var arc_obsoletas: file_obsoletas);

Var 
  cod: integer;
  p: prenda;
Begin
  Reset(arc_prendas);
  Reset(arc_obsoletas);
  leer(arc_obsoletas, cod);
  read(arc_prendas, p);
  While (cod<>VALOR_ALTO) Do
    Begin
      While (cod<>p.cod_prenda) Do
        Begin
          read(arc_prendas, p);
        End;
      p.stock := p.stock*-1;
      Seek(arc_prendas, FilePos(arc_prendas)-1);
      write(arc_prendas, p);
      Seek(arc_prendas, 0);
      leer(arc_obsoletas, cod);
    End;
  Close(arc_prendas);
  Close(arc_obsoletas);
End;

Procedure compactacion(Var arc_prendas: file_prendas);

Var 
  aux: prenda;
  nuevoArchivo: file_prendas;
Begin
  Assign(nuevoArchivo, 'nuevoPrendas.pr');
  Rewrite(nuevoArchivo);
  Reset(arc_prendas);

  While Not EOF(arc_prendas) Do
    Begin
      read(arc_prendas, aux);
      If (aux.stock>=0)Then
        write(nuevoArchivo, aux);
    End;
  Close(nuevoArchivo);
  Close(arc_prendas);
  Erase(arc_prendas);
  Rename(nuevoArchivo, 'prendas.pr');
  Assign(arc_prendas, 'prendas.pr');
End;

Var 
  arc_prendas: file_prendas;
  arc_obsoletas: file_obsoletas;
Begin
  Assign(arc_prendas, 'prendas.pr');
  Assign(arc_obsoletas, 'obsoletas.obs');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Pre bajas');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  ImprimirArchivoPrendas(arc_prendas);
  bajaLogica(arc_prendas, arc_obsoletas);
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Post bajas');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  ImprimirArchivoPrendas(arc_prendas);
  compactacion(arc_prendas);
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  writeln('Post compactacion');
  writeln('#################################');
  writeln('#################################');
  writeln('#################################');
  ImprimirArchivoPrendas(arc_prendas);
End.
