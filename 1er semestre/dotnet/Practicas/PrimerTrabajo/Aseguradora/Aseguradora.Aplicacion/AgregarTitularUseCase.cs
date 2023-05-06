namespace Aseguradora.Aplicacion;

public class AgregarTitularUseCase
{
    private readonly IRepositorioTitular _repositorio;

    public AgregarTitularUseCase(IRepositorioTitular repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Titular titular) => _repositorio.AgregarTitular(titular);
}