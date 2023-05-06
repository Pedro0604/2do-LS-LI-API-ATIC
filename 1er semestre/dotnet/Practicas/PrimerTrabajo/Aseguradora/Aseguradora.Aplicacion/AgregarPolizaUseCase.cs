namespace Aseguradora.Aplicacion;

public class AgregarPolizaUseCase
{
    private readonly IRepositorioPoliza _repositorio;

    public AgregarPolizaUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Poliza poliza) => _repositorio.AgregarPoliza(poliza);
}