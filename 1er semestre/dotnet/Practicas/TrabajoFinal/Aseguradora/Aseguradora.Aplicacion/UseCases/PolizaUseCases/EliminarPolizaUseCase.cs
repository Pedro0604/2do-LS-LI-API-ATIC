using Aseguradora.Aplicacion.Interfaces;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarPolizaUseCase: PolizaUseCase
{
    public EliminarPolizaUseCase(IRepositorioPoliza repositorio):base(repositorio){}

    public void Ejecutar(int id) => Repositorio.EliminarPoliza(id);
}