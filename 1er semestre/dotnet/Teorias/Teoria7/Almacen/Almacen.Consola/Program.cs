
using Almacen.Aplicacion;
using Almacen.Repositorios;

//configuro las dependencias
IRepositorioProducto repo = new RepositorioProductoTXT();

//creo los casos de uso
var agregarProducto = new AgregarProductoUseCase(repo);
var listarProducto = new ListarProductosUseCase(repo);
var getProducto = new GetProductoUseCase(repo);
var modificarProducto = new ModificarProductoUseCase(repo);
var eliminarProducto = new EliminarProductoUseCase(repo);

//ejecuto los casos de uso
agregarProducto.Ejecutar(new Producto() { Nombre = "Yerba" });
agregarProducto.Ejecutar(new Producto() { Nombre = "Azúcar" });
var lista = listarProducto.Ejecutar();

foreach (Producto p in lista)
{
    Console.WriteLine(p);
}

Console.WriteLine(getProducto.Ejecutar(12));
modificarProducto.Ejecutar(getProducto.Ejecutar(4));

lista = listarProducto.Ejecutar();

foreach (Producto p in lista)
{
    Console.WriteLine(p);
}

eliminarProducto.Ejecutar(3);
lista = listarProducto.Ejecutar();

foreach (Producto p in lista)
{
    Console.WriteLine(p);
}
Console.ReadKey();