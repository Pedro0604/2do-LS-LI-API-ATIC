using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarPolizaUseCase: PolizaUseCase
{
    public EliminarPolizaUseCase(IRepositorioPoliza repositorio):base(repositorio){}

    public Error Ejecutar(int id) => Repositorio.EliminarPoliza(id);
}