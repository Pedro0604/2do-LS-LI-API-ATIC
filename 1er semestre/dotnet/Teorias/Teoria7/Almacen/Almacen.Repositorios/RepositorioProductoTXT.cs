namespace Almacen.Repositorios;
using Almacen.Aplicacion;
public class RepositorioProductoTXT : IRepositorioProducto
{
    public static int Id { get; private set; } = 1;
    readonly string _nombreArch = "productos.txt";
    readonly string _nombreArchId = "idMax.txt";
    public void AgregarProducto(Producto producto)
    {
        if (File.Exists(_nombreArchId))
        {
            using var srId = new StreamReader(_nombreArchId);
            Id = int.Parse(srId.ReadLine() ?? "") + 1;
        }
        using var swId = new StreamWriter(_nombreArchId);
        swId.WriteLine(Id);
        producto.Id = Id;
        using var sw = new StreamWriter(_nombreArch, true);
        sw.WriteLine(producto.Id);
        sw.WriteLine(producto.Nombre);
    }
    public List<Producto> ListarProductos()
    {
        var resultado = new List<Producto>();
        using var sr = new StreamReader(_nombreArch);
        while (!sr.EndOfStream)
        {
            var producto = new Producto();
            producto.Id = int.Parse(sr.ReadLine() ?? "");
            producto.Nombre = sr.ReadLine() ?? "";
            resultado.Add(producto);
        }
        return resultado;
    }
    public Producto? GetProducto(int id)
    {
        var l = this.ListarProductos();
        var prod = l.Find(prod => prod.Id == id);
        return prod;
    }
    public void ModificarProducto(Producto prod)
    {
        var l = this.ListarProductos();
        try
        {
            File.Delete(_nombreArch);
            using var sw = new StreamWriter(_nombreArch);
            foreach (var p in l)
            {
                if (p.Id == prod.Id)
                {
                    Console.WriteLine("Ingrese nuevo nombre: ");
                    p.Nombre = Console.ReadLine() ?? "";
                }
                sw.WriteLine(p.Id);
                sw.WriteLine(p.Nombre);
            }
        }
        catch
        {
            Console.WriteLine("No existe ese producto");
            using var sw = new StreamWriter(_nombreArch);
            foreach (var p in l)
            {
                sw.WriteLine(p.Id);
                sw.WriteLine(p.Nombre);
            }
        }
    }
    public void EliminarProducto(int id)
    {
        var l = this.ListarProductos();
        try
        {
            File.Delete(_nombreArch);
            using var sw = new StreamWriter(_nombreArch);
            foreach (var prod in l)
            {
                if (prod.Id != id)
                {
                    sw.WriteLine(prod.Id);
                    sw.WriteLine(prod.Nombre);
                }
            }
        }
        catch
        {
            Console.WriteLine("No existe ese id de producto");
            using var sw = new StreamWriter(_nombreArch);
            foreach (var p in l)
            {
                sw.WriteLine(p.Id);
                sw.WriteLine(p.Nombre);
            }
        }
    }
}