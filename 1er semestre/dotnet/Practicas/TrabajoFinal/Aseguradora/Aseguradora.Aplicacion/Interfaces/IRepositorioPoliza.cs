using Aseguradora.Aplicacion.Entidades;

namespace Aseguradora.Aplicacion.Interfaces;
public interface IRepositorioPoliza
{
    void AgregarPoliza(Poliza poliza);
    void EliminarPoliza(int id);
    void ModificarPoliza(Poliza poliza);
    List<Poliza> ListarPolizas();
    Poliza? GetPoliza(int id);
}