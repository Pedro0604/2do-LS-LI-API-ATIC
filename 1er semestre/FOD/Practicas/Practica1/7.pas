program siete;
using Sysutils;
TYPE
	novela = record
		codigo: integer;
		precio: real;
		genero, nombre: string;
	end;

  file_novela = file of novela;
  
Procedure crearBinario(var arc_novelas: file_novela);
var
  novelas: Text;
  n:novela;
begin
	Assign(novelas, 'novelas.txt');
	Reset(novelas);
	Rewrite(arc_novelas);
	while not EOF(novelas)do begin
		with n do begin
			readln(novelas, codigo, precio, genero);
			readln(novelas, nombre);
		end;
		write(arc_novelas, n);
	end;
	Close(t);
	Close(arc_novelas);
end;

Procedure buscarNovela(var arc_novelas: file_novelas; c:integer; var pos:integer);
var
	n:novela;
	found: boolean;
	posOg: integer;
begin
	pos:= -1;
	found:= false;
	posOg:=FilePos(arc_novelas);
	Seek(arc_novelas, 0);
	while not EOF(arc_novelas) and (not found) do begin
		read(arc_novelas, n);
		if (n.codigo=c)then begin
			found:=true;
			pos:=FilePos(arc_novelas)-1;
		end;
	end;
	Seek(arc_novelas, posOg);
end;

Procedure agregarNovela(var arc_novelas: file_novelas);
var
	n:novela;
begin
	Reset(arc_novelas);
	writeln('Codigo: ');
	readln(n.codigo);
	buscarNovela(arc_novelas, n.codigo, pos);
	while(pos=-1)do begin
		writeln('El codigo ingresado ya existe');
		writeln('Codigo: ');
		readln(n.codigo);
		buscarNovela(arc_novelas, n.codigo, pos);
	end;
	writeln('Precio: ');
	readln(n.precio);
	writeln('Genero: ');
	readln(n.genero);
	writeln('Nombre: ');
	readln(n.nombre);
	Seek(arc_novelas, FileSize-1);
	write(arc_novelas, n);
	Close(arc_novelas);
end;

Procedure modificarNovela(var arc_novelas: file_novelas);
var
	pos: integer;
	n: novela;
begin
	writeln('Codigo a modificar: ');
	readln(n.codigo);
	Reset(arc_novelas);
	buscarNovela(arc_novelas, n.codigo, pos);
	while(pos<>-1)do begin
		writeln('El codigo ingresado no existe');
		writeln('Codigo a modificar: ');
		readln(n.codigo);
		buscarNovela(arc_novelas, n.codigo, pos);
	end;
	writeln('Datos modificados: ');
	writeln('Precio: ');
	readln(n.precio);
	writeln('Genero: ');
	readln(n.genero);
	writeln('Nombre: ');
	readln(n.nombre);
	Seek(arc_novelas, pos);
	write(arc_novelas, n)
	Close(arc_novelas);
end;

Function novelaToString(n: novela):string;
begin
	with n do begin
		novelaToString:= Format(%-6d | %-6:2f | %-15s | %-40s, [codigo, precio, genero, nombre]);
	end;
end;

Procedure mostrarNovelas(var arc_novelas: file_novelas);
var
	n: novela;
begin
	Reset(arc_novelas);
	writeln('Novelas':);
	writeln(Format(%-6s | %-6s | %-15s | %-40s, ['Codigo', 'Precio', 'Genero', 'Nombre']));
	while not EOF(arc_novelas)do begin
		read(arc_novelas, n);
		writeln(novelaToString(n));
	end;
	Close(arc_novelas);
end;

var
  arc_novelas: file_novela;
begin
	crearBinario(arc_novelas);
	mostrarNovelas(arc_novelas);
	agregarNovela(arc_novelas);
	mostrarNovelas(arc_novelas);
	modificarNovela(arc_novelas);
	mostrarNovelas(arc_novelas);
end;