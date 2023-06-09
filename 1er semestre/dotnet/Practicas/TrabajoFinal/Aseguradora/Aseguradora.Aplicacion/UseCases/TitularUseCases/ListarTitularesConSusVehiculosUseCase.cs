using Aseguradora.Aplicacion.Interfaces;

namespace Aseguradora.Aplicacion.UseCases;

public class ListarTitularesConSusVehiculosUseCase : TitularUseCase
{
    public ListarTitularesConSusVehiculosUseCase(IRepositorioTitular repositorio):base(repositorio){}

    public List<string> Ejecutar() => Repositorio.ListarTitularesConSusVehiculos();
}