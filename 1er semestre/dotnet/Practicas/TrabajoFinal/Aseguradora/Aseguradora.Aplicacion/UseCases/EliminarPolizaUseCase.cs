namespace Aseguradora.Aplicacion;

public class EliminarPolizaUseCase
{
    private readonly IRepositorioPoliza _repositorio;

    public EliminarPolizaUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public void Ejecutar(int id) => _repositorio.EliminarPoliza(id);
}