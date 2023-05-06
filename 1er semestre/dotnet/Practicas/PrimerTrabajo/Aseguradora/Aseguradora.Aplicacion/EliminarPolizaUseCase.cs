namespace Aseguradora.Aplicacion;

public class EliminarPolizaUseCase
{
    private readonly IRepositorioPoliza _repositorio;

    public EliminarPolizaUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Poliza poliza) => _repositorio.EliminarPoliza(poliza);
}