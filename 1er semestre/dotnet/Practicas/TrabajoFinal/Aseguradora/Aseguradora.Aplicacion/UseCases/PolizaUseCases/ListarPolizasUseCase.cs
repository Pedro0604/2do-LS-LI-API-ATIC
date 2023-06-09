using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ListarPolizasUseCase : PolizaUseCase
{
    public ListarPolizasUseCase(IRepositorioPoliza repositorio):base(repositorio){}

    public List<Poliza> Ejecutar() => Repositorio.ListarPolizas();
}