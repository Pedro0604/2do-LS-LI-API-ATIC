using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarTerceroUseCase : TerceroUseCase
{
    public ModificarTerceroUseCase(IRepositorioTercero repositorio):base(repositorio){}

    public void Ejecutar(Tercero Tercero) => Repositorio.ModificarTercero(Tercero);
}