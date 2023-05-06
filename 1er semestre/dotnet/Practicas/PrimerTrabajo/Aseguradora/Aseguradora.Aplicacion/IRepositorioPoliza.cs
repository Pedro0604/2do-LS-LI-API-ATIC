namespace Aseguradora.Aplicacion;
public interface IRepositorioPoliza
{
    void AgregarPoliza(Poliza poliza);
    bool EliminarPoliza(Poliza poliza);
    bool ModificarPoliza(Poliza poliza);
    List<Poliza> ListarPolizas();
}