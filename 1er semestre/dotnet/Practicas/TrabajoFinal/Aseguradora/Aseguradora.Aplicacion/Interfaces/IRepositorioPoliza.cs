using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioPoliza
{
    Error AgregarPoliza(Poliza poliza);
    Error EliminarPoliza(int id);
    Error ModificarPoliza(Poliza poliza);
    List<Poliza> ListarPolizas();
    Poliza? GetPoliza(int id);
}