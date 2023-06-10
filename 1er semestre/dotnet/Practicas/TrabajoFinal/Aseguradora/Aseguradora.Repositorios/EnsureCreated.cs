namespace Aseguradora.Repositorios;

public class EnsureCreated
{
    public static void Ensure()
    {
        // Nos aseguramos que esté creada la base de datos
        using (var context = new AseguradoraContext())
        {
            context.Database.EnsureCreated();
        }
    }
}