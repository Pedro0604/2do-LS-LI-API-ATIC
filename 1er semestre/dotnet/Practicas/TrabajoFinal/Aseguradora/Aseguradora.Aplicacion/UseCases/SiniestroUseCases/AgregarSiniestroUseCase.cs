using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class AgregarSiniestroUseCase : SiniestroUseCase
{

    public AgregarSiniestroUseCase(IRepositorioSiniestro repositorio) : base(repositorio) { }

    public bool Ejecutar(Siniestro Siniestro) => Repositorio.AgregarSiniestro(Siniestro);
}