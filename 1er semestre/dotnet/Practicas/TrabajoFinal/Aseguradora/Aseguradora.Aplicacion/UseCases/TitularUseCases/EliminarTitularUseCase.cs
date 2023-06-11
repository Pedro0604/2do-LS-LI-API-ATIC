using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarTitularUseCase : TitularUseCase
{

    public EliminarTitularUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public Error Ejecutar(int id) => Repositorio.EliminarTitular(id);
}