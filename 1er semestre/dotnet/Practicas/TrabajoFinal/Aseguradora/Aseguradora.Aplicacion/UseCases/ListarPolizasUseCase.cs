namespace Aseguradora.Aplicacion;

public class ListarPolizasUseCase
{
    private readonly IRepositorioPoliza _repositorio;

    public ListarPolizasUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public List<Poliza> Ejecutar() => _repositorio.ListarPolizas();
}