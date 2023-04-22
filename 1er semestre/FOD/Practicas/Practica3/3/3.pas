program EJ03P3;

const
	VALOR_ALTO = 9999;

type
	novela = record
		codigo : integer;
		genero : string;
		nombre : string;
		duracion : integer;
		director : string;
		precio : real;
	end;
	
	file_novela = file of novela;

procedure leerBasura(var reg : novela; pos : integer);
begin
	with (reg) do begin
		codigo := pos;
		genero := '@';
		nombre := '@';
		duracion := 0;
		director := '@';
		precio := 0;
	end;
end;

procedure ingresarNovela(var reg : novela);
begin
	with (reg) do begin
		write('Ingresar codigo de novela: '); readln(codigo);
		if (codigo <> -1) then begin
			write('Ingresar genero: '); readln(genero);
			write('Ingresar nombre: '); readln(nombre);
			duracion := random(200)+1; writeln('Duracion ingresada: ',duracion);
			write('Ingresar director: '); readln(director);
			precio := random(500) + 1; writeln('Precio ingresado: ',precio:0:2)
		end;
		writeln('----------');
	end;
end;

procedure cargarNovelas(var novelas : file_novela);
var
	n : novela;
begin
	writeln('-| Cargarndo novelas... |-');
	rewrite(novelas);
	leerBasura(n, 0);
	write(novelas, n);
	ingresarNovela(n);
	while (n.codigo <> -1) do begin
		write(novelas,n);
		ingresarNovela(n);
	end;
	close(novelas);
	writeln('-| Fin de carga |-');
end;

procedure leer(var novelas : file_novela; var reg : novela);
begin
	if (not eof(novelas)) then
		read(novelas,reg)
	else
		reg.codigo := VALOR_ALTO;
end;

procedure imprimirNovela(reg : novela);
begin
	with (reg) do begin
		writeln('Codigo: ',codigo);
		writeln('Genero: ',genero);
		writeln('Nombre: ',nombre);
		writeln('Duracion: ',duracion);
		writeln('Director: ',director);
		writeln('Precio: ',precio:0:2);
		writeln('----------');
	end;
end;

procedure imprimirNovelas(var novelas : file_novela);
var
	n : novela;
begin
	writeln('-| file_novela novelas |-');
	reset(novelas);
	leer(novelas, n);
	while (n.codigo <> VALOR_ALTO) do begin
		imprimirNovela(n);
		leer(novelas,n);
	end;
	close(novelas);
end;

procedure altaNovela(var novelas: file_novela);
var
	n, regN: novela;
	enlace: integer;
begin
	Reset(novelas);
	ingresarNovela(n);
	read(novelas, regN);
	enlace := regN.codigo;
	if(enlace = 0)then
		Seek(novelas, FileSize(novelas)-1)
	else begin
		Seek(novelas, enlace*(-1));
		read(novelas, regN);
		Seek(novelas, 0);
		write(novelas, regN);
		Seek(novelas, enlace*(-1));
	end;
	write(novelas, n);
	Close(novelas);
end;

function buscarNovelaPorCodigo(var novelas; file_novelas; cod: integer);
begin
	while(novela)
end;

procedure modificarNovela(var novelas; file_novela);
var
	n: novela;
	cod, pos: integer;
begin
	Reset(novelas);
	writeln('Ingrese el codigo de la novela a modificar: ');
	readln(cod);
	pos:=c(novelas, cod);
	Close(novelas);
end;

procedure borrar(var novelas : file_novela);
var
	eliminar : string;
	num : integer;
	aux, reg : novela;
begin
	write('Ingresar nombre de novela a eliminar: '); readln(eliminar);
	reset(novelas);
	leer(novelas,aux);
	leer(novelas,reg);
	while (reg.codigo <> VALOR_ALTO) and (reg.nombre <> eliminar) do
		leer(novelas,reg);
	if (reg.codigo <> VALOR_ALTO) then begin
		num := aux.codigo;
		aux.codigo := -1 * (filepos(novelas)-1);
		reg.codigo := num;
		
	end;
	close(novelas);
end;

var 
	novelas : file_novela;
	opc: integer;
BEGIN
	assign(novelas, 'novelas.nov');
	writeln('Crear archivo(1)');
	writeln('Usar existente(2)');
	writeln('Alta novela(3)');
	writeln('Modificar novela(4)');
	writeln('Salir(-1)');
	readln(opc);
	while (opc<>-1)do begin
		if((opc=1)then begin
			cargarNovelas(novelas);s
		end
		else if(opc=2)then begin
		  imprimirNovelas(novelas);
		end
		else if(opc=3)then begin
		  altaNovela(novelas);
		end
		else if(opc=4)then begin
		  modificarNovela(novelas);
		end;
		if(opc<>-1)then
			readln(opc);
	end;
	writeln('Adios');
END.

