using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ListarTitularesUseCase : TitularUseCase
{
    public ListarTitularesUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public List<Titular> Ejecutar() => Repositorio.ListarTitulares();
}