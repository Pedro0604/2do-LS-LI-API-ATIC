namespace Almacen.Aplicacion;

public class GetProductoUseCase
{
    private readonly IRepositorioProducto _repo;

    public GetProductoUseCase(IRepositorioProducto repo)
    {
        _repo = repo;
    }

    public Producto? Ejecutar(int id)
    {
        return _repo.GetProducto(id);
    }
}