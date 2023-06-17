using Aseguradora.Aplicacion.Entidades;
using Aseguradora.Aplicacion.ClassUtils;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioPoliza
{
    void AgregarPoliza(Poliza poliza);
    Error EliminarPoliza(int id);
    Error ModificarPoliza(Poliza poliza);
    List<Poliza> ListarPolizas();
    Poliza? GetPoliza(int id);
}