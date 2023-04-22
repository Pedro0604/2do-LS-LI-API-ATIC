
Program EJ03P3;

Uses 
Sysutils;

Type 
  novela = Record
    codigo : integer;
    genero : string;
    nombre : string;
    duracion : integer;
    director : string;
    precio : real;
  End;

  file_novela = file Of novela;

Procedure leerBasura(Var reg : novela; pos : integer);
Begin
  With (reg) Do
    Begin
      codigo := pos;
      genero := '@';
      nombre := '@';
      duracion := 0;
      director := '@';
      precio := 0;
    End;
End;

Procedure ingresarNovela(Var reg : novela);

Var 
  generos: array [0..14] Of string;
  directores: array[0..49] Of string;
  nombres: array[0..49] Of string;
Begin
  Randomize();
  Begin
    generos[0] := 'Drama';
    generos[1] := 'Comedia';
    generos[2] := 'Acción';
    generos[3] := 'Aventura';
    generos[4] := 'Romance';
    generos[5] := 'Ciencia Ficción';
    generos[6] := 'Terror';
    generos[7] := 'Misterio';
    generos[8] := 'Fantasía';
    generos[9] := 'Historia';
    generos[10] := 'Policial';
    generos[11] := 'Suspenso';
    generos[12] := 'Documental';
    generos[13] := 'Musical';
    generos[14] := 'Infantil';

    directores[0] := 'Steven Spielberg';
    directores[1] := 'Martin Scorsese';
    directores[2] := 'Quentin Tarantino';
    directores[3] := 'Christopher Nolan';
    directores[4] := 'Alfred Hitchcock';
    directores[5] := 'Stanley Kubrick';
    directores[6] := 'Woody Allen';
    directores[7] := 'Francis Ford Coppola';
    directores[8] := 'Clint Eastwood';
    directores[9] := 'Tim Burton';
    directores[10] := 'David Fincher';
    directores[11] := 'James Cameron';
    directores[12] := 'George Lucas';
    directores[13] := 'Peter Jackson';
    directores[14] := 'Ridley Scott';
    directores[15] := 'Pedro Almodóvar';
    directores[16] := 'Gus Van Sant';
    directores[17] := 'Jean-Pierre Jeunet';
    directores[18] := 'Luc Besson';
    directores[19] := 'Ang Lee';
    directores[20] := 'Fernando Meirelles';
    directores[21] := 'Spike Lee';
    directores[22] := 'Coen Brothers';
    directores[23] := 'Paul Thomas Anderson';
    directores[24] := 'Guillermo del Toro';
    directores[25] := 'David Lynch';
    directores[26] := 'Sofia Coppola';
    directores[27] := 'Joel Schumacher';
    directores[28] := 'Robert Zemeckis';
    directores[29] := 'Wes Anderson';
    directores[30] := 'Darren Aronofsky';
    directores[31] := 'Alejandro González Iñárritu';
    directores[32] := 'Danny Boyle';
    directores[33] := 'Oliver Stone';
    directores[34] := 'Stephen Frears';
    directores[35] := 'Sam Mendes';
    directores[36] := 'Milos Forman';
    directores[37] := 'Roman Polanski';
    directores[38] := 'Yimou Zhang';
    directores[39] := 'James Ivory';
    directores[40] := 'Ethan Hawke';
    directores[41] := 'Joss Whedon';
    directores[42] := 'J.J. Abrams';
    directores[43] := 'Denis Villeneuve';
    directores[44] := 'Damien Chazelle';
    directores[45] := 'Patty Jenkins';
    directores[46] := 'Ryan Coogler';
    directores[47] := 'Bong Joon-ho';
    directores[48] := 'Chloé Zhao';
    directores[49] := 'Emerald Fennell';

    nombres[0] := 'Breaking Bad';
    nombres[1] := 'The Sopranos';
    nombres[2] := 'Game of Thrones';
    nombres[3] := 'The Wire';
    nombres[4] := 'Mad Men';
    nombres[5] := 'The Crown';
    nombres[6] := 'The West Wing';
    nombres[7] := 'The Americans';
    nombres[8] := 'Fargo';
    nombres[9] := 'Stranger Things';
    nombres[10] := 'Lost';
    nombres[11] := 'True Detective';
    nombres[12] := 'The Handmaid''s Tale';
    nombres[13] := 'The Leftovers';
    nombres[14] := 'The Twilight Zone';
    nombres[15] := 'Twin Peaks';
    nombres[16] := 'House of Cards';
    nombres[17] := 'Mindhunter';
    nombres[18] := 'Dexter';
    nombres[19] := 'Narcos';
    nombres[20] := 'Better Call Saul';
    nombres[21] := 'The Walking Dead';
    nombres[22] := 'Homeland';
    nombres[23] := 'Sherlock';
    nombres[24] := 'The Big Bang Theory';
    nombres[25] := 'Friends';
    nombres[26] := 'How I Met Your Mother';
    nombres[27] := 'The Office';
    nombres[28] := 'Parks and Recreation';
    nombres[29] := 'Brooklyn Nine-Nine';
    nombres[30] := 'The Good Place';
    nombres[31] := 'Sex and the City';
    nombres[32] := 'Desperate Housewives';
    nombres[33] := 'Grey''s Anatomy';
    nombres[34] := 'Buffy the Vampire Slayer';
    nombres[35] := 'Charmed';
    nombres[36] := 'The X-Files';
    nombres[37] := 'Star Trek: The Next Generation';
    nombres[38] := 'Battlestar Galactica';
    nombres[39] := 'Doctor Who';
    nombres[40] := 'Black Mirror';
    nombres[41] := 'Westworld';
    nombres[42] := 'The Mandalorian';
    nombres[43] := 'Stranger Things';
    nombres[44] := 'American Horror Story';
    nombres[45] := 'The Haunting of Hill House';
    nombres[46] := 'Dark';
    nombres[47] := 'Money Heist';
    nombres[48] := 'La Casa de Papel';
    nombres[49] := 'Elite';

  End;

  With (reg) Do
    Begin
      write('Ingresar codigo de novela: ');
      readln(codigo);
      If (codigo <> -1) Then
        Begin
          //   write('Ingresar genero: ');
          //   readln(genero);
          genero := generos[Random(15)];
          writeln('Genero ingresado: ' + genero);
          //   write('Ingresar nombre: ');
          //   readln(nombre);
          nombre := nombres[Random(50)];
          writeln('Nombre ingresado: ' + nombre);
          duracion := random(200)+1;
          writeln('Duracion ingresada: ',duracion);
          //   write('Ingresar director: ');
          //   readln(director);
          director := directores[Random(50)];
          writeln('Director ingresado: ' + director);
          precio := random(500) + 1;
          writeln('Precio ingresado: ',precio:0:2)
        End;
      writeln('----------');
    End;
