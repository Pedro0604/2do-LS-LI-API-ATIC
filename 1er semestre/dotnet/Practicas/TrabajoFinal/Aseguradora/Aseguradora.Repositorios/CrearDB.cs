namespace Aseguradora.Repositorios;

public static class CrearDB
{
    public static void Crear()
    {
        using (var db = new AseguradoraContext())
        {
            db.Database.EnsureCreated();
        }
    }
}