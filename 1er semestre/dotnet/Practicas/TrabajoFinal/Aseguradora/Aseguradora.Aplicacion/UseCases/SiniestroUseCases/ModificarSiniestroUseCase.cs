using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;
public class ModificarSiniestroUseCase : SiniestroUseCase
{
    public ModificarSiniestroUseCase(IRepositorioSiniestro repositorio):base(repositorio){}

    public Error Ejecutar(Siniestro Siniestro) => Repositorio.ModificarSiniestro(Siniestro);
}