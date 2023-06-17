using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarTitularUseCase : TitularUseCase
{
    public ModificarTitularUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public Error Ejecutar(Titular titular)
    {
        Error error = new Error();
        var t = Repositorio.ListarTitulares().Where(t => t.DNI == titular.DNI).SingleOrDefault();
        if (t == null)
        {
            Repositorio.ModificarTitular(titular);
        }
        else
        {
            error.Mensaje = $"Ya existe un titular de DNI {titular.DNI}";
        }
        return error;
    }
}