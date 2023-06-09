using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ModificarPolizaUseCase : PolizaUseCase
{
    public ModificarPolizaUseCase(IRepositorioPoliza repositorio):base(repositorio){}

    public void Ejecutar(Poliza poliza) => Repositorio.ModificarPoliza(poliza);
}