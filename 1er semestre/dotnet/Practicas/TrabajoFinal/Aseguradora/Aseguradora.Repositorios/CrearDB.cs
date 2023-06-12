namespace Aseguradora.Repositorios;

public class CrearDB
{
    public static void Crear()
    {
        using (var db = new AseguradoraContext())
        {
            db.Database.EnsureCreated();
        }
    }
}