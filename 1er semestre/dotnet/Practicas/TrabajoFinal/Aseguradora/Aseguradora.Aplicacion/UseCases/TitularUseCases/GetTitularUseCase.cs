using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class GetTitularUseCase : TitularUseCase
{
    public GetTitularUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public Titular? Ejecutar(int id) => Repositorio.GetTitular(id);
}