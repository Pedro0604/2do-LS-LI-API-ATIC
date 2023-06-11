using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarPolizaUseCase : PolizaUseCase
{

    public AgregarPolizaUseCase(IRepositorioPoliza repositorio) : base(repositorio) { }

    public Error Ejecutar(Poliza poliza) => Repositorio.AgregarPoliza(poliza);
}