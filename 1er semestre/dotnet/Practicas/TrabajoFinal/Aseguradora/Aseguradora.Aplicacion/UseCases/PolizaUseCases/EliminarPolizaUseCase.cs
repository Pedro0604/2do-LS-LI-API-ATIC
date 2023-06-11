using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarPolizaUseCase: PolizaUseCase
{
    public EliminarPolizaUseCase(IRepositorioPoliza repositorio):base(repositorio){}

    public Error Ejecutar(int id) => Repositorio.EliminarPoliza(id);
}