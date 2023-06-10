using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class GetPolizaUseCase : PolizaUseCase
{
    public GetPolizaUseCase(IRepositorioPoliza repositorio) : base(repositorio) { }

    public Poliza? Ejecutar(int id) => Repositorio.GetPoliza(id);
}