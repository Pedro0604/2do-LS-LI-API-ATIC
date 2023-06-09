namespace Aseguradora.Aplicacion;

public class EliminarTitularUseCase
{
    private readonly IRepositorioTitular _repositorio;

    public EliminarTitularUseCase(IRepositorioTitular repositorio) => this._repositorio = repositorio;

    public void Ejecutar(int id) => _repositorio.EliminarTitular(id);
}