
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

  file_prendas: file Of prenda;
  file_obsoletas: file Of integer;

Procedure leer(Var arc_obsoletas: file_obsoletas; Var cod:integer;);
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

Var 
  arc_prendas: file_prendas;
  arc_obsoletas: file_obsoletas;
Begin
  Assign(arc_prendas, 'prendas.pr');
  Assign(arc_obsoletas, 'obsoletas.obs');
  bajaLogica(arc_prendas, arc_obsoletas);
End;
