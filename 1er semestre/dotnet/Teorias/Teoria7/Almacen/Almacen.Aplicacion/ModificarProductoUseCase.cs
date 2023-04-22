namespace Almacen.Aplicacion;

public class ModificarProductoUseCase
{
    private readonly IRepositorioProducto _repo;

    public ModificarProductoUseCase(IRepositorioProducto repo)
    {
        _repo = repo;
    }

    public void Ejecutar(Producto prod)
    {
        _repo.ModificarProducto(prod);
    }
}