using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarTerceroUseCase : TerceroUseCase
{
    public ModificarTerceroUseCase(IRepositorioTercero repositorio):base(repositorio){}

    public Error Ejecutar(Tercero Tercero) => Repositorio.ModificarTercero(Tercero);
}