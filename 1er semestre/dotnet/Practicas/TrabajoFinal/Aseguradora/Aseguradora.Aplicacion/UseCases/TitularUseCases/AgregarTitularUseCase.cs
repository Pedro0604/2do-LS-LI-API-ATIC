using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarTitularUseCase : TitularUseCase
{

    public AgregarTitularUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public void Ejecutar(Titular titular) => Repositorio.AgregarTitular(titular);
}