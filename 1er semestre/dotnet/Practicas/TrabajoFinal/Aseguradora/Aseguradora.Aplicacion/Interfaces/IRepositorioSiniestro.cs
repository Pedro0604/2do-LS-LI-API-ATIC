using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioSiniestro
{
    void AgregarSiniestro(Siniestro siniestro);
    void EliminarSiniestro(int id);
    void ModificarSiniestro(Siniestro siniestro);
    List<Siniestro> ListarSiniestros();
}