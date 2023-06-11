using Aseguradora.Aplicacion.Interfaces;
using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.UseCases;

public class EliminarSiniestroUseCase: SiniestroUseCase
{

    public EliminarSiniestroUseCase(IRepositorioSiniestro repositorio):base(repositorio){}

    public Error Ejecutar(int id) => Repositorio.EliminarSiniestro(id);
}