using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarTerceroUseCase : TerceroUseCase
{

    public AgregarTerceroUseCase(IRepositorioTercero repositorio) : base(repositorio) { }

    public void Ejecutar(Tercero tercero) => Repositorio.AgregarTercero(tercero);
}