namespace Aseguradora.Aplicacion;

public class ListarTitularesUseCase
{
    private readonly IRepositorioTitular _repositorio;

    public ListarTitularesUseCase(IRepositorioTitular repositorio) => this._repositorio = repositorio;

    public List<Titular> Ejecutar() => _repositorio.ListarTitulares();
}