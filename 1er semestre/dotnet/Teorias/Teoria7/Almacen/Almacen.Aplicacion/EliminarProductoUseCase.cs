namespace Almacen.Aplicacion;

public class EliminarProductoUseCase
{
    private readonly IRepositorioProducto _repo;

    public EliminarProductoUseCase(IRepositorioProducto repo)
    {
        _repo = repo;
    }

    public void Ejecutar(int id)
    {
        _repo.EliminarProducto(id);
    }
}