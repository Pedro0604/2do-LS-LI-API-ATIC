using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ListarTercerosUseCase : TerceroUseCase
{
    public ListarTercerosUseCase(IRepositorioTercero repositorio):base(repositorio){}

    public List<Tercero> Ejecutar() => Repositorio.ListarTerceros();
}