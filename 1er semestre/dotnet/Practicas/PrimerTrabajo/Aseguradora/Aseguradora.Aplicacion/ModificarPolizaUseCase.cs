namespace Aseguradora.Aplicacion;

public class ModificarPolizaUseCase
{
    private readonly IRepositorioPoliza _repositorio;

    public ModificarPolizaUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Poliza poliza) => _repositorio.ModificarPoliza(poliza);
}