End;

Function buscarNovelaPorCodigo(Var novelas: file_novela; cod: integer): integer;

Var 
  found: boolean;
  pos, posOg: integer;
  n: novela;
Begin
  pos := -1;
  found := false;
  posOg := FilePos(novelas);
  Seek(novelas, 0);
  While (Not EOF(novelas)) And (Not found) Do
    Begin
      read(novelas, n);
      If (n.codigo>0) And (cod = n.codigo)Then
        Begin
          pos := FilePos(novelas)-1;
          found := true;
        End;
    End;
  Seek(novelas, posOg);
  buscarNovelaPorCodigo := pos;
End;

Procedure cargarNovelas(Var novelas : file_novela);

Var 
  n : novela;
Begin
  writeln('-| Cargando novelas... |-');
  rewrite(novelas);
  leerBasura(n, 0);
  write(novelas, n);
  ingresarNovela(n);
  While (n.codigo <> -1) Do
    Begin
      Write(novelas,n);
      ingresarNovela(n);
    End;
  close(novelas);
  writeln('-| Fin de carga |-');
End;

Function novelaToString(reg : novela): string;

Var 
  st: string;
Begin
  With (reg) Do
    Begin
      st := 'Codigo: ' + intToStr(codigo) + ' - Genero: ' + genero + ' - Nombre: ' +
            nombre + ' - Duracion: ' + intToStr(duracion) + ' - Director: ' + director +
            ' - Precio: ' + floatToStr(precio);
    End;
  novelaToString := st;
End;

Procedure imprimirNovelas(Var novelas : file_novela);

Var 
  n : novela;
