using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioSiniestro
{
    Error AgregarSiniestro(Siniestro siniestro);
    Error EliminarSiniestro(int id);
    Error ModificarSiniestro(Siniestro siniestro);
    List<Siniestro> ListarSiniestros();
    Siniestro? GetSiniestro(int id);
}