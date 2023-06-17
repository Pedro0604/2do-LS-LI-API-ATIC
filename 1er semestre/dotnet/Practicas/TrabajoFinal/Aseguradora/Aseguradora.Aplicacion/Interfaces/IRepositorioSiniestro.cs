using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioSiniestro
{
    void AgregarSiniestro(Siniestro siniestro);
    Error EliminarSiniestro(int id);
    Error ModificarSiniestro(Siniestro siniestro);
    List<Siniestro> ListarSiniestros();
    Siniestro? GetSiniestro(int id);
} 