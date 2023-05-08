namespace Aseguradora.Aplicacion;

public class AgregarPolizaUseCase
{
    private readonly IRepositorioPoliza _repositorio;
    private static int s_ultimoId { get; set; }

    public AgregarPolizaUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Poliza poliza)
    {
        _repositorio.AgregarPoliza(poliza);
    }
}