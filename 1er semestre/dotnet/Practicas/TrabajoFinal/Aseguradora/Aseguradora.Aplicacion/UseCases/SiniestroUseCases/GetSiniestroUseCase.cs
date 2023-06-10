using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class GetSiniestroUseCase : SiniestroUseCase
{
    public GetSiniestroUseCase(IRepositorioSiniestro repositorio) : base(repositorio) { }

    public Siniestro? Ejecutar(int id) => Repositorio.GetSiniestro(id);
}