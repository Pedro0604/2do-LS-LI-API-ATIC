using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class ListarSiniestrosUseCase : SiniestroUseCase
{
    public ListarSiniestrosUseCase(IRepositorioSiniestro repositorio):base(repositorio){}

    public List<Siniestro> Ejecutar() => Repositorio.ListarSiniestros();
}