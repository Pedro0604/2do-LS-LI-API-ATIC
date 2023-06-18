using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarTitularUseCase : TitularUseCase
{
    public ModificarTitularUseCase(IRepositorioTitular repositorio) : base(repositorio) { }

    public Error Ejecutar(Titular titular) => Repositorio.ModificarTitular(titular);
}