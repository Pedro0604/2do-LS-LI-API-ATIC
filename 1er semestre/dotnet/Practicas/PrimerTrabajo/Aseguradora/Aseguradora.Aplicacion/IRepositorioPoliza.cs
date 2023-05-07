namespace Aseguradora.Aplicacion;
public interface IRepositorioPoliza
{
    void AgregarPoliza(Poliza poliza);
    bool EliminarPoliza(int id);
    bool ModificarPoliza(Poliza poliza);
    List<Poliza> ListarPolizas();
}