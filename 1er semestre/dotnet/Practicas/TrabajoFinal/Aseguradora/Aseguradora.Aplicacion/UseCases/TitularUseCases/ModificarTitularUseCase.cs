using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarTitularUseCase : TitularUseCase
{
    public ModificarTitularUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public Error Ejecutar(Titular Titular) => Repositorio.ModificarTitular(Titular);
}