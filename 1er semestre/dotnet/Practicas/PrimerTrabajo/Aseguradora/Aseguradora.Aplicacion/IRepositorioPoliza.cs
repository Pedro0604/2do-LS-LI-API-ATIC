namespace Aseguradora.Aplicacion;
public interface IRepositorioPoliza
{
    void AgregarPoliza(Poliza poliza);
    void EliminarPoliza(int id);
    void ModificarPoliza(Poliza poliza);
    List<Poliza> ListarPolizas();
}