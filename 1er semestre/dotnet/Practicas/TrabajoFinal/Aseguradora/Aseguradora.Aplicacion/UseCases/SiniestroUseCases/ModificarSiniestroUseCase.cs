using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarSiniestroUseCase : SiniestroUseCase
{
    public ModificarSiniestroUseCase(IRepositorioSiniestro repositorio) : base(repositorio) { }

    public Error Ejecutar(Siniestro siniestro) => Repositorio.ModificarSiniestro(siniestro);
}