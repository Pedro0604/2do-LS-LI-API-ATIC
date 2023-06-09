namespace Aseguradora.Aplicacion;

public class ModificarTitularUseCase
{
    private readonly IRepositorioTitular _repositorio;

    public ModificarTitularUseCase(IRepositorioTitular repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Titular titular) => _repositorio.ModificarTitular(titular);
}