Begin
  writeln('-| Novelas |-');
  Reset(novelas);
  While Not EOF(novelas) Do
    Begin
      read(novelas, n);
      If (n.codigo>0)Then
        writeln(novelaToString(n));
    End;
  close(novelas);
End;

Procedure altaNovela(Var novelas: file_novela);

Var 
  n, regN: novela;
  enlace: integer;
Begin
  Reset(novelas);
  ingresarNovela(n);
  read(novelas, regN);
  enlace := regN.codigo;
  If (enlace = 0)Then
    Seek(novelas, FileSize(novelas))
  Else
    Begin
      Seek(novelas, enlace*(-1));
      read(novelas, regN);
      Seek(novelas, 0);
      leerBasura(regN, regN.codigo);
      write(novelas, regN);
      Seek(novelas, enlace*(-1));
    End;
  write(novelas, n);
  Close(novelas);
End;

Procedure modificarNovela(Var novelas: file_novela);

Var 
  n: novela;
  cod, pos: integer;
Begin
  Reset(novelas);
  writeln('Ingrese el codigo de la novela a modificar: ');
  readln(cod);
  pos := buscarNovelaPorCodigo(novelas, cod);
  If (pos<>-1)Then
    Begin
      Seek(novelas, pos);
      With n Do
        Begin
          write('Ingresar genero: ');
          readln(genero);
          write('Ingresar nombre: ');
          readln(nombre);
          duracion := random(200)+1;
          writeln('Duracion ingresada: ',duracion);
          write('Ingresar director: ');
          readln(director);
          precio := random(500) + 1;
          writeln('Precio ingresado: ',precio:0:2);
        End;
      n.codigo := cod;
      write(novelas, n);
      writeln('Novela modificada exitosamente');
    End
  Else
    writeln('El codigo de novela ingresado no existe.');
  Close(novelas);
End;

Procedure eliminarNovela(Var novelas : file_novela);

Var 
  cod, pos: integer;
  aux, n : novela;
Begin
  Write('Ingresar codigo de novela a eliminar: ');
  readln(cod);
  Reset(novelas);
  pos := buscarNovelaPorCodigo(novelas, cod);
  If (pos<>-1)Then
    Begin
      read(novelas, aux);
      Seek(novelas, pos);
      read(novelas, n);
      n.codigo := aux.codigo;
      Seek(novelas, FilePos(novelas)-1);
      write(novelas, n);
      Seek(novelas, 0);
      read(novelas, aux);
      aux.codigo := pos*-1;
      Seek(novelas, 0);
      write(novelas, aux);
      writeln('Novela eliminada exitosamente');
    End
  Else
    writeln('El codigo de novela ingresado no existe.');
  Close(novelas);
End;

Procedure exportarNovelas(Var novelas: file_novela);

Var 
  txt: Text;
  n: novela;
Begin
  Assign(txt, 'novelas.txt');
  Rewrite(txt);
  Reset(novelas);
  While Not EOF(novelas) Do
    Begin
      read(novelas, n);
      writeln(txt, novelaToString(n));
    End;
  writeln('Novelas exportadas exitosamente');
  Close(novelas);
  Close(txt);
End;

Var 
  novelas : file_novela;
  opc: integer;
Begin
  Assign(novelas, 'novelas.nov');
  writeln('Crear archivo(1)');
  writeln('Usar existente(2)');
  writeln('Salir(-1)');
  readln(opc);
  While (opc<>-1) Do
    Begin
      If (opc=1)Then
        Begin
          cargarNovelas(novelas);
        End
      Else If (opc=2) Or (opc=7)Then
             Begin
               imprimirNovelas(novelas);
             End
      Else If (opc=3)Then
             Begin
               altaNovela(novelas);
             End
      Else If (opc=4)Then
             Begin
               modificarNovela(novelas);
             End
      Else If (opc=5)Then
             Begin
               eliminarNovela(novelas);
             End
      Else If (opc=6)Then
             Begin
               exportarNovelas(novelas);
             End;
      If (opc<>-1)Then
        Begin
          writeln('Alta novela(3)');
          writeln('Modificar novela(4)');
          writeln('Eliminar novela(5)');
          writeln('Exportar novelas(6)');
          writeln('Imprimir novelas(7)');
          writeln('Salir(-1)');
          readln(opc);
        End;
    End;
  writeln('Adios');
End.
