namespace Aseguradora.Aplicacion;

public class ListarTitularesConSusVehiculosUseCase
{
    private readonly IRepositorioTitular _repositorio;

    public ListarTitularesConSusVehiculosUseCase(IRepositorioTitular repositorio)
    {
        this._repositorio = repositorio;
    }

    public List<string> Ejecutar() => _repositorio.ListarTitularesConSusVehiculos();
}