
Program Parcial_9_6_2015;

Uses 
SysUtils;

Const 
  VALOR_ALTO = 32000;
  CANT_PEDIDOS = 3;

Type 
  regProducto = Record
    codProd, stockAct, stockMin: integer;
    nombre, descrip, codBarr, categ: string;
  End;

  regPedido = Record
    codProd, cantPed: integer;
    descrip: string;
  End;

  file_prod = file Of regProducto;
  file_pedido = file Of regPedido;

  arrPedidos = array [1..CANT_PEDIDOS] Of file_pedido;
  arrRegPedidos = array [1..CANT_PEDIDOS] Of regPedido;


Procedure leer(Var arc_pedido: file_pedido; Var pedido: regPedido);
Begin
  If (Not EOF(arc_pedido))Then
    read(arc_pedido, pedido)
  Else
    pedido.codProd := VALOR_ALTO;
End;

Procedure minimo(Var pedidos: arrPedidos; Var regPedidos: arrRegPedidos; Var min:
                 regPedido);

Var 
  i, posMin: integer;
Begin
  min.codProd := VALOR_ALTO;
  For i := 1 To CANT_PEDIDOS Do
    Begin
      If (regPedidos[i].codProd<min.codProd)Then
        Begin
          min := regPedidos[i];
          posMin := i;
        End;
    End;
  If (min.codProd<>VALOR_ALTO)Then
    leer(pedidos[posMin], regPedidos[posMin]);
End;

Procedure actualizarMaestro(Var arc_prod: file_prod; Var pedidos: arrPedidos);

Var 
  regPedidos : arrRegPedidos;
  min: regPedido;
  prod: regProducto;
  txtPedNoSat: Text;
  i: integer;
Begin
  // Abrimos los archivos
  Reset(arc_prod);
  For i:=1 To CANT_PEDIDOS Do
    Begin
      Reset(pedidos[i]);
    End;
  // Creamos los archivos de stock menor al minimo y pedidos no satisfechos
  Assign(txtPedNoSat, 'pedidosNoSatisfechos.txt');
  Rewrite(txtPedNoSat);

  // Leemos los archivos
  For i:=1 To CANT_PEDIDOS Do
    Begin
      leer(pedidos[i], regPedidos[i]);
    End;
  minimo(pedidos, regPedidos, min);
  While (min.codProd <>VALOR_ALTO) Do
    Begin
      read(arc_prod, prod);
      While (min.codProd<>prod.codProd) Do
        Begin
          read(arc_prod, prod);
        End;
      seek(arc_prod, FilePos(arc_prod)-1);
      If (min.cantPed>prod.stockAct)Then
        Begin
          writeln(txtPedNoSat, 'Codigo producto = ', prod.codProd,' - (stockAct = ', prod
                  .stockAct,' - cantPedida = ', min.cantPed ,'). Diferencia no enviada = '
                  ,
                  min.cantPed - prod.stockAct);
          prod.stockAct := 0;
        End
      Else
        prod.stockAct := prod.stockAct - min.cantPed;
      write(arc_prod, prod);
      seek(arc_prod, FilePos(arc_prod)-1);
      minimo(pedidos, regPedidos, min);
    End;

  // Cerramos los archivos
  Close(arc_prod);
  For i:=1 To CANT_PEDIDOS Do
    Begin
      Close(pedidos[i]);
    End;
  Close(txtPedNoSat);
End;

Procedure stockMenorAlMinimo(Var maestro: file_prod);

Var 
  prod: regProducto;
  txtStockMenor: Text;
Begin
  Assign(txtStockMenor, 'stockMenorAlMinimo.txt');
  Rewrite(txtStockMenor);
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      Read(maestro, prod);
      If (prod.stockAct<prod.stockMin)Then
        writeln(txtStockMenor, 'Codigo producto = ', prod.codProd, ' - (stockAct = ', prod
                .stockAct,' - stockMin = ', prod.stockMin,'). Categoria = ', prod.categ);
    End;
  Close(maestro);
  Close(txtStockMenor);
End;

Procedure imprimirMaestro(Var maestro: file_prod);

Var 
  prod: regProducto;
Begin
  Reset(maestro);
  While Not EOF(maestro) Do
    Begin
      Read(maestro, prod);
      writeln('Código: ', prod.codProd);
      writeln('Nombre: ', prod.nombre);
      writeln('Descripción: ', prod.descrip);
      writeln('Stock disponible: ', prod.stockAct);
      writeln('Stock mínimo: ', prod.stockMin);
      writeln('codBarr: ', prod.codBarr);
      writeln('categ: ', prod.categ);
      writeln;
    End;
  Close(maestro);

End;

Var 
  arc_prod : file_prod;
  pedidos : arrPedidos;
  i: integer;
Begin
  Assign(arc_prod, 'productos.prod');
  For i:=1 To CANT_PEDIDOS Do
    Begin
      Assign(pedidos[i], './Detalles/pedido' + IntToStr(i) + '.ped');
    End;
  imprimirMaestro(arc_prod);
  actualizarMaestro(arc_prod, pedidos);
  imprimirMaestro(arc_prod);
  stockMenorAlMinimo(arc_prod);
End.
